<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<div class="container-fluid">
<table class="table table-hover">
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
//java code
Class.forName("org.h2.Driver");
Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

String sql = "select * from phonebook";
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();		
while(rs.next()) {
%>
<tr>
	<td><%=rs.getInt("id")%></td>
	<td><%=rs.getString("name")%></td>
	<td><%=rs.getString("hp")%></td>
	<td><%=rs.getString("email")%></td>
	<td><%=rs.getString("memo")%></td>
</tr>
<%
}
rs.close();
ps.close();
conn.close();
%>
</tbody>
</table>
</div>
</body>
</html>