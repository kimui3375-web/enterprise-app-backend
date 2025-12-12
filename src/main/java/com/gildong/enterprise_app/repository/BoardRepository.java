package com.gildong.enterprise_app.repository;

import com.gildong.enterprise_app.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 게시글 엔티티(Board)에 대한 JPA 레포지토리
 *  - 기본 CRUD 메서드 제공
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 추후에 제목 검색, 작성자 검색 등이 필요하면
    // 메서드 이름 기반 쿼리로 추가 가능:
    // List<Board> findByTitleContaining(String keyword);
}
