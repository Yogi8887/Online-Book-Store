<%@page import="com.entity.Order"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All sold book</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<h3>Hello, Admin</h3>
	<c:if test="${empty sellerObj }">
		<c:redirect url="../login.jsp" />		
	</c:if>
	<c:if test="${not empty succMsg }">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">OrderID</th>
				<th scope="col">Customer Name</th>
				<th scope="col">Book Name</th>
				<th scope="col">Address</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<%
			OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConncetion());
			List<Order> list = dao.getAllOrder();
			for(Order o : list){
			%>
			<tr>
				<th><%= o.getId() %></th>
				<td><%= o.getOrderid() %></td>
				<td><%= o.getCustomerName() %></td>
				<td><%= o.getBookName() %></td>
				<td><%= o.getAddress() %></td>
				<td><%= o.getPrice() %></td>
			</tr>

			<% 
			}
		%>
				
		</tbody>
	</table>

	<%@include file="footer.jsp"%>

</body>
</html>