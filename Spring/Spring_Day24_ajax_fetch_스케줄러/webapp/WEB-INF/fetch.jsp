<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/*
fetch(url,정보)
.then(익명함수)
.then(익명함수)
.catch(익명함수);
*/

/*
fetch("/api/member",{
method:'POST',
headers:{
	'Content-Type':'application/json',
},
//content-type이 json이지만 문제 발생, 전송시 형태는 json이지만 문자열의 json이여야함.
//body:{"username":"user6","password":"1234","email":"user6@naver.com"}
body:
JSON.stringify({"username":"user6","password":"1234","email":"user6@naver.com"})
})
	.then(response =>{
	console.log(response)
})
*/

/*
fetch("/api/member",{
	method:'POST',
	headers:{
		'Content-Type':'application/json',
	},
	body:
	JSON.stringify({"username":"user8","password":"1234","email":"user8@naver.com"})
	})
	.then(response => response.text())
	.then(result =>{
		console.log(result);
	})
*/

/*
fetch("/api/member",{
	method:'POST',
	headers:{
		'Content-Type':'application/json',
	},
	body:
	JSON.stringify({"username":"user9","password":"1234","email":"user9@naver.com"})
	})
.then(response => {
	console.log(response);
	return response.text();
})
.then(result =>{
	console.log(result);
})
*/

// http://localhost:8888/api/member?username=user6
//post방식은 body를 사용할 수 있지만 get방식은 uri에 직접?를 생성하고 변수를 활용하여 처리
//let username='user7';
function searchusername(){
let username=document.getElementById("username").value;
fetch(`/api/member?username=\${username}`,{
	method:'GET',
	})
	.then(response => {
		console.log(response);
		return response.text(); // text(), json()호출할 때 차이점을 확인
	})
	.then(result =>{
		console.log(typeof result);
		console.log(result);
		let divs=document.getElementsByTagName("div");
		divs[0].innerText=result["username"];
		divs[1].innerText=result["password"];
		divs[2].innerText=result["email"];	
	})
}
</script>
</head>
<body>
<input type="text" id="username">
<button onclick="searchusername()">검색</button><br>

<div>username</div>
<div>password</div>
<div>email</div>
</body>
</html>