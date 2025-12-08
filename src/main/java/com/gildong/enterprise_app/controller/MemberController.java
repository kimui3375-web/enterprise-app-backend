package com.gildong.enterprise_app.controller;

import com.gildong.enterprise_app.domain.Member;
import com.gildong.enterprise_app.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
