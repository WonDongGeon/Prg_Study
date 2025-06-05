<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertform.html</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div  class="container-fluid mt-5">
<form action="/insert" method="post" enctype="multipart/form-data">
<h3>전화번호부 입력</h3>
<div  class="pb-3">
<label class ="form-label" for="name">이름</label>
<input class="form-control" type="text" id="name" name="name" required>
</div>
<div  class="pb-3">
<label class ="form-label" for="hp">전화번호</label>
<input class="form-control" type="text" id="hp" name="hp" required>
</div>
<div  class="pb-3">
<label class ="form-label" for="email">이메일</label>
<input class="form-control" type="email" id="email" name="email" required>
</div>
<div  class="pb-3">
<label class ="form-label" for="memo">메모</label>
<input class="form-control" type="text" id="memo" name="memo" required>
</div>
<div  class="pb-3">
<label class ="form-label" for="imgfilename">사진</label>
<input class="form-control" type="file" id="file" name="file">
</div>
<input class="form-control bg-primary text-white" type="submit" value="전화번호부 입력">
</form>
</div>
</body>
</html>