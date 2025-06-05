<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="image/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- streaming.jsp 스트림으로 /WEB-INF/resources/img.jpg 표현 -->
<%
out.print(application.getRealPath("/")); //JSP에서 서버 실제 경로(절대 경로)를 구하는 코드 : /는 웹 애플리케이션의 루트 경로 (webapp/ 폴더)를 의미
String imgpath = application.getRealPath("/") + "WEB-INF/resources/bt.jpg"; // "WEB-INF/resources/bt.jpg" 경로를 문자열로 이어붙여서 실제 이미지 파일의 경로를 만듦

File imgfile=new File(imgpath); // 파일 경로를 이용해 File 객체를 생성
if(imgfile.exists()) { // 파일이 존재할 경우의 처리
	//파일을 가지고 왔다는 것은 하드디스크(보조저장장치)를 변수(주메모리) 복사하기 위한 스트림(inputStream)
	//변수에 있는 내용을 네트워크로 전달하기 위한 스트림(outputStream)
	try (
	FileInputStream ins = new FileInputStream(imgfile);
	OutputStream outs = response.getOutputStream();
	){
		byte[] buffer= new byte[1024];
		int readBytes;
		//네트워크상에서 파일을 보낼 때 파일의 크기를 알아야 보내는 양이 정해진다.
		response.setContentLength((int)imgfile.length());
		
		//반복문을 통해서 파일을 전송
		while((readBytes = ins.read(buffer)) != -1) { // .read(buffer) : 여러 장을 읽게 됨. -1이면 더 이상 읽을 것이 없다는 의미
			outs.write(buffer, 0, readBytes);
		}
		outs.flush();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
%>