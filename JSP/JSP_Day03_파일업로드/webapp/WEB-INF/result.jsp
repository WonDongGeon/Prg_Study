<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String message="";
switch((String)request.getAttribute("state")) { // requset가 자동으로 저장되어있음(내장 객체)
case "insert success" :
	message="전화번호부 입력이 성공적으로 수행되었습니다.";
	break;
case "insert fail" :
	message="전화번호부 입력을 실패했습니다.";
	break;
case "update success" :
	message="전화번호부 수정이 성공적으로 수행되었습니다.";
	break;
case "update fail" :
	message="전화번호부 수정을 실패했습니다.";
	break;
case "delete success" :
	message="전화번호부 삭제가 성공적으로 수행되었습니다.";
	break;
case "delete fail" :
	message="전화번호부 삭제를 실패했습니다.";
	break;
}
%>
<script>
alert("<%=message%>");
location.href="/phonebook/list";
</script>