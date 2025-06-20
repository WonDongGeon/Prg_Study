<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>회원 목록</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">회원 정보 테이블</h2>
    <div>
    <!-- div><button onclick="location.href='http://localhost:8888/insertform'"> 전화번호부 입력</button></div> -->
    <button>전화번호부 입력</button>
    </div>
    <div class ="table-responsive">
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr class="text-center">
                <th>아이디</th>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
                <th>메모</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pb" items="${list}">
                <tr>
                    <td>${pb.id}</td>
                    <td>${pb.name}</td>
                    <td>${pb.hp}</td>
                    <td>${pb.email}</td>
                    <td>${pb.memo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
let btns=document.getElementsByTagName("button");
/* collection을 이용한 배열은 배열이 아니므로 아래와 같이 수정(오류발생)
btns.forEach(function(btn) {
	console.log(btn.innerText);
})
*/
Array.from(btns).forEach(function(btn) {
	console.log(btn.innerText);
	console.log(btn.textContent);
	/*
	switch(btn.textContent) {
	case "전화번호부 입력": location.href ="/phonebook/insertform"; break;
	}
	*/
	btn.addEventListener("click", function(e) {
		switch(e.target.textContent) {
		case "전화번호부 입력": location.href ="/phonebook/insertform"; break;
		}
	});
});

//tr리스트를 가지고 온 후 이벤트 등록처리
//querySelector는 nodelist를 들고오는 함수이므로 Array.from을 사용할 필요가 없음
let trs = document.querySelectorAll("tbody > tr");
console.log(trs);
trs.forEach((tr) => {
	console.log(tr.textContent);
	console.log(tr.children[0]);
	console.log(tr.children[0].textContent);
	let id = tr.children[0].textContent;
	//이벤트 등록
	tr.addEventListener("click", function(e) {
		//location.href="/phonebook/view?id="+id;
		//location.href="/phonebook/view?id=${id}; // jsp에서는 오류발생
		location.href=`/phonebook/view?id=${'${id}'}`;
	});
});
</script>
</body>
</html>
