<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- security에서는 모든 폼에 토큰이 생성되어야 403에러 발생하지 않음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN</h1>
<form action="<c:url value='/login'/>" method="post">
<div>
<label>아이디</label>
<input type="text" name="username">
</div>
<div>
<label>비밀번호</label>
<input type="password" name="password">
</div>
<div>
<input type="submit" value="로그인">
</div>
<input type="hidden" 
name="${_csrf.parameterName}"
value="${_csrf.token }" />
</form>
<a href="/register">회원가입</a>

</body>
</html>