<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><button id="insertexecbtn">입력실행</button></div>
<div id="result"></div>
<script>
const xhr = new XMLHttpRequest();
/*
xhr.onreadystatechange=function () {
	console.log('onreadystatechange 함수 호출!!')
	  if (xhr.status === 200) {
	    const result = JSON.parse(xhr.responseText);
	    console.log(result)
	    div.innerText=result;
	  } else {
	    console.error('요청 실패:', xhr.status);
	  }
	};
*/
xhr.onload = function () {
	console.log('onload 함수 호출!!')
	  if (xhr.status === 200) {
		console.log(xhr);
	    div.innerText=xhr.responseText;
	  } else {
	    console.error('요청 실패:', xhr.status);
	  }
	};

xhr.onerror = function () {console.error('요청 중 오류 발생');};
	
const insertexecbtn=document.getElementById("insertexecbtn");
const div=document.getElementById("result");
insertexecbtn.addEventListener("click",(data)=>{
	
	xhr.open('POST', '/api/member', true);
	xhr.setRequestHeader("Content-Type","application/json");
	let data2=JSON.stringify(
		{"username":"user6"
		,"password":"1234"
		,"email":"user6@naver.com"
		}
		);
	xhr.send(data2);	

});
</script>

</body>
</html>