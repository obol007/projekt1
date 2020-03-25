<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration:</h1>

<c:if test="${param.regType eq 'business'}">
    <p>You are a businessman!</p>

<%--    formularz dla biznesu--%>

</c:if>
<c:if test="${param.regType eq 'client'}">
    <p>You are a client!</p>

<%--    formularz dla klienta--%>

</c:if>

</body>
</html>