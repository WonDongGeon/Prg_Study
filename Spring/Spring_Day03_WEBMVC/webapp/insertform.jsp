<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertform.jsp</title>
<!-- Bootstrap CDN 링크 -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">입력 폼</h2>
    <form action="/insert" method="post">
      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력">
      </div>

      <div class="mb-3">
        <label for="hp" class="form-label">전화번호</label>
        <input type="text" class="form-control" id="hp" name="hp" placeholder="010-0000-0000">
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="example@example.com">
      </div>

      <div class="mb-3">
        <label for="memo" class="form-label">메모</label>
        <textarea class="form-control" id="memo" name="memo" rows="4" placeholder="내용을 입력하세요"></textarea>
      </div>

      <button type="submit" class="btn btn-primary">추가</button>
    </form>
  </div>
</body>
</html>