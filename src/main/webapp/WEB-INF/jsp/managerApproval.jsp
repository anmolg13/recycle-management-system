<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">

<h1>Approve Manager</h1>
<table border="1">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Phone Number</th>
<th>Skills</th>
<th>Gender</th>
<th>Approved</th>
</tr>

<c:forEach items="${managerdetails}" var="details">
       <tr>
         <td>${details.firstName}</td>
         <td>${details.lastName}</td>
         <td>${details.contact}</td>
         <td>${details.email}</td>
         <td>${details.gender}</td>
         <td>${details.skill}</td>
         <td>${details.approval}</td>
       </tr>
     </c:forEach>
</table>

<br>
<br>

<form action="submitApproval" method="post">

<table>
<tr>
<td><label for="email">Enter Manager Email:</label></td>
<td><input type="text" placeholder="Enter Manager Email" id="email" name="email"></td>
</tr>

<tr>
<td><label for="approve">Approved:</label></td>
<td><select id="approve" name="approve">
<option value="Yes">Yes</option>
<option value="No">No</option>
</select></td>
</tr>

<tr>
<td><input type="submit" value="Submit"></td>
<td></td>
</tr>
</table>
</form>
</div>
</body>
</html>