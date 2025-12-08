<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>

<h1>회원 정보 수정</h1>

<form action="/members/${member.id}/edit" method="post">

    <p>
        ID: ${member.id}
    </p>

    <p>
        아이디(username):
        <input type="text" name="username" value="${member.username}">
    </p>

    <p>
        이름(name):
        <input type="text" name="name" value="${member.name}">
    </p>

    <p>
        이메일(email):
        <input type="email" name="email" value="${member.email}">
    </p>

    <button type="submit">저장</button>
</form>


<p>
    <a href="/members/${member.id}">상세 페이지로 돌아가기</a>
</p>

</body>
</html>
