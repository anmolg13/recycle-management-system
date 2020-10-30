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

<form action="validatemanager" method="post">

<table>

<tr>
<td><label for="email">Enter Email:</label></td>
<td><input type="text" id="email" name="email" placeholder="Enter Email"></td>
</tr>

<tr>
<td><label for="password">Enter Password:</label></td>
<td><input type="text" id="passsword" name="password" placeholder="Enter Password"></td>
</tr>


<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>

</form>

</div>
</body>
</html>