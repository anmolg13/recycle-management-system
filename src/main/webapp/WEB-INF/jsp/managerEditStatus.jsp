<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Edit Status</h1>

<form action="submitstatus" method="post">

<table>

<tr>
<td><label for="requestid">Enter Request Id:</label></td>
<td><input type="number" id="requestid" name="requestid"></td>
</tr>

<tr>
<td><label for="status">Change Status To:</label></td>
<td><select name="status" id="status">
<option value="New">New</option>
<option value="Waiting for Truck Availability">Waiting for Truck Availability</option>
<option value="Truck Send">Truck Send</option>
<option value="Received">Received</option>
</select></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Change Status"></td>
</tr>

</table>

</form>
</div>
</body>
</html>