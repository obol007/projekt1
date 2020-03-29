<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

    <security:authorize access="hasAnyAuthority('CLIENT','BUSINESS')" >
        <p>Witaj zalogowany użytkowniku</p>
    </security:authorize>

        <security:authorize access="hasRole('ROLE_BUSINESS')">
            <p>For businesses...</p>
        </security:authorize>
 <security:authorize access="hasRole('ROLE_CLIENT')">
            <p>For clients...</p>
        </security:authorize>

<security:authorize access="isAuthenticated()">
    <p>Welcome back, <security:authentication property="name"/></p>

        <p>Zalogowany jako: <security:authentication property="name"/></p>
        <p>Posiada role: <security:authentication property="authorities"/></p>


    </br>

    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Log out">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

<%--    <p>Posiada role: <security:authentication property="role"/></p>--%>
</security:authorize>


<security:authorize access="!isAuthenticated()">

<h1>Register or Log in!</h1>
<form method="get" action="${pageContext.request.contextPath}/register/businessRegistration">
        <button type="submit">BUSINESS REGISTRATION</button>
</form>
<form method="get" action="${pageContext.request.contextPath}/register/clientRegistration">
        <button type="submit">CLIENT REGISTRATION</button>
</form>
<form method="get" action="${pageContext.request.contextPath}/login">
        <button type="submit">LOG IN</button>
</form>

</security:authorize>

</body>
</html>
