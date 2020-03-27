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

    <p><form:input path="name" placeholder="Name"/> <form:errors path="name"/> </p>
    <p><form:input path="price" placeholder="Price"/> <form:errors path="price"/> </p>
    <p><form:input path="category" placeholder="Category"/> <form:errors path="category"/> </p>
    <p><form:input path="quantity" placeholder="Quantity"/> <form:errors path="quantity"/> </p>
    <p><form:textarea path="description" placeholder="Description"/> <form:errors path="description"/> </p>

    <button type="submit">UPDATE</button>


</form:form>
<form:form method="get" action="/business">
    <button type="submit">CANCEL</button>
</form:form>

</body>
</html>
