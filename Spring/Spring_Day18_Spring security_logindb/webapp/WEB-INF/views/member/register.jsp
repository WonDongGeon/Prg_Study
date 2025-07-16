<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/member/register" method="post">
<div>
<label>아이디</label>
<input type="text" name="username">
</div>
<div>
<label>비밀번호</label>
<input type="password" name="password">
</div>
<div>
<label>이메일</label>
<input type="email" name="email">
</div>
<div>
<input type="submit" value="회원가입">
<!-- 회원가입폼에 있는 내용 전송시 403오류가 발생하는 원인 해결 -->
<input type="hidden" 
name="${_csrf.parameterName}"
value="${_csrf.token }" />
</div>
</form>
</body>
</html>