<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시판 목록</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        h1 { margin-bottom: 16px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; font-size: 14px; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: #1976d2; }
        a:hover { text-decoration: underline; }
        .top-actions { margin-bottom: 12px; }
    </style>
</head>
<body>

<h1>게시판</h1>

<div class="top-actions">
    <a href="/boards/new">➕ 새 글 작성</a>
    &nbsp;|&nbsp;
    <a href="/members">회원 목록으로</a>
</div>

<table>
    <thead>
    <tr>
        <th style="width: 60px;">번호</th>
        <th>제목</th>
        <th style="width: 160px;">작성자</th>
        <th style="width: 220px;">등록일(LocalDateTime)</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty boards}">
        <tr>
            <td colspan="4" style="text-align: center;">등록된 게시글이 없습니다.</td>
        </tr>
    </c:if>

    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.id}</td>
            <td>
                <a href="/boards/${board.id}">
                    <c:out value="${board.title}" />
                </a>
            </td>
            <td><c:out value="${board.writer}" /></td>
            <td>
                <c:set var="createdStr" value="${board.createdAt}" />
                ${fn:substring(fn:replace(createdStr, 'T', ' '), 0, 16)}
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
