<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<c:if test="${not empty id}">
<a href="/logout">로그아웃[${id}]</a>
</c:if>

<c:if test="${empty id}">
<form action="/login" method="post">
<input type="text" name="id" id="id" placeholder="아이디"><br>
<input type="password" name="password" id="password" 
placeholder="패스워드"><br>
<a href="/creatememberform">회원가입</a>
<a href="#">아이디찾기</a>/<a href="#">패스워드찾기</a><br>
<input type="submit" value="로그인">
</form>
</c:if>
</div>

</body>
</html>