<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>

</head>
<body>
<h3>Strona Usera</h3>
<security:authorize access="isAuthenticated()">
<%--    opcjonalnie dla rol--%>
    <security:authorize access="hasRole('ADMIN')">
        <p>Witaj administratorze</p>
    </security:authorize>

    <p>Witaj ${username} !</p>

</security:authorize>

<security:authorize access="!isAuthenticated()">
 <p>info dla niezalogowanych</p>

</security:authorize>


</body>
</html>
