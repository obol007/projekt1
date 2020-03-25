<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<security:authorize access="isAuthenticated()">
    <section class="section">
    <div class="container">
        <h1 class="title">
            Strona usera
        </h1>
        <p class="subtitle">
            Welcome, <strong>${client.firstName}</strong>!
        </p>
    </div>
</section>
</security:authorize>
</body>
</html>

<%--<head>--%>
<%--    <title>Home Page</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<h3>Strona Usera</h3>--%>
<%--<security:authorize access="isAuthenticated()">--%>
<%--    opcjonalnie dla rol--%>
<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--        <p>Witaj administratorze</p>--%>
<%--    </security:authorize>--%>

<%--    <p>Witaj ${client.firstName} !</p>--%>
<%--    <p>You are a client!</p>--%>

<%--</security:authorize>--%>




<%--<security:authorize access="!isAuthenticated()">--%>
<%-- <p>info dla niezalogowanych</p>--%>

<%--</security:authorize>--%>


<%--</body>--%>
<%--</html>--%>
