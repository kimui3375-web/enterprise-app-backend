package com.gildong.enterprise_app.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 게시판 글 엔티티
 *  - 추후 Member와 연관관계를 맺을 수도 있지만,
 *    현재는 작성자 이름을 문자열로만 보관
 */
@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // PK

    @Column(nullable = false, length = 200)
    private String title;       // 제목

    @Lob
    @Column(nullable = false)
    private String content;     // 내용 (긴 글)

    @Column(nullable = false, length = 50)
    private String writer;      // 작성자 이름(또는 아이디 문자열)

    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성 시간

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 수정 시간

    // JPA가 사용하기 위한 기본 생성자
    protected Board() {
    }

    // 편의상 사용하는 생성자 (필요하면 사용)
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    // === 라이프사이클 콜백 ===
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // === Getter / Setter ===

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
