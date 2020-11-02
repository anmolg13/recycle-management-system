<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<h1>Buyer Details</h1>
	<c:if test="${sorry}">
	<font color="red">${sorryMsg}</font>
	<a href="/buyer">Place order again</a>
	</c:if>
	<c:if test="${!sorry}">
	<font color="red">${msg} Total Amount to be paid: Rs ${amount}.0. You need to pay Rs ${pamount} now as an advance payment.</font>

	
	<form action="/payment" >
	<td><button type="submit" id="submit" name="submit">Advance Payment</button></td>
	</form>
	</c:if>
</body>
</html>