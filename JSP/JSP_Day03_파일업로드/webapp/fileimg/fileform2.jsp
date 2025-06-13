<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileform2.jsp | webapp/fileimg/fileform2.jsp</title>
</head>
<body>
<form action="/fileimg/fileform2_proc.jsp" method="post" enctype="multipart/form-data"> 
<!-- enctype="multipart/form-data"는 파일을 바이너리 형식으로 전송하게 해주는 필수 설정 -->
<input type="text" name="name" id="name"><br>
<input type="text" name="hp" id="hp"><br>
<input type="file" name="file1" id="file1"><br>
<input type="submit" value="업로드">
</form>
</body>
</html>