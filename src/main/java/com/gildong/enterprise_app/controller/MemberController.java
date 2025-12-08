package com.gildong.enterprise_app.controller;

import com.gildong.enterprise_app.domain.Member;
import com.gildong.enterprise_app.repository.MemberRepository;
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

    // DB 접근을 위해 JPA 레포지토리 주입
    private final MemberRepository memberRepository;

    // 생성자 주입 (스프링이 MemberRepository를 자동으로 넣어줌)
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 새 회원 등록 폼 화면
     *  - GET /members/new
     */
    @GetMapping("/new")
    public String newForm() {
        // /WEB-INF/views/member/newForm.jsp 를 렌더링
        return "member/newForm";
    }
    /**
     * 새 회원 등록 처리
     *  - POST /members/new
     */
    @PostMapping("/new")
    public String createMember(@ModelAttribute Member member) {
        // 폼에서 넘어온 값으로 DB 저장
        memberRepository.save(member);

        // 저장 후 목록으로 리다이렉트
        return "redirect:/members";
    }

    /**
     * 회원 목록 페이지
     *  - GET /members
     *  - 동작:
     *      1) DB에서 전체 회원 목록 조회
     *      2) Model에 담아서 JSP로 전달
     *      3) /WEB-INF/views/member/list.jsp 를 렌더링
     */
    @GetMapping
    public String list(Model model) {
        // 1) DB에서 전체 회원 목록 조회
        List<Member> members = memberRepository.findAll();

        // 2) JSP에서 사용할 이름 "members" 로 데이터 담기
        model.addAttribute("members", members);

        // 3) /WEB-INF/views/member/list.jsp 를 찾아가서 렌더링
        //    (prefix + "member/list" + suffix)
        return "member/list";
    }
    /**
     * 회원 상세 페이지
     *  - GET /members/{id}
     *  - 예: /members/1
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다. id=" + id));

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
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다. id=" + id));

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
            @ModelAttribute Member formMember) {

        // 1) 기존 회원 조회
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다. id=" + id));

        // 2) 수정할 필드만 덮어쓰기
        member.setUsername(formMember.getUsername());
        member.setName(formMember.getName());
        member.setEmail(formMember.getEmail());

        // 3) 저장 (JPA가 update 쿼리 날림)
        memberRepository.save(member);

        // 4) 다시 상세 페이지로 리다이렉트
        return "redirect:/members/" + id;
    }
    /**
     * 회원 삭제
     *  - GET /members/{id}/delete
     */
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        // 1) 해당 id 회원 삭제
        memberRepository.deleteById(id);

        // 2) 목록 페이지로 리다이렉트
        return "redirect:/members";
    }
}
