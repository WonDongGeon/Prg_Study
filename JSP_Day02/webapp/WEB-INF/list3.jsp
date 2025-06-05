<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="phonebook.Phonebook"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- data get하기 위한 code -->
<!-- html이랑 java 코드 분리했을 때 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<table border="1">
<thead>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>메모</th>
</tr>
</thead>
<tbody>
<%
List<Phonebook> list = (List<Phonebook>)request.getAttribute("list");
for(Phonebook pb: list) {
%>
<tr>
	<td><%=pb.getId()%></td>
	<td><%=pb.getName()%></td>
	<td><%=pb.getHp()%></td>
	<td><%=pb.getEmail()%></td>
	<td><%=pb.getMemo()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>