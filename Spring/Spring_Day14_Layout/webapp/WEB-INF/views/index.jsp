<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/index.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<!-- 열고 닫는 태그가 있을 경우 오류발생 -->
<%-- <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include> --%>
<jsp:include page="/WEB-INF/views/${page}.jsp"/>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>