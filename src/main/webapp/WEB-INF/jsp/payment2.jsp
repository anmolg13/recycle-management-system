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

	<h1>Buyer Home Page</h1>
	<font color="red">${msg}You need to pay Rs.${payamount}</font>
	<form method="POST" action="pay2?payamount=${payamount}&totamount=${totamount}&requestId=${requestId}" >
		<table>
			<tr>
			<td><label >Mode of Payment: <label></td>
			<td><input type="radio" name=mode value="Credit Card"/>Credit Card</td>
			<td><input type="radio" name=mode value="Debit Card"/>Debit Card</td>
			
		</tr>
		<tr>
			<td><label >Card No: <label></td>
			<td><input id="cardno"/></td>
			
		</tr>
		<tr>
			<td><label >Card Holder's Name: <label></td>
			<td><input id="name"/></td>
			
		</tr>
			<tr>
			<td><label >Amount: <label></td>
			<td><input name="paidAmount" id="paidAmount"/></td>
			
		</tr>
			<tr>
				<td><button type="submit" id="submit" name="submit">Pay</button></td>
				
			</tr>
		</table>
	<form>
</body>
</html>