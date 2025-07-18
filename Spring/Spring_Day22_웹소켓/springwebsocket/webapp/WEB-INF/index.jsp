<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>챗팅창</legend>
<div>
보낼메시지:<input type="text" id="message">
<input type="button" id="sendbtn" value="보내기">
</div>
<p>
<div id="messagebox" style="border: 1px solid gray; height:50px;"></div>
</fieldset>
<script>
//사용할 객체를 로드
const message=document.getElementById("message");
const sendbtn=document.getElementById("sendbtn");
const messagebox=document.getElementById("messagebox");
//이벤트 등록(버튼을 클릭할 때 메시지가져와서 보내기처리)
sendbtn.addEventListener("click",function(){ 
	websocket.send(message.value);
}
);
</script>
<script>
//const websocket=new WebSocket("ws://localhost:8888/websocket");
const websocket=new WebSocket("ws://172.16.15.87:8888/websocket");
console.log(websocket);
websocket.onopen=function(event){
	console.log(event);
}
websocket.onclose=function(evnet){
	console.log(event);	
}
websocket.onerror=function(event){
	console.log(event);	
}
websocket.onmessage=function(event){
	console.log(event);	
	//메시지가 서버로부터 들어올 때 처리하는 함수
	messagebox.innerHTML+=event.data+"<br>"; 
	//문제점 messagebox 자동으로 크기조절하는 방법 확인
	//overflow: auto 
	messagebox.style.overflow="auto";
	//문제점:스크롤을 자동으로 아래에 위치시키는 방법
	messagebox.scrollTop = messagebox.scrollHeight;
	//추가적으로 자동으로 창의 크기가 늘어나는 방법 확인
}
</script>
</body>
</html>