<%@page import="phonebook.Phonebook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Phonebook pb = (Phonebook)request.getAttribute("pb"); %>
<% if(pb != null) { %>
<h1>전화번호 상세보기</h1>
<ul>
<li>아이디 : <%= pb.getId() %></li>
<li>이름 : <%= pb.getName() %></li>
<li>전화번호 : <%= pb.getHp() %></li>
<li>이메일 : <%= pb.getEmail() %></li>
<li>메모 : <%= pb.getMemo() %></li>
</ul>
<button onclick="location.href='/phonebook/updateform?id=<%=pb.getId()%>'">수정</button>
<button onclick="location.href='/phonebook/delete?id=<%=pb.getId()%>'">삭제</button>
<% } else { %>
<script>
alert("찾는 데이터가 없습니다.");
location.href="/index.jsp";
</script>
<% } %>
</body>
</html>