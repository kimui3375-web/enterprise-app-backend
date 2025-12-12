<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        h1 { margin-bottom: 16px; }
        .meta { font-size: 13px; color: #555; margin-bottom: 12px; }
        .content-box {
            border: 1px solid #ddd;
            padding: 16px;
            border-radius: 4px;
            min-height: 150px;
            white-space: pre-wrap;
        }
        .actions { margin-top: 16px; }
        a { text-decoration: none; color: #1976d2; margin-right: 8px; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<h1><c:out value="${board.title}" /></h1>

<div class="meta">
    작성자: <strong><c:out value="${board.writer}" /></strong><br/>

    <c:set var="createdStr" value="${board.createdAt}" />
    <c:set var="updatedStr" value="${board.updatedAt}" />

    작성일:
    ${fn:substring(fn:replace(createdStr, 'T', ' '), 0, 16)}<br/>

    수정일:
    ${fn:substring(fn:replace(updatedStr, 'T', ' '), 0, 16)}
</div>


<div class="content-box">
    <c:out value="${board.content}" />
</div>

<div class="actions">
    <a href="/boards/${board.id}/edit">✏️ 수정</a>
    <a href="/boards/${board.id}/delete"
       onclick="return confirm('정말 삭제하시겠습니까?');">🗑 삭제</a>
    <a href="/boards">목록으로</a>
</div>

</body>
</html>
