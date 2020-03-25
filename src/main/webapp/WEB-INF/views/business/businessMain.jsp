<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Business Page</title>

</head>
<body>
<h1>Business Page</h1>
<security:authorize access="isAuthenticated()">

<p>Welcome, ${business.firstName} !</p>
    <p>You are a business owner!</p>

</security:authorize>

<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--        <p>Witaj administratorze</p>--%>
<%--    </security:authorize>--%>

<%--<security:authorize access="!isAuthenticated()">--%>
<%--    <p>info dla niezalogowanych</p>--%>

<%--</security:authorize>--%>


</body>
</html>