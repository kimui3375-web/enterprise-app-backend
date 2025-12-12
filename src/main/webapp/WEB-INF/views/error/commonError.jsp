<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>에러 발생</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 40px;
        }
        .error-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            padding: 24px 28px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .error-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 16px;
            color: #d32f2f;
        }
        .error-message {
            font-size: 14px;
            margin-bottom: 24px;
            color: #333;
        }
        .error-footer {
            font-size: 12px;
            color: #777;
        }
        a.button {
            display: inline-block;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            border: 1px solid #1976d2;
            color: #1976d2;
            font-size: 13px;
        }
        a.button:hover {
            background-color: #1976d2;
            color: white;
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="error-title">서비스 처리 중 오류가 발생했습니다.</div>

    <div class="error-message">
        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
        <c:if test="${empty errorMessage}">
            알 수 없는 오류가 발생했습니다. 잠시 후 다시 시도해주세요.
        </c:if>
    </div>

    <a href="/members" class="button">회원 목록으로 돌아가기</a>

    <div class="error-footer">
        문제가 계속될 경우 관리자에게 문의해주세요.
    </div>
</div>
</body>
</html>
