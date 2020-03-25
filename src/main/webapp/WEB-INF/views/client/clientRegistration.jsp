<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Business Registration</title>
</head>
<body>
<h1>Business registration:</h1>

<form:form modelAttribute="data" method="post" action="/register">
    <p>Nazwa użytkownika: <form:input path="username"/> <form:errors path="username"/> </p>
    <p>Email: <form:input path="email"/> <form:errors path="email"/> </p>
    <p>Hasło: <form:password path="password"/> <form:errors path="password"/> </p>
    <p>Imię: <form:input path="firstName"/> <form:errors path="firstName"/> </p>
    <p>Nazwisko: <form:input path="lastName"/> <form:errors path="lastName"/> </p>

    <p><button type="submit">Zarejestruj</button></p>
    <security:csrfInput/>
</form:form>

</body>
</html>