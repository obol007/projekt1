<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Business Page</title>

</head>
<body>
<h1>Business Page</h1>
<security:authorize access="isAuthenticated()">

<p>Welcome, ${username} to the Game!</p>

</security:authorize>

<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--        <p>Witaj administratorze</p>--%>
<%--    </security:authorize>--%>

<%--<security:authorize access="!isAuthenticated()">--%>
<%--    <p>info dla niezalogowanych</p>--%>

<%--</security:authorize>--%>


</body>
</html>