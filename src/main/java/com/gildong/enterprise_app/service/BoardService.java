package com.gildong.enterprise_app.service;

import com.gildong.enterprise_app.domain.Board;
import com.gildong.enterprise_app.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 전체 목록
     */
    @Transactional(readOnly = true)
    public List<Board> getBoards() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * 게시글 단건 조회
     */
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다. id=" + id));
    }

    /**
     * 새 게시글 작성
     */
    @Transactional
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Board updateBoard(Long id, String title, String content, String writer) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("수정하려는 게시글이 존재하지 않습니다. id=" + id));

        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        return board;
    }

    /**
     * 게시글 삭제
     */
    @Transactional
    public void deleteBoard(Long id) {
        if (!boardRepository.existsById(id)) {
            throw new IllegalArgumentException("삭제하려는 게시글이 존재하지 않습니다. id=" + id);
        }
        boardRepository.deleteById(id);
    }
}
