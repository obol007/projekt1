<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<p>Edit the product:</p>

<form:form modelAttribute="product" method="post" action="/product/edit">
    <form:hidden path="id"/>

    <p>Name: <form:input path="name"/> <form:errors path="name"/> </p>
    <p>Price: <form:input path="price" value="${product.price}"/> <form:errors path="price"/> </p>
    <p>Category: <form:input path="category" value="${product.category}"/> <form:errors path="category"/> </p>
    <p>Quantity: <form:input path="quantity" value="${product.quantity}"/> <form:errors path="quantity"/> </p>
    <p>Description: <form:input path="description" value="${product.description}"/> <form:errors path="description"/> </p>

    <button type="submit">UPDATE</button>


</form:form>
<form:form method="get" action="/business">
    <button type="submit">CANCEL</button>
</form:form>

</body>
</html>
