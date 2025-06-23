<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원 상세 정보</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center">회원 상세 정보</h2>

    <!-- 홈 아이콘 -->
    <div class="mb-3 text-start">
        <a href="/" title="홈으로 이동">
            <i class="fas fa-home" style="font-size:24px; cursor:pointer;"> 홈으로 이동</i>
        </a>
    </div>

    <!-- 정보 테이블 -->
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="card-body">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th class="table-light text-center" style="width: 30%;">아이디</th>
                        <!-- tag에서 editcontent는 편집모드로 변경 -->
                        <td>${pb.id}</td>
                    </tr>
                    <tr>
                        <th class="table-light text-center">이름</th>
                        <td>${pb.name}</td>
                    </tr>
                    <tr>
                        <th class="table-light text-center">전화번호</th>
                        <td>${pb.hp}</td>
                    </tr>
                    <tr>
                        <th class="table-light text-center">이메일</th>
                        <td>${pb.email}</td>
                    </tr>
                    <tr>
                        <th class="table-light text-center">메모</th>
                        <td style="white-space: pre-wrap;">${pb.memo}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 버튼 영역 -->
    <div class="text-center mt-4">
        <button type="button" class="btn btn-secondary me-2" onclick="history.back()">목록으로 돌아가기</button>
        <!-- <a href="javascript:updatebtn(this)" class="btn btn-primary me-2">수정하기</a> href안에는 원래 링크를 넣지만, 자바스크립트를 이용하고 싶으면 이런식으로 넣을 수 있음 -->
    	<a href="/phonebook/updateform?id=${pb.id}" class="btn btn-primary me-2">수정하기</a>
    	<a href="/phonebook/delete?id=${pb.id}" class="btn btn-danger">삭제하기</a>
    </div>
</div>
<script>
function updatebtn(obj) {
	// 4개의 데이터가 있는 tr을 contenteditable
	let tds = document.querySelectorAll("td");
	console.log(tds);
	tds.forEach((td) => {
		//tr.contenteditable=true; //하위에 있는 속성에 접근하는 경우 
		//하위에 있는 속성에 접근하는 경우 접근불가시 다음코드 이용
		td.setAttribute('contenteditable', 'true');
		td.style.backgroundColor = '#ffffcc';
		//버튼의 값을 변경
		console.log(obj.innerText);
		obj.innerText = '수정';
	})
}
</script>
</body>
</html>
