<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
//header에 있는 Content-Type은 사용자가 설정을 하는 속성으로
//우선순위는 header에 있는 Content-Type 우선순위를 가짐
$.ajax({
	url:"/insert",
	method:"post",
	//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	//@RequestParam ?속성=값, appliaction/x-www-form-urlencoded contenttype사용
	//객체로 전달이 가능
	//headers:{"Content-Type":"application/x-www-form-urlencoded",}, //{}값이
	//data:{name: "hongkildong", age:"20"},
	
	//content type이 application/json 일 경우 @RequestBody사용
	//객체로 전달이 불가하며 문자열의 객체로 전달해야함
	headers: {"Content-Type":"application/json"}, //{}는 값전달 안됨
	data: JSON.stringify({name:"hongkildong", age:"20"}),
	
	success:function(result) {
		console.log(result)
		$('#result').text(result)
	}
})
</script>
</head>
<body>

</body>
</html>