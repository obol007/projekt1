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

<form:form modelAttribute="businessData" method="post" action="/register/businessRegistration">
    <p>Username: <form:input path="username"/> <form:errors path="username"/></p>
    <p>Password: <form:password path="password"/> <form:errors path="password"/></p>
    <p>Email: <form:input path="email"/> <form:errors path="email"/></p>
    <p>Name: <form:input path="firstName"/> <form:errors path="firstName"/></p>
    <p>Surname: <form:input path="lastName"/> <form:errors path="lastName"/></p>
    <p>Company: <form:input path="businessName"/> <form:errors path="businessName"/></p>
    <p>NIP: <form:input path="nip"/> <form:errors path="nip"/></p>
    <p>Category: <form:input path="category"/> <form:errors path="category"/></p>

    <p>
        <button type="submit">REGISTER</button>
    </p>
    <security:csrfInput/>

</form:form>


</body>
</html>