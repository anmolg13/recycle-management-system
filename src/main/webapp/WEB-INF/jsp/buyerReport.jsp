<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1>Hey welcome to admin page</h1>
<table>
    <form method="POST" action="/viewReportForBuyer">
        <b>${msg}</b>
        <b>${msg2}</b>
        <tr>
            <td><input type="date" name="date1" id="date1" value="${date1}" max="${today}"></input></td>
        </tr>
        <tr>
            <td><input type="date" name="date2" id="date2" value="${date2}" max="${today}"></input></td>
        </tr>
        <c:if test="${status}">
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
                </tr>
            </c:forEach>
        </c:if>
        <tr>
            <td><input type="submit"/></td>
        </tr>

    </form>

    <c:if test="${status}">
        <tr>
            <td>
                <form method="GET" action="/downloadReportForBuyer">
                    <input type="hidden" name="date1" value="${date1}" max="${today}">
                    <input type="hidden" name="date2" value="${date2}" max="${today}">

                    <input type="submit" value="Download the report">
                </form>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>