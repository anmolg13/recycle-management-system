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

<h1>Vendor Request Form</h1>
<form:form  method="POST" action="welcomeUser" modelAttribute="request">
	<table>
		<tr>
			<td><form:hidden path="requestId" id="id"/></td>
		</tr>
		<tr>
			<td><form:label path="typeOfOrg">Type of Organization: </form:label></td>
			<td><form:radiobutton path="typeOfOrg" value="Resturant"/></td>
			<td><form:radiobutton path="typeOfOrg" value="Hostel"/></td>
		</tr>
		<tr>
			<td><form:label path="amount">Amount of Manure: </form:label></td>
			<td><form:input path="amount" id="amount"/></td>
			
		</tr>
		<tr>
			<td><form:label path="location">Location: </form:label></td>
			<td><form:input path="location" id="location"/></td>
			
		</tr>
		<tr>
			<td><form:label path="requiredDate">Date: </form:label></td>
			<td><form:input path="requiredDate" /></td>
			
		</tr>
		<tr>
			<td><form:label path="time">Time: </form:label></td>
			<td><form:input path="time" /></td>
			
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