package com.gildong.enterprise_app.service;

import com.gildong.enterprise_app.domain.Member;
import com.gildong.enterprise_app.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Service 계층을 나타내는 스테레오타입
@Transactional(readOnly = true) // 기본은 조회용 트랜잭션
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자 주입 (Lombok 안 쓰고 순수 자바 방식)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     *  - 나중에 예외 공통 처리할 때 여기서 던지는 예외를 잡아 에러 페이지로 보낼 예정
     */
    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 회원입니다. id=" + id));
    }

    /**
     * 회원 저장 (회원 등록)
     */
    @Transactional // 쓰기 작업이므로 readOnly=false 기본 동작을 사용
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    /**
     * 회원 수정
     *  - id로 회원을 찾아서 필드만 변경하면,
     *    JPA가 트랜잭션 커밋 시점에 변경 내용을 자동으로 업데이트 해줍니다.
     */
    @Transactional
    public Member updateMember(Long id, String username, String name, String email) {
        Member findMember = memberRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("수정하려는 회원이 존재하지 않습니다. id=" + id));

        // 필요한 필드만 수정 (도메인 규칙이 생기면 여기서 처리)
        findMember.setUsername(username);
        findMember.setName(name);
        findMember.setEmail(email);

        // 별도로 save() 호출 안 해도 됨 (영속성 컨텍스트에 의해 자동 반영)
        return findMember;
    }

    /**
     * 회원 삭제
     */
    @Transactional
    public void deleteMember(Long id) {
        // 존재 여부 검증을 하고 삭제하는 편이 안전
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isEmpty()) {
            throw new IllegalArgumentException("삭제하려는 회원이 존재하지 않습니다. id=" + id);
        }
        memberRepository.deleteById(id);
    }
}
