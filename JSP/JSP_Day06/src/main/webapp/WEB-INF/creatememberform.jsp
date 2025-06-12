<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="data:;base64,=">
</head>
<body>
<form action="/createmember" method="post">
<ul>
<li><input type="text" name="id" placeholder="아이디" required></li>
<li><input type="password" name="password" placeholder="비밀번호" required></li>
<li><input type="password" name="repassword" placeholder="재확인비밀번호" required></li>
<li><input type="text" name="hp" placeholder="전화번호" required></li>
<li><input type="email" name="email" placeholder="이메일" required></li>
<li><input type="text" name="address" placeholder="주소" required></li>
<li><input type="file" name="pic" placeholder="사진"></li>
<li><input type="submit" value="회원가입">
<input type="reset" value="취소"></li>
</ul>
</form>
<script>
//태그별로 id, 유효성검사(빈란, 길이, 형식)
let input=document.querySelectorAll("input");
</script>
</body>
</html>