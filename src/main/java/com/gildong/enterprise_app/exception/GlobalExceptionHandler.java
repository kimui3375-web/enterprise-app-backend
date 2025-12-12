package com.gildong.enterprise_app.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 애플리케이션 전역에서 발생하는 예외를 한 곳에서 처리하는 클래스
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비즈니스 로직에서 잘못된 요청 등으로 발생한 IllegalArgumentException 처리
     *  - 예: 존재하지 않는 회원 id로 조회
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException e, Model model) {

        // 에러 메시지를 뷰로 전달
        model.addAttribute("errorMessage", e.getMessage());

        // /WEB-INF/views/error/commonError.jsp 로 포워딩
        return "error/commonError";
    }

    /**
     * 그 밖의 처리되지 않은 예외에 대한 공통 처리
     *  - 필요 시 로그만 남기고 같은 에러 페이지로 보낼 수 있음
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {

        // 로그용으로 메세지 전달 (실서비스에서는 로그백/슬랙 연동도 가능)
        model.addAttribute("errorMessage", "알 수 없는 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");

        // 디버깅용으로 상세 메시지를 보고 싶다면 주석 해제해서 사용
        // model.addAttribute("detailMessage", e.getMessage());

        return "error/commonError";
    }
}
