<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 600px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px 12px;
            text-align: left;
        }

        th {
            background-color: #f5f5f5;
        }

        tr:nth-child(even) {
            background-color: #fafafa;
        }

        .home-link {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>회원 목록</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>아이디(username)</th>
        <th>이름(name)</th>
        <th>이메일(email)</th>
    </tr>
    </thead>
    <tbody>
    <!-- members 는 MemberController에서 model.addAttribute("members", members) 로 넘겨준 리스트 -->
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.id}</td>
            <td>${member.username}</td>
            <td>${member.name}</td>
            <td>${member.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="home-link">
    <a href="/members/${member.id}">
</div>

</body>
</html>
