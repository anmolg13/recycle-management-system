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
	<font color="red">${msg}</font>
	<a href="/viewPastOrders">View your Past Orders</a>
	<form:form method="POST" action="buyer" modelAttribute="buyerRequest">
		<table>
			<tr>
				<td><form:label path="quantity">Quantity(Kgs): </form:label></td>
				<td><form:input type="number" min="1" max="50" path="quantity" id="amount"/></td>
			</tr>
			<tr>
				<td><form:label path="requiredDate">Date of requirement: </form:label></td>
				<td><form:input path="requiredDate" type="date" id="date" min="${date}"/></td>
			</tr>
			<tr>
				<td><form:label path="location">Location: </form:label></td>
				<td><form:input path="location" id="location"/></td>
			</tr>
			<tr>
				<td><button type="submit" id="submit" name="submit">Submit</button></td>
				<td><button type="reset" id="reset" name="reset">Clear</button></td>
			</tr>
		</table>
	</form:form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js">
</script>
</html>