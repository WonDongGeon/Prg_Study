<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login</title></head>
<body>
    <h2>Login</h2>
    <form action="/login" method="POST">
        <label for="username">ID</label>
        <input type="text" name="username" id="username"/><br/>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password"/><br/>
        <input type="submit" value="Login"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</body>
</html>
