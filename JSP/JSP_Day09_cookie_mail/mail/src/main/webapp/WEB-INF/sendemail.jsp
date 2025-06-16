<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>메일보내기</h3>
<form action="/mail/sendemail" method="post">
<input type="email" name="recvemail" placeholder="받는주소입력"><br>
<input type="text" name="subject" placeholder="제목입력"><br>
<!-- <input type="text" name="content" placeholder="내용입력"><br> -->
<textarea rows="10" cols="20" name="content"></textarea><br>
<input type="submit" value="메일보내기">
</form>
</body>
</html>