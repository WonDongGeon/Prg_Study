<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 보기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="container mt-5">
            <button class="btn btn-primary btn-lg" onclick="location.href='/reboard/list'">
                <i class="fas fa-arrow-left"></i> 뒤로가기
            </button>
        </div>

        <h2>글 보기</h2>

        <!-- 글 정보 -->
        <div class="mb-3">
            <label for="id" class="form-label d-inline">글번호 (ID): </label>
            <p id="id" class="d-inline">${page.id}</p>
        </div>

        <div class="mb-3">
            <label for="title" class="form-label d-inline">제목: </label>
            <h4 id="title" class="d-inline">${page.title}</h4>
            <input type="text" id="editTitle" class="form-control" style="display:none;" value="${page.title}">
        </div>

        <div class="mb-3">
            <label for="author" class="form-label d-inline">작성자: </label>
            <p id="author" class="d-inline">${page.author}</p>
            <input type="text" id="editAuthor" class="form-control" style="display:none;" value="${page.author}">
        </div>

        <div class="mb-3">
            <label for="createdate" class="form-label d-inline">작성일: </label>
            <p id="createdate" class="d-inline">${page.createdate}</p>
        </div>

		<div class="mb-3">
            <label for="updatedate" class="form-label d-inline">수정일: </label>
            <p id="updatedate" class="d-inline">${page.updatedate}</p>
        </div>
        

        <div class="mb-3">
            <label for="viewcnt" class="form-label d-inline">조회수: </label>
            <p id="viewcnt" class="d-inline">${page.viewcnt}</p>
        </div>

        <div class="mb-3">
            <label for="content" class="form-label d-inline">내용: </label>
            <p id="content">${page.content}</p>
            <textarea id="editContent" class="form-control" style="display:none;">${page.content}</textarea>
        </div>

        <div class="mb-3">
            <label for="attachment" class="form-label d-inline">첨부파일: </label>
            <p id="attachment">${page.attachment}</p>
        </div>

        <!-- 수정, 삭제 버튼 -->
        <div class="mt-4">
            <button class="btn btn-secondary" onclick="location.href='/reboard/updateform?id=${page.id}'">수정</button>
            <button class="btn btn-danger" onclick="location.href='/reboard/delete?id=${page.id}'">삭제</button>
            <button class="btn btn-warning" onclick="location.href='/reboard/reply?id=${page.id}'">댓글쓰기</button>
        </div>

        <div id="saveButtons" style="display:none;">
            <button class="btn btn-success" onclick="saveChanges()">저장</button>
            <button class="btn btn-secondary" onclick="cancelEdit()">취소</button>
        </div>
    </div>

    <!-- Bootstrap JS (선택사항) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        // 수정 모드 전환 함수
        function toggleEditMode() {
            // 기존 내용 숨기기
            document.getElementById('title').style.display = 'none';
            document.getElementById('author').style.display = 'none';
            document.getElementById('content').style.display = 'none';
            document.getElementById('editTitle').style.display = 'inline-block';
            document.getElementById('editAuthor').style.display = 'inline-block';
            document.getElementById('editContent').style.display = 'inline-block';
            document.getElementById('editButton').style.display = 'none';
            document.getElementById('deleteButton').style.display = 'none';
            document.getElementById('saveButtons').style.display = 'inline-block';
        }

        // 수정 취소 함수
        function cancelEdit() {
            // 원래 내용으로 되돌리기
            document.getElementById('title').style.display = 'inline-block';
            document.getElementById('author').style.display = 'inline-block';
            document.getElementById('content').style.display = 'inline-block';
            document.getElementById('editTitle').style.display = 'none';
            document.getElementById('editAuthor').style.display = 'none';
            document.getElementById('editContent').style.display = 'none';
            document.getElementById('editButton').style.display = 'inline-block';
            document.getElementById('saveButtons').style.display = 'none';
        }

     //수정된 내용 저장 함수
        function saveChanges() {
            const updatedTitle = document.getElementById('editTitle').value;
            const updatedAuthor = document.getElementById('editAuthor').value;
            const updatedContent = document.getElementById('editContent').value;
            const boardId = document.getElementById('id').textContent; // 글 번호(ID)

            // 수정된 데이터 객체 생성
            const updatedBoard = {
                id: boardId,
                title: updatedTitle,
                author: updatedAuthor,
                content: updatedContent
            };

            // 서버로 데이터 전송 (POST 방식)
            fetch('/board/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json', // JSON 데이터 전송
                },
                body: JSON.stringify(updatedBoard) // JavaScript 객체를 JSON 문자열로 변환
            })
            .then(response => response.json()) // 서버 응답을 JSON으로 변환
            .then(data => {
                if (data.success) {
                    alert('게시글이 성공적으로 수정되었습니다!');
                    location.href = '/board/list'; // 수정 완료 후 게시판 목록 페이지로 이동
                } else {
                    alert('수정 실패: ' + data.message);
                }
            })
            .catch(error => {
                console.error('수정 요청 중 오류 발생:', error);
                alert('서버와의 통신에 문제가 발생했습니다.');
            });

            // 수정이 완료되면 취소와 비슷하게 처리
            cancelEdit();
        }

        // 삭제 함수
        function deletePost() {
        	var boardId = '${page.id}';
            if (confirm("정말로 삭제하시겠습니까?")) {
                // 실제 삭제 로직 추가 (예: 서버에 삭제 요청)
               location.href = '/reboard/delete?id=' + boardId;
               console.log("삭제됨");
            }
        }
    </script>
</body>
</html>