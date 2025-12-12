<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>새 게시글 작성</title>
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

<h1>새 게시글 작성</h1>

<form action="/boards/new" method="post">
    <label for="title">제목</label>
    <input type="text" id="title" name="title" required />

    <label for="writer">작성자</label>
    <input type="text" id="writer" name="writer" required />

    <label for="content">내용</label>
    <textarea id="content" name="content" required></textarea>

    <div class="actions">
        <button type="submit">등록</button>
        <a href="/boards" class="button">목록으로</a>
    </div>
</form>

</body>
</html>
