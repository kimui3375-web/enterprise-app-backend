package com.gildong.enterprise_app.controller;

import com.gildong.enterprise_app.domain.Member;
import com.gildong.enterprise_app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 회원 관련 화면(목록 등)을 처리하는 컨트롤러
 *  - URL: /members
 *  - 역할: DB에서 회원 목록을 가져와 JSP에게 넘겨주는 것
 */
@Controller
@RequestMapping("/members") // 이 컨트롤러에 들어오는 기본 경로 앞부분
public class MemberController {

    // 🔽🔽🔽 변경 포인트 1: Repository 대신 Service 주입
    private final MemberService memberService;

    // 생성자 주입 (스프링이 MemberService를 자동으로 넣어줌)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    /**
     * 새 회원 등록 폼 화면
     *  - GET /members/new
     */
    @GetMapping("/new")
    public String newForm() {
        return "member/newForm";
    }
    /**
     * 새 회원 등록 처리
     *  - POST /members/new
     */
    @PostMapping("/new")
    public String createMember(@ModelAttribute Member member) {
        // 🔽🔽🔽 변경 포인트 2: Service를 통해 저장
        memberService.createMember(member);

        // 저장 후 목록으로 리다이렉트
        return "redirect:/members";
    }

    /**
     * 회원 목록 페이지
     *  - GET /members
     *  - 동작:
     *      1) 서비스에서 전체 회원 목록 조회
     *      2) Model에 담아서 JSP로 전달
     *      3) /WEB-INF/views/member/list.jsp 를 렌더링
     */
    @GetMapping
    public String list(Model model) {
        // 🔽🔽🔽 변경 포인트 3: Service 사용
        List<Member> members = memberService.getMembers();

        model.addAttribute("members", members);
        return "member/list";
    }
    /**
     * 회원 상세 페이지
     *  - GET /members/{id}
     *  - 예: /members/1
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {

        // 🔽🔽🔽 기존: memberRepository.findById(...)
        //          → 이제: memberService.getMember(id)
        Member member = memberService.getMember(id);

        model.addAttribute("member", member);

        return "member/detail"; // /WEB-INF/views/member/detail.jsp
    }

    // src/main/java/com/gildong/enterprise_app/controller/MemberController.java

    /**
     * 회원 수정 폼 페이지
     *  - GET /members/{id}/edit
     */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {

        // 1) id로 회원 한 명 조회 (없으면 예외)
        Member member = memberService.getMember(id);
        // 2) JSP에서 쓸 이름 "member"로 담기
        model.addAttribute("member", member);

        // 3) /WEB-INF/views/member/edit.jsp
        return "member/edit";
    }

    /**
     * 회원 수정 처리
     *  - POST /members/{id}/edit
     */
    @PostMapping("/{id}/edit")
    public String editSubmit(
            @PathVariable Long id,
            @RequestParam String username,
            @RequestParam String name,
            @RequestParam String email) {

        // 🔽🔽🔽 변경 포인트 4: 수정 로직을 Service로 위임
        memberService.updateMember(id, username, name, email);

        // 다시 상세 페이지로 리다이렉트
        return "redirect:/members/" + id;
    }
    /**
     * 회원 삭제
     *  - GET /members/{id}/delete
     */
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        // 🔽🔽🔽 변경 포인트 5: 삭제도 Service에게 맡김
        memberService.deleteMember(id);

        // 2) 목록 페이지로 리다이렉트
        return "redirect:/members";
    }
}
