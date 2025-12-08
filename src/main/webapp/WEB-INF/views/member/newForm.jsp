<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>새 회원 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            margin-bottom: 20px;
        }

        form {
            width: 400px;
        }

        .form-row {
            margin-bottom: 12px;
        }

        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"] {
            width: 220px;
            padding: 6px;
            box-sizing: border-box;
        }

        .actions {
            margin-top: 16px;
        }

        button {
            padding: 6px 12px;
        }

        a {
            margin-left: 8px;
        }
    </style>
</head>
<body>

<h1>새 회원 등록</h1>

<form action="/members/new" method="post">
    <div class="form-row">
        <label for="username">아이디(username)</label>
        <input type="text" id="username" name="username" required>
    </div>

    <div class="form-row">
        <label for="name">이름(name)</label>
        <input type="text" id="name" name="name" required>
    </div>

    <div class="form-row">
        <label for="email">이메일(email)</label>
        <input type="email" id="email" name="email" required>
    </div>

    <div class="actions">
        <button type="submit">등록하기</button>
        <a href="/members">목록으로 돌아가기</a>
    </div>
</form>

</body>
</html>
