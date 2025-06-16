<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/webapp/deletecookie.jsp</title>
</head>
<body>

</body>
</html>
<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie cookie: cookies){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
%>