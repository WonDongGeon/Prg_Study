<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/webapp/index.jsp</title>
</head>
<body>

<h1>jsp websocket</h1>

<p>
별명 : <input type="text" id="nickname"><br>
보낼메시지:<input type="text" id="message">
<input type="button" id="sendbtn" value="보내기">
</p>

<script>
const nickname=document.getElementById("nickname");
const message=document.getElementById("message");
const sendbtn=document.getElementById("sendbtn");
sendbtn.addEventListener("click", function() {
	
	//websocket.send(meesage.value);
	//let msg='{"nickname" : "'+nickname.value+'","message":"'+message.value+'"}';
	//websocket.send(msg);
	
	//객체를 생성하고 객체를 문자열로 변환시키는 방법
	//두번쨰 입력값 nickname.value는 변수의 값이 입력되는 것과 동일
	let msg={nickname:nickname.value,message:message.value};
	websocket.send(JSON.stringify(msg)); // 2번째 msg를 문자열로 변환(JSON.strongify)시켜줌
	
	// ` ' 백쿼드를 이용한 문자열 처리(page isELIgnored="true" 설정)
	// jsp에서는 ${}는 el tag문법, ${}적용 안되므로 \${}사용함으로써 스크립트에서 백틱을 사용
	//let msg=`{"nickname":"\${nickname.value}","message":"\${message.value}"}`;
	
	console.log(msg);
	//websocket.send(msg);
	//메시지 보낸 후 메시지창을 꺠긋하게 처리
	message.value="";
});
</script>

<div id="messagebox"></div>

<script>
const websocket = new WebSocket("ws://172.16.15.87:8888/websocket")
console.log(websocket);
// websocket.send("hello weboscket server!!"); //전송실패
//왜?socket생성시 비동기화 처리(send함수가 실행 된 후에 소켓이 생성될 수 있다라는 의미(지연))
</script>

<p><button onclick="websocket.send('hello weboscket server!!')">메시지 전송</button>

<script>
//클라이언트에서 메시지 수신은 정해진 시점이 있는 것이 아니므로 이벤트를 등록하여 확인상태 유지
websocket.onmessage = function (message) {
	console.log(message); //json객체 형식의 답변
	console.log(message.data); //필요로 하는 데이터만 추출
	//console.log(message.origin);
	//messagebox.textContent+=message.data+"<br>";
	//messagebox.innerHTML+=message.data+"<br>";
	
	//message가 json형식의 문자열일 경우 객체로 변환
	let obj=JSON.parse(message.data);
	messagebox.innerHTML+="["+obj.nickname+"]:"+obj.message+"<br>";
}
</script>

</body>
</html>