<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>
My First Web App
</title>
</head>
<body>
<font color="red">${message}</font>
<form method="post" action="/loginAdmin">
Username: <input type="text" name="username" />
Password: <input type="password" name="password"/>
<input type="submit" />
</form>

</body>
</html>