<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>부트스트랩 입력 폼</title>
  <!-- Bootstrap 5 CSS CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome CDN (head 안에 넣기) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
</head>
<body>
  <div class="container mt-5">
  	<!-- 홈 아이콘 -->
    <div class="mb-3 text-start">
        <a href="/" title="홈으로 이동">
            <i class="fas fa-home" style="font-size:24px; cursor:pointer;"> 홈으로 이동</i>
        </a>
    </div>
    <h2 class="mb-4">정보 수정 폼</h2>
    <form action="/phonebook/update" method="post">
    
      <div class="mb-3">
        <label for="id" class="form-label">아이디</label>
        <input type="text" class="form-control" id="id" name="id" value="${pb.id}" readOnly disabled>
        <input type="hidden" class="form-control" id="id" name="id" value="${pb.id}"> 
        <!-- 위에 disable이면 값을 받아올 떄 0으로 표시되지만 밑에 hidden으로 숨긴 상태로 값을 전달하면 제대로 아이디가 표시됨 -->
      </div>
      
      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" id="name" name="name" value="${pb.name}">
      </div>

      <div class="mb-3">
        <label for="hp" class="form-label">휴대폰</label>
        <input type="tel" class="form-control" id="hp" name="hp" value="${pb.hp}">
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input type="email" class="form-control" id="email" name="email" value="${pb.email}">
      </div>

      <div class="mb-3">
        <label for="memo" class="form-label">메모</label>
        <textarea class="form-control" id="memo" name="memo" rows="4">${pb.memo}</textarea>
      </div>

      <button type="submit" class="btn btn-primary">전화번호 수정</button>
    </form>
  </div>
  
	
  <!-- Bootstrap 5 JS (선택 사항) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>