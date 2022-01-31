<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Home</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

	<c:if test="${empty sellerObj }">
		<c:redirect url="../login.jsp" />		
	</c:if>
	
	<div class ="container">
		<div class="row p-3">
			<div class="col-md-3">
				<a href="add_book.jsp">
				<div class ="card">
					<div class="card-body text-center">
						<br>
						<h4>Add Book</h4>
					</div>
				</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="all_book.jsp">
				<div class ="card">
					<div class="card-body text-center">
						<br>
						<h4>All Book</h4>
					</div>
				</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="orders.jsp">
				<div class ="card">
					<div class="card-body text-center">
						<br>
						<h4>Buy Books_List</h4>
					</div>
				</div>
				</a>
			</div>
			<div class="col-md-3">
			<a href="../login.jsp">
				<div class ="card">
					<div class="card-body text-center">
						<br>
						<h4>LogOut</h4>
					</div>
				</div>
				</a>
			</div>
		
		</div>
	
	
	
	</div>

</body>
</html>