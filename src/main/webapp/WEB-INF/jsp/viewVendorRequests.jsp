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
<h1>Vendor Requests</h1>
<form>
<table border="1">
<tr>
<th>Request Id</th>
<th>Vendor Email</th>
<th>Type of Organization</th>
<th>Amount</th>
<th>Location</th>
<th>Request Date</th>
<th>Required Date</th>
<th>Status</th>
<th>Time</th>
<th>Vendor Id</th>
<th>Edit Status</th>
</tr>

<c:forEach items="${requestsList}" var="req">
       <tr>
         <td>${req.requestId}</td>
         <td>${req.vendorEmail}</td>
         <td>${req.typeOfOrg}</td>
         <td>${req.amount}</td>
         <td>${req.location}</td>
         <td>${req.requestDate}</td>
         <td>${req.requiredDate}</td>
         <td>${req.status}</td>
         <td>${req.time}</td>
         <td>${req.vendorId}</td>
         <td><a href="editstatus">Edit Status</a></td>
       </tr>
     </c:forEach>
</table>
</form>

</div>
</body>
</html>