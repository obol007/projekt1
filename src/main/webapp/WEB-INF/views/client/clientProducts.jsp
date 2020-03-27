<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                Welcome, <strong>${client.firstName}</strong>...
            </h1>
            <p class="subtitle">

            </p>



            <form action="<c:url value="/logout"/>" method="post">
                <input type="submit" value="Log out">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

        </div>
    </section>


            <p>All products from ${productCategory.category}</p>
    <table border="1">
        <c:forEach items="${productCategory}" var="categoryProduct">
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Address</th>
            </tr>
            <tr>
                <td>${categoryProduct.name}</td>
                <td>${categoryProduct.price}</td>
                <td>${categoryProduct.business.user.address}</td>
            </tr>
        </c:forEach>
    </table>


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
