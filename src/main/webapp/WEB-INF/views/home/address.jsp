<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add address</title>
</head>
<body>
<p>Add/Edit the address:</p>

<form:form modelAttribute="addressDTO" method="post" action="/address/add">
<%--    <input type="hidden" value="${addressDTO.id}">--%>
    <form:hidden path="id"/>
    <p><form:input path="street" placeholder="Street"/> <form:errors path="street"/> </p>
    <p><form:input path="buildingNumber" placeholder="Building number"/> <form:errors path="buildingNumber"/> </p>
    <p><form:input path="flatNumber" placeholder="Flat number"/><form:errors path="flatNumber"/> </p>
    <p><form:input path="city" placeholder="City"/> <form:errors path="city"/> </p>
    <p><form:input path="zipcode" placeholder="Zip code"/> <form:errors path="zipcode"/> </p>
    <p><form:input path="country" placeholder="Country"/> <form:errors path="country"/> </p>

    <button type="submit">SAVE</button>
    <button type="reset">RESET</button>

</form:form>
<form:form method="get" action="/business">
    <button type="submit">CANCEL</button>
</form:form>

</body>
</html>
