<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>key event</h1>
<script>
const body=document.querySelector("body");
let msg="";
body.addEventListener("keydown", (e)=> {
	//console.log(e);
	//console.log(e.key);
	//console.log(e.keyCode);
	//문자열을 누적시키는 코드를 작성하시오.
	msg+=e.key;
	console.log(msg);
	//엔터를 치면 누적된 msg값이 삭제되게 처리하시오.
	if(e.key=="Enter") {
		msg=""; console.log("출력값:"+msg);
	}
});
</script>
</body>
</html>