<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>user page입니다.</p>
<p>Authenticated User: ${principal.username} =>principal 직접사용불가 화면표시안됨 </p>
<sec:authentication property="principal" var="user"/>
<p>Authenticated User: ${user.username}</p>
<p>Authenticated User: <sec:authentication property="name"/> </p>
<a href="#" onclick="logout()">로그아웃</a>

<script>
    function logout() {
        // 1. 동적으로 form을 생성합니다.
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = '/logout'; // 로그아웃 경로

        // 2. CSRF 토큰 정보를 가져옵니다.
        const csrfInput = document.querySelector('input[type="hidden"][name^="_csrf"]');

        if (csrfInput) {
            // 3. CSRF 토큰 input을 동적으로 생성하여 폼에 추가합니다.
            var csrfHiddenInput = document.createElement('input');
            csrfHiddenInput.type = 'hidden';
            csrfHiddenInput.name = csrfInput.name; // 예: _csrf
            csrfHiddenInput.value = csrfInput.value; // 예: 실제 CSRF 토큰 값
            form.appendChild(csrfHiddenInput);
        } else {
            console.warn("CSRF hidden input not found. Logout might fail due to security checks.");
            // 선택 사항: CSRF 토큰이 없으면 로그아웃을 진행하지 않거나, 사용자에게 경고를 표시할 수 있습니다.
            // return;
        }

        // 4. 폼을 body에 추가하고 제출합니다.
        document.body.appendChild(form);
        form.submit();
    }
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
</body>
</html>