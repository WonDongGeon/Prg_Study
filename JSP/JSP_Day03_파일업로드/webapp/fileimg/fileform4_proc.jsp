<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//파일관련 form은 enctype에 따라 전송을 받는 방법이 다르다.
//String filename=request.getParameter("file1");
//out.print(filename);

InputStream in=request.getInputStream();

int data=-1;
while((data=in.read())!=-1){
	out.print((char)data);
}
%>