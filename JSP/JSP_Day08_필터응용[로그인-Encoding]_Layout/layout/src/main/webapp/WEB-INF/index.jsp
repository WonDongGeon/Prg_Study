<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//request.setAttribute("mainpage", "creatememberform"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/webapp/index.jsp</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="stylesheet" href="/style/menu.css"> 
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp" />
<main>
<jsp:include page="/WEB-INF/${mainpage}" />
</main>
<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>