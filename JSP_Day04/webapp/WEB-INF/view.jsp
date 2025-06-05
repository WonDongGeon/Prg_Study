<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view.jsp</title>
</head>
<body>
<!-- 비어있을 경우 -->
<c:if test="${not empty pb}"> <!-- nq은 !=(pb nq null), empty은 비었는지(not empty pb) -->
<h1>전화번호 상세보기</h1>
<ul>
<li><img src="/img/${pb.imgfilename}"width="200" alt="${pb.imgfilename}" style="border-radius:100%; border:1px solid block"></li>
<li>아이디 : ${pb.id}</li>
<li>이름 : ${pb.name}</li>
<li>전화번호 : ${pb.hp}</li>
<li>이메일 : ${pb.email}</li>
<li>메모 : ${pb.memo}</li>
</ul>
<button onclick="location.href='/updateform?id=${pb.id}'">수정</button>
<button onclick="location.href='/delete?id=${pb.id}'">삭제</button>
</c:if>
<!-- 비어있을 경우 -->
<c:if test="${empty pb}">
<script>
alert("찾는 데이터가 없습니다.");
location.href="/searchid.html";
</script>
</c:if>
</body>
</html>