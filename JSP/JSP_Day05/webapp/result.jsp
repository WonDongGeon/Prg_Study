<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%= request.getAttribute("id") %><Br>
<%= request.getSession().getAttribute("id") %>
context(application);
<%=request.getServletContext().getAttribute("id") %><br>
<a href="/login.jsp">로그아웃 페이지 이동</a>