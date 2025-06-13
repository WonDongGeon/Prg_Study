<%@page import="java.util.List"%>
<%@page import="phonebook.Phonebook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="container">
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
List<Phonebook> list=(List<Phonebook>)request.getAttribute("list");
for(Phonebook pb:list) {
%>
<tr onclick="location.href='/phonebook/view?id=<%=pb.getId()%>'">
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
</div>
</body>
</html>