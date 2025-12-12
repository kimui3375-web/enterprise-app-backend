package com.gildong.enterprise_app.controller;

import com.gildong.enterprise_app.domain.Board;
import com.gildong.enterprise_app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 화면을 처리하는 컨트롤러
 *  - URL: /boards
 */
@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시글 목록
     *  - GET /boards
     */
    @GetMapping
    public String list(Model model) {
        List<Board> boards = boardService.getBoards();
        model.addAttribute("boards", boards);
        return "board/list"; // /WEB-INF/views/board/list.jsp (다음 스텝에서 생성)
    }

    /**
     * 게시글 상세
     *  - GET /boards/{id}
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board/detail"; // /WEB-INF/views/board/detail.jsp
    }

    /**
     * 새 게시글 작성 폼
     *  - GET /boards/new
     */
    @GetMapping("/new")
    public String newForm() {
        return "board/newForm"; // /WEB-INF/views/board/newForm.jsp
    }

    /**
     * 새 게시글 등록 처리
     *  - POST /boards/new
     */
    @PostMapping("/new")
    public String create(@ModelAttribute Board board) {
        boardService.createBoard(board);
        return "redirect:/boards";
    }

    /**
     * 게시글 수정 폼
     *  - GET /boards/{id}/edit
     */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board/edit"; // /WEB-INF/views/board/edit.jsp
    }

    /**
     * 게시글 수정 처리
     *  - POST /boards/{id}/edit
     */
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String content,
                       @RequestParam String writer) {

        boardService.updateBoard(id, title, content, writer);
        return "redirect:/boards/" + id;
    }

    /**
     * 게시글 삭제
     *  - GET /boards/{id}/delete
     */
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }
}
