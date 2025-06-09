<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileform1.jsp | webapp/fileimg/fileform1.jsp</title>
</head>
<body>
<!-- 
webapp/img 폴더 생성(리소스 넣을 곳) 
webapp/img/img.jpg -> localhost:8888/img/bt.jpg
-->
<form action="/fileimg/fileform1_proc.jsp" method="post" enctype="multipart/form-data"> 
<!-- enctype="multipart/form-data"는 파일을 바이너리 형식으로 전송하게 해주는 필수 설정 -->
<input type="file" name="file1" id="file1">
<input type="submit" value="업로드">
</form>
</body>
</html>