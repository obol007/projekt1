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
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Log out">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

<p>Welcome, ${business.firstName} !</p>


</br>
    <p>Add a product:</p>
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
            <td><form method="get" action="/product/edit/${product.id}">
                <input type="submit" value="EDIT"/>
            </form>
            </td><td><form method="get" action="/product/delete/${product.id}">
                <input type="submit" value="DELETE"/>
            </form> </td>
        </tr>
    </c:forEach>
    </table>



</security:authorize>





<%--    <security:authorize access="hasRole('ADMIN')">--%>
<%--        <p>Witaj administratorze</p>--%>
<%--    </security:authorize>--%>

<%--<security:authorize access="!isAuthenticated()">--%>
<%--    <p>info dla niezalogowanych</p>--%>

<%--</security:authorize>--%>


</body>
</html>