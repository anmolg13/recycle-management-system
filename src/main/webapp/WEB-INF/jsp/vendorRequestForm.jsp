<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recycle Management System</title>
<link rel="stylesheet" href="/css/styles.css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default bg-success navbar-dark">
		<div class="container-fluid">

			<div class="navbar-header navbar-right">
				<a href="/recycleManagementHomePage">
					<button onclick="myFunction()" class="btn btn-info btn-lg">
						<span class="glyphicon glyphicon-log-out"></span> Log out
					</button>
				</a>
			</div>

			<div class="navbar-header">
				<button class="btn btn-info btn-lg" id="goback"
					onclick="goToUserPage()">
					<span class="glyphicon glyphicon-arrow-left"></span> Go Back
				</button>
			</div>

			<div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>

		</div>
	</nav>
	<div class="container content">
		<div style="background: rgb(139, 0, 139);" class="jumbotron heading">
			<h1 style="color: white; text-align: center">Vendor Request Form</h1>
		</div>
		<form:form method="POST" action="welcomeUser" modelAttribute="request">
			<tr>
				<td><form:hidden path="requestId" id="id" /></td>
			</tr>
			<table class="table">

				<tr>
					<td><form:label path="typeOfOrg">Type of Organization: </form:label></td>
					<td><form:radiobutton path="typeOfOrg" value="Restaurant"
							required="required" />Restaurant <form:radiobutton
							path="typeOfOrg" value="Hostel" required="required" />Hostel</td>
				</tr>
				<tr>
					<td><form:label path="amount">Amount of Manure: </form:label></td>
					<td><form:input type="number" path="amount" id="amount"
							required="required" /></td>

				</tr>
				<tr>
					<td><form:label path="location">Location: </form:label></td>
					<td><form:input path="location" id="location"
							required="required" /></td>

				</tr>
				<tr>
					<td><form:label path="requiredDate">Date: </form:label></td>
					<td><form:input type="date" path="requiredDate" min="${date}"
							required="required" /></td>

				</tr>
				<tr>
					<td><form:label path="time">Time: </form:label></td>
					<td><form:input path="time" required="required" /></td>

				</tr>

				<tr>
					<td><button id="btn-success" type="submit" id="submit"
							name="submit">Submit</button></td>
					<td><button id="btn-clear" type="reset" id="reset"
							name="reset">Clear</button></td>
				</tr>

			</table>
		</form:form>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>