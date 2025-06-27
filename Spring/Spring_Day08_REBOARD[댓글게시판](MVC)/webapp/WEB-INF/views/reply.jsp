<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>댓글 입력 폼</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 제목에 부모글의 제목을 활용 -->
<c:set var="re" value=""/>
<c:forEach var ="i" begin="0" end="${tab}">
<c:set var="re" value="${re}re:"/>
</c:forEach>
    <div class="container mt-5">
        <h2>댓글 입력 폼</h2>
        <form action="/reboard/reply" method="post" enctype = "multipart/form-data">
        
        	<!-- 부모글의 번호 숨김 -->
        	<div class="mb-3">
        		<input type="hidden" name="parentid" required value="${parentid}">
        	</div>
        
            <!-- 제목 -->
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" required value="${re}${title}:">
            </div>

            <!-- 내용 -->
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="4" required></textarea>
            </div>

            <!-- 첨부파일 -->
            <div class="mb-3">
                <label for="attachment" class="form-label">첨부파일</label>
                <input type="file" class="form-control" id="attachment" name="attachment">
            </div>

            <!-- 작성자 -->
            <div class="mb-3">
                <label for="author" class="form-label">작성자</label>
                <input type="text" class="form-control" id="author" name="author" required>
            </div>
            
			 <!-- 제출 버튼 -->
    		<button type="submit" class="btn btn-primary">댓글 등록</button>
        </form>
    </div>

    <!-- Bootstrap JS (선택사항) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>