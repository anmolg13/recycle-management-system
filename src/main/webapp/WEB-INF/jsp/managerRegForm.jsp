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
<form:form action="submitForm" modelAttribute="manager" method="post">

<table>

<tr>
<td><label for="firstname">First Name:</label></td>
<td><form:input path="firstName" type="text" placeholder="Enter FirstName" id="firstname"/></td>
<td><form:errors path="firstName" cssClass="error"/></td>
</tr>

<tr>
<td><label for="lastname">Last Name:</label></td>
<td><form:input path="lastName" type="text" placeholder="Enter LastName" id="lastname"/></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>

<tr>
<td><label for="contact">Contact Number:</label></td>
<td><form:input path="contact" type="text" placeholder="Enter Contact Number" id="contact"/></td>
<td><form:errors path="contact" cssClass="error"/></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><form:input path="email" type="text" placeholder="Enter Email" id="email"/></td>
<td><form:errors path="email" cssClass="error"/></td>
</tr>

<tr>
<td><label for="password">Password:</label></td>
<td><form:input path="password" type="text" placeholder="Enter Password" id="password"/></td>
<td><form:errors path="password" cssClass="error"/></td>
</tr>

<tr>
<td><label for="skills">Select Skill:</label></td>
<td>Skill1<form:radiobutton path="skill" value="Skill1"/>Skill2<form:radiobutton path="skill" value="Skill2"/>Skill3<form:radiobutton path="skill" value="Skill3"/></td>
<td><form:errors path="skill" cssClass="error"/></td>
</tr>

<tr>
<td><label for="gender">Select Gender:</label></td>
<td>Male<form:radiobutton path="gender" value="Male"/>Female<form:radiobutton path="gender" value="Male"/></td>
<td><form:errors path="gender" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" value="submit"></td>
<td><input type="reset" value="reset"></td>
<td></td>
</tr>

</table>
</form:form>
</div>
</body>
</html>