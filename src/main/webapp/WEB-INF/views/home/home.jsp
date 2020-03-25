<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

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

</body>
</html>
