<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- /webapp/image/file.png localhost:8888/image/file.png
11 접근이 안되는 이유는 Spring framework에서 필터처리되므로 통과되지 않는 상태임 
방법1)web.xml : servlet-mapping의 default에 url을 *.png
방법2)dispatcher-servlet.xml : mvc의 resources에 맵핑 등록
-->
<img src="/image/file.png" alt="파일이미지" width="100px">
</body>
</html>