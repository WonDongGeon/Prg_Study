<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//파일관련 form은 entype에 따라 전송을 받는 방법이 다르다.
//String filename = request.getParameter("file1");
//out.print(filename);

//요청이 multipart/form-data로 전송되어서,
//request.getParameter()로는 데이터를 못 읽을 때,
//바이트 단위로 직접 파싱하려고 할 때 

InputStream in = request.getInputStream(); // 클라이언트(브라우저)에서 보낸 HTTP 요청 바디(request body)를 바이트 단위로 읽기 위해 InputStream을 얻습니다.

//입력 스트림에서 한 바이트씩 읽습니다 (in.read()는 0~255 사이 숫자, 즉 아스키 문자 코드 하나를 반환).
int data = -1;
while((data=in.read()) != -1) { //-1이 나올 때까지 반복하며,
	out.print((char)data); //읽은 바이트를 (char)로 캐스팅해서 문자처럼 출력
}
%>