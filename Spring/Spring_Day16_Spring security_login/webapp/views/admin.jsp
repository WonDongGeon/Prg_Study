<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>admin page입니다.</p>
<p>Authenticated User: ${principal.username}</p>
<a href="/logout">로그아웃</a>
</body>
</html>