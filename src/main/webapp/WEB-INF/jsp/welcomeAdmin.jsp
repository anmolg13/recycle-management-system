<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1>Hey welcome to admin page</h1>
	<table>
	
		<tr>
			<td><a href="/viewOrders">View Buyer Requests</a></td>
		</tr>
		<tr>
			<td><a href="/requests">View Vendor Requests</a></td>
		</tr>
		
	</table>
</body>
</html>