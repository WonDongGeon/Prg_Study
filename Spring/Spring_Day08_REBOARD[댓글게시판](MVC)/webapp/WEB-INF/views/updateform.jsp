<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 수정</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
        <button class="btn btn-primary btn-lg mb-4" onclick="location.href='/reboard/view?id=${page.id}'">뒤로가기</button>

        <h2>글 수정</h2>

        <form action="/reboard/update" method="post" enctype="multipart/form-data">
            <!-- ID (hidden으로 유지) -->
            <input type="hidden" name="id" value="${page.id}"/>

            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" value="${page.title}" required>
            </div>

            <div class="mb-3">
                <label for="author" class="form-label">작성자</label>
                <input type="text" class="form-control" id="author" name="author" value="${page.author}" required>
            </div>

            <div class="mb-3">
                <label for="createdate" class="form-label">작성일</label>
                <input type="text" class="form-control" id="date" value="${page.createdate}" readonly>
                <input type="hidden" name="date" value="${page.createdate}">
            </div>
            
            <div class="mb-3">
                <label for="createdate" class="form-label">수정일</label>
                <input type="text" class="form-control" id="date" value="${page.updatedate}" readonly>
                <input type="hidden" name="date" value="${page.updatedate}">
            </div>

            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" required>${page.content}</textarea>
            </div>

            <div class="mb-3">
                <label for="attachment" class="form-label">첨부파일</label>
                <input type="file" class="form-control" id="attachment" name="attachment" placeholder="${page.attachment}">
                <c:if test="${not empty page.attachment}">
    			<div class="form-text">현재 파일: ${page.attachment}</div>
  				</c:if>
            </div>

            <div class="mt-4">
                <button type="submit" class="btn btn-success">수정 완료</button>
                <button type="reset" class="btn btn-secondary">초기화</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>