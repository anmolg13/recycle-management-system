<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/styles.css"></head>
<body>
<div align="center">
       

<nav class="navbar navbar-custom">
  <div class="container-fluid">
   
     <div class="navbar-header">
        <button class="btn btn-info btn-lg" id="goback" onclick = "history.go(-1);">
          <span class="glyphicon glyphicon-arrow-left"></span> Go Back
        </button>
    </div>
    
  <div class="navbar-custom" style="text-align: center;">
				<span class="navbar-style">Recycle Management System</span>
			</div>
    
  </div>
</nav>

<div class="container content">
<div style="background: rgb(139,0,139);" class="jumbotron heading">
<h1 style="color: white; text-align: center">Manager Login/Registration</h1>
</div>

<br>
<br>

<form action="managerRegForm">
<button type="submit" value="Register" class="btn btn-info">Register</button>
</form>

<br>
<br>

<form action="loginmanager">
<button type="submit" value="Login" class="btn btn-info">Login</button>
</form>

<br>
<br>

</div>
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>