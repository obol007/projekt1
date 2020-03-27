<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<c:if test="${param.get('error') != null}">--%>
<c:if test="${param.error != null}">
    <p>Invalid credentials!</p>
</c:if>
<c:if test="${param.logout != null}">
    <p>You're logged out!</p>
</c:if>

<form method="post" action="/login">
    <p>Username</p>
    <p><input type="text" name="username"></p>
    <p>Password</p>
    <p><input type="password" name="password"></p>
    <p><button type="submit">Log in</button> </p>
<%--    kazdy formularz, ktory wysyla dane musi zawierac ten tag--%>
    <security:csrfInput/>
</form>
<form method="get" action="${pageContext.request.contextPath}/">
    <button type="submit">MAIN PAGE</button>
</form>

</body>
</html>
