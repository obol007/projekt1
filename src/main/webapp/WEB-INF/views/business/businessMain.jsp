<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Business Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

</head>
<body>
<section class="section">
    <div class="container">
        <h1 class="title">
            Welcome, ${business.firstName}...
        </h1>

<security:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="LOG OUT">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <form:form action="/address/add" method="get">
        <input type="submit" value="ADD/EDIT BUSINESS ADDRESS"/>
    </form:form>

    <form:form action="/product/add" method="get">
        <input type="submit" value="ADD A PRODUCT"/>
    </form:form>

    <p>Product list:</p>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Description</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${business.products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.category}</td>
                <td>${product.quantity}</td>
                <td>${product.description}</td>
                <td>
                    <form method="get" action="/product/edit/${product.id}">
                        <input type="submit" value="EDIT"/>
                    </form>
                </td>
                <td>
                    <form method="get" action="/product/delete/${product.id}">
                        <input type="submit" value="DELETE"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>Company info:</p>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>NIP</th>
        </tr>
        <tr>
            <td>${business.businessName}</td>
            <td>${business.user.address.street}
                    ${business.user.address.buildingNumber},
                    ${business.user.address.zipcode}
                    ${business.user.address.city},
                    ${business.user.address.country},
            </td>
            <td> ${business.nip}</td>
        </tr>

    </table>



</security:authorize>
    </div>
</section>


<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--        <p>Witaj administratorze</p>--%>
<%--    </security:authorize>--%>

<%--<security:authorize access="!isAuthenticated()">--%>
<%--    <p>info dla niezalogowanych</p>--%>

<%--</security:authorize>--%>


</body>
</html>