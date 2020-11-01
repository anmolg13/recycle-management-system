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
	<h1>Requests List</h1>
	<table>
		<tr>
			<th>Request Id</th>
			<th>Vendor Email</th>
			<th>Type of Org</th>
			<th>Amount</th>
			<th>Location</th>
			<th>Request date</th>
			<th>Collection date</th>
			<th>Status</th>
			<th>Time</th>
			<th>VendorId</th>
		</tr>
		<c:forEach var="req" items="${list}">
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
			</tr >
		</c:forEach>
		
	</table>
	
</body>
</html>
