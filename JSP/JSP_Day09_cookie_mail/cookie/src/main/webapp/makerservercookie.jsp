<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/cookie.jsp</title>
</head>
<body>
쿠키는 클라이언트(웹브라우저)에서 데이터를 저장하는 객체이다.
</body>
</html>

<%
Object sessionNum = request.getSession().getAttribute("num");
System.out.println((String)sessionNum);
int num=1;
if(sessionNum==null){
num=1;	
}else{
num=Integer.parseInt((String)sessionNum);
}
System.out.println(++num);
request.getSession().setAttribute("num", String.valueOf(num));
System.out.println((String)request.getSession().getAttribute("num"));

Cookie cookie1
=new Cookie("product"+String.valueOf(num),"computer"+String.valueOf(num));
response.addCookie(cookie1);
%>





