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
    <p>Błędne dane logowania!</p>
</c:if>
<c:if test="${param.logout != null}">
    <p>Zostałeś wylogowany!</p>
</c:if>

<form method="post" action="/login">
    <p>Username: <input type="text" name="username"></p>
    <p>Password: <input type="password" name="password"></p>
    <p><button type="submit">Log in</button> </p>

<%--    kazdy formularz, ktory wysyla dane musi zawierac ten tag--%>
    <security:csrfInput/>
</form>

</body>
</html>
