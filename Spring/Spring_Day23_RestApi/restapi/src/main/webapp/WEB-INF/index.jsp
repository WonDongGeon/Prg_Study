<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><input type="text" id="username" placeholder="username입력"></div>
<div><input type="password" id="password" placeholder="password입력"></div>
<div><input type="email" id="email" placeholder="eamil입력"></div>
<button id="insertexecbtn">입력실행</button>
<button id="updateexecbtn" style="display:none">수정실행</button>
<button id="deleteexecbtn" style="display:none">삭제실행</button>
<div><button id="selectAllexecbtn">전체출력실행</button></div>
<div><input type="text" id="findusername" placeholder="검색username입력"></div>
<div><button id="selectByUsernameexecbtn">검색출력실행</button></div>
<div id="result"></div>
<script>
let buttonId = null;

const xhr = new XMLHttpRequest();

xhr.onload = function () {
	console.log('onload 함수 호출!!')
	  if (xhr.status === 200) {
		console.log(xhr);
	    div.innerText=xhr.responseText;	    
	    //입력을 했을 때
	    if(buttonId==="insertexecbtn"){console.log("입력을 했을 때");}
	    //전체출력을 했을 때
	    else if(buttonId==="selectAllexecbtn"){console.log("전체출력을 했을 때");}
	    //선택출력을 했을 때
	    else if(buttonId==="selectByUsernameexecbtn"){
	    	console.log("선택출력을 했을 때");
	    	let obj=JSON.parse(xhr.responseText);
	    	username.value=obj["username"];
	    	password.value=obj["password"];
	    	email.value=obj["email"];
	    	updateexecbtn.style.display="inline";
	    	deleteexecbtn.style.display="inline";
	    	insertexecbtn.style.display="none";
	    	username.readOnly="true";
	    	
	    }
	    //수정을 했을 때
	    else if(buttonId==="updateexecbtn"){console.log("수정을 했을 때");}
	    //삭제를 했을 때	
	    else if(buttonId==="deleteexecbtn"){console.log("삭제 했을 때");}
	    else{console.log("그외 코드 일때"); }
	  }else {console.error('요청 실패:', xhr.status); }
	buttonId=null;//기본에 있는 값을 정리하기 위한 값입력
	};

xhr.onerror = function () {console.error('요청 중 오류 발생');};
	
const insertexecbtn=document.getElementById("insertexecbtn");
const username=document.getElementById("username");
const password=document.getElementById("password");
const email=document.getElementById("email");

const div=document.getElementById("result");
insertexecbtn.addEventListener("click",(data)=>{
	console.log(event.target.id);
	buttonId=event.target.id;
	xhr.open('POST', '/api/member', true);
	xhr.setRequestHeader("Content-Type","application/json");
	let data2=JSON.stringify(
		{"username":username.value
		,"password":password.value
		,"email":email.value
		}
		);
	xhr.send(data2);
	
	username.value="";password.value="";email.value="";
});

const selectAllexecbtn=document.getElementById("selectAllexecbtn");
selectAllexecbtn.addEventListener("click",(data)=>{
	console.log(event.target.id);
	buttonId=event.target.id;
	//http://localhost:8888/api/members
	xhr.open('POST', '/api/members', true);
	xhr.send();
});

const selectByUsernameexecbtn=document.getElementById("selectByUsernameexecbtn");
const findusername=document.getElementById("findusername");
selectByUsernameexecbtn.addEventListener("click",(data)=>{
	console.log(event.target.id);
	buttonId=event.target.id;
	//http://localhost:8888/api/member?username=xxxxx
	//http://localhost:8888/api/member/xxxxx
	
	/*첫번째 호출방법*/
	xhr.open('GET', 'api/member?username='+findusername.value, true);
	xhr.send();
	
	/*두번째 호출방법*/
	/*
	console.log('select')
	xhr.open('GET', '/api/member', true);
	let params=new URLSearchParams();
	params.append("username",findusername);
	xhr.send();
	*/
});
const updateexecbtn
=document.getElementById("updateexecbtn");
const deleteexecbtn
=document.getElementById("deleteexecbtn");

</script>

</body>
</html>