<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.table {
    border-collapse: separate;
    border-spacing:0 20px;
    border: 1px;
}
label {
    display: inline;
    padding: .2em .6em .3em;
    font-size: 110% !important;
    font-weight: 700;
    width: -webkit-fill-available;
    line-height: 1;
    color: #fff;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: .25em;
    }

</style>
<meta charset="ISO-8859-1">
<title>USER LOGIN</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container content">
<div style="background: rgb(139,0,139);" class="jumbotron heading">
<h1 style="color: white; text-align: center">Recycle Management System</h1>
</div>
	<font color="red">${message}</font>
	<form method="post" action="/loginUser">
	<span class="border border-secondary">
	<table class="table">
		<tr>
			<td><label class="label label-primary" for="name" >Email:</label></td>
			<td><input type="text" name="email" class="form-control"/></td>
		</tr>
		<tr>
			<td><label class="label label-primary" for="password" >Password:</label></td>
			<td><input type="password" name="password" class="form-control"/></td>
		</tr>
		<tr>
			<td><button class="btn btn-success" type="submit" id="submit" name="submit">Submit</button></td>
			<td><button class="btn btn-warning" type="reset" id="reset" name="reset">Clear</button></td>
		</tr>
	</table>
</form>

</body>
</html>