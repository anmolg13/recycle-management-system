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

<h1>User Registration Form</h1>
<form:form onsubmit="return validate()" method="POST" action="registerUser" modelAttribute="user">
	<table>
		<tr>
			<td><form:hidden path="id" id="id"/></td>
		</tr>
		<tr>
			<td><form:label path="firstName">First Name: </form:label></td>
			<td><form:input path="firstName" id="firstName"/></td>
			<td><form:errors path="firstName"/></td>
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name: </form:label></td>
			<td><form:input path="lastName" id="lastName"/></td>
			<td><form:errors path="lastName"/></td>
			
		</tr>
		<tr>
			<td><form:label path="phoneNumber">Phone Number: </form:label></td>
			<td><form:input path="phoneNumber" id="phoneNumber"/></td>
			<td><form:errors path="phoneNumber"/></td>
		</tr>
		<tr>
			<td><form:label path="email">Email Id: </form:label></td>
			<td><form:input path="email" id="email"/></td>
			<td><form:errors path="email"/></td>
		</tr>
		<tr>
			<td><form:label path="password">Password: </form:label></td>
			<td><form:password path="password" id="password"/></td>
			<td><form:errors path="password"/></td>
		</tr>
		<tr>
			<td><form:label path="gender">Gender: </form:label></td>
			<td><form:select path="gender" items="${genderList}" id="gender"/></td>
		</tr>
		<tr>
			<td><button type="submit" id="submit" name="submit">Submit</button></td>
			<td><button type="reset" id="reset" name="reset">Clear</button></td>
		</tr>
	</table>
</form:form>
<script type="text/javascript" src="js/validateUser.js"></script>
</body>
</html>