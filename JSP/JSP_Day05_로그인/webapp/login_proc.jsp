<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_proc.jsp</title>
</head>
<body>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
if(id.equals("admin") && password.equals("1234")) {
	request.setAttribute("id", "admin");
	request.getSession().setAttribute("id", "admin");
	request.getServletContext().setAttribute("id", "admin");
	System.out.println("로그인성공!!");
}else {
	//로그인이 실패할 경우 getAttribute("id")의 값은 null값인 상태가 됨.
	System.out.println("로그인실패!!");
}
//로그인의 결과를 저장하고 result.jsp에서 결과 확인
response.sendRedirect("/result.jsp");
//request.getRequestDispatcher("result.jsp").forward(request, response);
%>
<%= id %><br>
<%= password %><Br>
</body>
</html>