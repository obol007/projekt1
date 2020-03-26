<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>


<form:form modelAttribute="product" method="post" action="/product/delete">
    <p>Do you really what to delete <b>${product.name}</b>?
    <form:hidden path="id"/>
    <button type="submit">DELETE</button>
    </form:form>

<form:form method="get" action="/business">
    <button type="submit">CANCEL</button>
</form:form>

</body>
</html>
