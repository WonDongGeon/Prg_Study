<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/webapp/makeclientcookie.jsp</title>
</head>
<body>
<h3>클라이언트에서 쿠키 만들기(서버와 상관없음)</h3>
<ul>
<li onclick="makecookie(this)">상품1</li>
<li onclick="makecookie(this)">상품2</li>
<li onclick="makecookie(this)">상품3</li>
<li onclick="makecookie(this)">상품4</li>
<li onclick="makecookie(this)">상품5</li>
</ul>
<script>
var num=1;
function makecookie(obj){
	alert(obj.innerText+"이 장바구니에 추가 되었습니다.!!");
	num++;
	document.cookie="prod"+num+"="+obj.innerText;
}
//document.cookie="prod1=make1";
//document.cookie="prod2=make2";
</script>
</body>
</html>