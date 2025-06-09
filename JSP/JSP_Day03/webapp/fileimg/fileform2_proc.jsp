<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
*/
//필요한 입력사항 데이터스트림 객체, 파일 저장 위치, 파일 크기 제한, 엔코딩, 파일 이름 정책
MultipartRequest multi = new MultipartRequest(
	request, // 데이터스트림 객체
	"D:/work/eclipse-workspace/Phonebook/src/main/webapp/img", // 파일 저장 위치
	5*1024*1024, // 파일 크기 제한
	"UTF-8", // 엔코딩
	new DefaultFileRenamePolicy() // 파일 이름 정책 : 같은 이름의 파일이 있으면 자동으로 이름을 바꿔서 저장
);
// 위 객체 실행만으로 파일은 자동으로 다운로드 됨
String name = multi.getParameter("name"); // 텍스트 파일 내용 확인
String hp = multi.getParameter("hp"); 
out.print(name+"<br>");
out.print(hp+"<br>");

//파일의 내용 확인 과정
Enumeration<?> files = multi.getFileNames(); // 여러개의 파일인지 확인, name 속성들을 가져옴
String filename = (String)files.nextElement(); // 다음이 있는지 여부를 확인하는 함수가 존재, tag의 name 획득
out.print(filename+"<br>");
//tag의 name으로 찾을 수 있는 두 가지 정보는? 원본파일이름, 정책에 의한 파일이름
out.print(multi.getOriginalFileName(filename)+"<br>"); // 원본 파일의 파일명
out.print(multi.getFilesystemName(filename)+"<br>"); // 정책에 파일명
%>