<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>학생정보입력</h1>
<form action="/insert" method="post">
학번:<input type="text" name="sid"><br>
이름:<input type="text" name="name"><br>
전화번호:<input type="text" name="hp"><br>
<input type="submit" values="학생정보입력">
</form>
</body>
</html>