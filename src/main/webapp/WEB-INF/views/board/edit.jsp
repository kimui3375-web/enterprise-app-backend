<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 수정</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        h1 { margin-bottom: 16px; }
        form { max-width: 600px; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input[type="text"] {
            width: 100%;
            padding: 6px 8px;
            margin-top: 4px;
            box-sizing: border-box;
        }
        textarea {
            width: 100%;
            height: 200px;
            padding: 6px 8px;
            margin-top: 4px;
            box-sizing: border-box;
        }
        .actions { margin-top: 16px; }
        button, a.button {
            display: inline-block;
            padding: 8px 16px;
            border-radius: 4px;
            border: 1px solid #1976d2;
            background-color: #1976d2;
            color: white;
            font-size: 13px;
            cursor: pointer;
            text-decoration: none;
        }
        a.button {
            background-color: white;
            color: #1976d2;
        }
    </style>
</head>
<body>

<h1>게시글 수정</h1>

<form action="/boards/${board.id}/edit" method="post">
    <label for="title">제목</label>
    <input type="text" id="title" name="title"
           value="<c:out value='${board.title}'/>" required />

    <label for="writer">작성자</label>
    <input type="text" id="writer" name="writer"
           value="<c:out value='${board.writer}'/>" required />

    <label for="content">내용</label>
    <textarea id="content" name="content" required><c:out value='${board.content}'/></textarea>

    <div class="actions">
        <button type="submit">수정 완료</button>
        <a href="/boards/${board.id}" class="button">취소</a>
    </div>
</form>

</body>
</html>
