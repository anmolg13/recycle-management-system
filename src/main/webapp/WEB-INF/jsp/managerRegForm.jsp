<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>  
.error{color:red}  
</style>  
</head>
<body>

<div align="center">
<form:form onsubmit="return managerValidate()"  action="submitForm" modelAttribute="manager" method="post">

<table>

<tr>
<td><label for="firstname">First Name:</label></td>
<td><form:input path="firstName" type="text" placeholder="Enter FirstName" id="firstname"/></td>
<td id="firstnameerrormsg"><form:errors path="firstName" cssClass="error"/></td>
</tr>

<tr>
<td><label for="lastname">Last Name:</label></td>
<td><form:input path="lastName" type="text" placeholder="Enter LastName" id="lastname"/></td>
<td id="lastnameerrormsg"><form:errors path="lastName" cssClass="error"/></td>
</tr>

<tr>
<td><label for="contact">Contact Number:</label></td>
<td><form:input path="contact" type="text" placeholder="Enter Contact Number" id="contact" pattern="[0-9]+"/></td>
<td id="contacterrormsg"><form:errors path="contact" cssClass="error"/></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><form:input path="email" type="text" placeholder="Enter Email" id="email"/></td>
<td id = "emailerrormsg"><form:errors path="email" cssClass="error"/></td>
</tr>

<tr>
<td><label for="password">Password:</label></td>
<td><form:input path="password" type="text" placeholder="Enter Password" id="password"/></td>
<td id= "passerrormsg"><form:errors path="password" cssClass="error"/></td>
</tr>

<tr>
<td><label for="skills">Select Skill:</label></td>
<td>Skill1<form:radiobutton path="skill" value="Skill1" name="skills"/>Skill2<form:radiobutton path="skill" value="Skill2" name="skills"/>Skill3<form:radiobutton path="skill" value="Skill3" name="skills"/></td>
<td><form:errors path="skill" cssClass="error"/></td>
</tr>

<tr>
<td><label for="gender">Select Gender:</label></td>
<td>Male<form:radiobutton path="gender" value="Male" name="gender"/>Female<form:radiobutton path="gender" value="Male" name="gender"/></td>
<td><form:errors path="gender" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" value="submit"></td>
<td><input type="reset" value="reset"></td>
<td></td>
</tr>

</table>
</form:form>

<script type="text/javascript">
function managerValidate()
{
	

    var flag = true;
    
	var firstname = document.getElementById("firstname");
	if(firstname.value.length<3 || firstname.value.length>15)
	{
		firstname.style.borderColor="red";
		firstname.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("firstnameerrormsg");
		errormsg.innerHTML = "length should be 3-15";
		errormsg.style.color = "red";
		flag = false;
	}
	else
	{
		firstname.style.borderColor="";
		firstname.style.backgroundColor = "";
		var errormsg = document.getElementById("firstnameerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}

	var lastname = document.getElementById("lastname");
	if(lastname.value.length<3 || lastname.value.length>15)
	{
	lastname.style.borderColor="red";
	lastname.style.backgroundColor = "#fc566c";
	var errormsg = document.getElementById("lastnameerrormsg");
	errormsg.innerHTML = "length should be 3-15";
	errormsg.style.color = "red";
	flag = false;
	}
	else
	{
		lastname.style.borderColor="";
		lastname.style.backgroundColor = "";
		var errormsg = document.getElementById("lastnameerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}

	var contact = document.getElementById("contact");
	if(contact.value.length!=10)
	{
	contact.style.borderColor="red";
	contact.style.backgroundColor = "#fc566c";
	var errormsg = document.getElementById("contacterrormsg");
	errormsg.innerHTML = "enter correct contact number";
	errormsg.style.color = "red";
	flag = false;
	}
	else
	{
		contact.style.borderColor="";
		contact.style.backgroundColor = "";
		var errormsg = document.getElementById("contacterrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
	}
	
	var email = document.getElementById("email");
	var patt = /[a-zA-Z0-9]+@[a-zA-Z0-9]/g;
	if(!patt.test(email.value))
		{
		email.style.borderColor="red";
		email.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("emailerrormsg");
		errormsg.innerHTML = "enter correct email";
		errormsg.style.color = "red";
		flag = false;
		}
	    else
		{
		email.style.borderColor="";
		email.style.backgroundColor = "";
		var errormsg = document.getElementById("emailerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
		}

	var password = document.getElementById("password");
	if(password.value.length<6)
	{
		password.style.borderColor="red";
		password.style.backgroundColor = "#fc566c";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "password length should be minimum 6";
		errormsg.style.color = "red";
		flag = false;
		}
	    else
		{
		password.style.borderColor="";
		password.style.backgroundColor = "";
		var errormsg = document.getElementById("passerrormsg");
		errormsg.innerHTML = "";
		errormsg.style.color = "";
		}

	if(!flag)
		{
	alert("Please update the highlighted manadatory field");
		}
	return flag;
	}
</script>
</div>
</body>
</html>