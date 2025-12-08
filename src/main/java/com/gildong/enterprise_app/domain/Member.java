package com.gildong.enterprise_app.domain;

import jakarta.persistence.*;

@Entity                     // 이 클래스는 JPA 엔티티(=테이블과 매핑됨)
@Table(name = "member")     // 테이블 이름: member
public class Member {

    @Id                     // 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;    // 로그인 아이디 느낌

    @Column(nullable = false, length = 100)
    private String name;        // 실명

    @Column(nullable = false, length = 100)
    private String email;

    // 기본 생성자는 JPA가 사용할 용도
    protected Member() {}

    // 편하게 쓸 수 있는 생성자
    public Member(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    // Getter / Setter (우선은 Getter만 있어도 됨)
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
