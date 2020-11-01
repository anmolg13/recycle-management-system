<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.time.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	cell-width: 70%;
	cellpadding: 20px;
}
</style>
</head>
<body>
	
	<form method="GET" action="/requestBetweenDates">
		<table>
			<tr>
				<td><label>Start Date:</label></td>
				<td><input type="date" name="startdate" id="startdate"
					max="${yesterday}" /></td>

			</tr>
			<tr>
				<td><label>End Date:</label></td>
				<td><input type="date" name="enddate" id="enddate"
					max="${yesterday}" /></td>

			</tr>
			<tr>
				<td><button type="submit" id="submit" name="submit">Click
						to Proceed</button></td>
			</tr>

		</table>
	</form>

</body>
</html>
