<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid m-5">
<table class="table table-hover">
<thead>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>메모</th>
	<th>사진</th>
</tr>
</thead>
<tbody>

<c:forEach var="pb" items="${list}">
<tr onclick="location.href='/view?id=${pb.id}'">
	<td>${pb.id}</td>
	<td>${pb.name}</td>
	<td>${pb.hp}</td>
	<td>${pb.email}</td>
	<td>${pb.memo}</td>
	<td>${pb.imgfilename}</td>
</tr>
</c:forEach>

</tbody>
</table>
<button onclick="location.href='/insertf\orm'">전화번호부 입력</button> <!-- html링크를 uri로 변경 -->
</div>
</body>
</html>