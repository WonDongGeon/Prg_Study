<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/webapp/clientviewcookie.jsp</title>
</head>
<body>
클라이언트(request)에 있는 쿠키를 서버로 가져와서 클라이언트 화면에 표시<br>

<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
for(Cookie cookie:cookies){
	out.print(cookie.getName());
	out.print(":");
	out.print(cookie.getValue());
	out.print("<br>");
}
}
%>
</body>
</html>







