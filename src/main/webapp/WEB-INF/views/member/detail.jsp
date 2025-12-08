<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 상세 정보</title>
</head>
<body>

<h1>회원 상세 정보</h1>

<p>ID: ${member.id}</p>
<p>아이디(username): ${member.username}</p>
<p>이름(name): ${member.name}</p>
<p>이메일(email): ${member.email}</p>

<a href="/members">회원 목록으로 돌아가기</a>

</body>
</html>
