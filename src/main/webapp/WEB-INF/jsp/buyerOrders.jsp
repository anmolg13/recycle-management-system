<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
	  <title>Buyer Orders</title>
	</head>
	<body>
	   <h1>Buyer Orders</h1>
	   <table>
	   	   
	       <tr>
	           <th>Request Id</th>
	           <th>Buyer Email</th>
	           <th>Amount</th>
	           <th>Quantity Ordered</th>
	           <th>Location</th>
	           <th>Order Date</th>
	           <th>Required Date</th>
	           <th>Payment Date</th>
	           <th>Status</th>
	           <th>Paid Amount</th>
	           <th>Buyer Id</th>
	           <th>Edit Status</th>
	       </tr>
	       <c:forEach items="${orders}" var="order">
	       	 <tr>
	       	 	 <td>${order.requestId}</td>
		         <td>${order.buyerEmail}</td>
		         <td>Rs. ${order.amount}</td>
		         <td>${order.quantity}</td>
		         <td>${order.location}</td>
		         <td>${order.requestDate}</td>
		         <td>${order.requiredDate}</td>
		         <td>${order.paymentDate}</td>
		         <td>${order.status}</td>
		         <td>Rs. ${order.paidAmount}</td>
		         <td>${order.buyerId}</td>		         
		         <td><a href="/edit-status?requestId=${order.requestId}">Edit</a></td>
	       	 </tr>
	       </c:forEach>
	   </table>
	</body>
</html>