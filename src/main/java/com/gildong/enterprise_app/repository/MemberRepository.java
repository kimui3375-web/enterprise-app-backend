package com.gildong.enterprise_app.repository;

import com.gildong.enterprise_app.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// <엔티티 타입, ID 타입>
public interface MemberRepository extends JpaRepository<Member, Long> {

    // username으로 회원을 찾고 싶을 때 사용할 메서드 (자동 구현됨)
    Member findByUsername(String username);
}
