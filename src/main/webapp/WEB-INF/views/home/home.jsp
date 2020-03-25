<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Are you ready for the Game? </h1><br>
<h1>Register!</h1>
<form method="get" action="${pageContext.request.contextPath}/register">
    <input type="hidden" name="regType" value="client"/>
    <button type="submit">I AM A CLIENT</button>
</form>
<form method="get" action="${pageContext.request.contextPath}/register">
    <input type="hidden" name="regType" value="business"/>
    <button type="submit">I AM A BUSINESS</button>
</form>

</body>
</html>
