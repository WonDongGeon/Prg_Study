<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
user index페이지 입니다.<br>
<sec:authentication property="principal" var="user"/>
<a href="#">[${user.username}]</>
<form action="/logout" method="post">
<input type="submit" value="로그아웃">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
</form>
</body>
</html>