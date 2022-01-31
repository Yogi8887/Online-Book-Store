<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DAO.SellerDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="com.entity.Seller"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book:Buy</title>
<%@include file="admin/allCss.jsp"%>
</head>
<body>
	<%@include file="admin/navbar.jsp"%>

	<div class="container p-2">
		<div class="row">
			<div class="col md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Buy Book</h2>
						
												
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
						BookDetails b = dao.getBookById(id);
						%>
						
						<form action="OrderServlet" method="post">
						<input type="hidden" name = "id" value="<%=b.getBookId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">OrderId</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="oid" value="<%=b.getBookId() %>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Customer Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="cname">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Book_name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname" value="<%=b.getBookname() %>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Address</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="address">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="price" value="<%=b.getPrice() %>">
							</div>
							<button type="submit" class="btn btn-primary">Buy Cash
								On</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="admin/footer.jsp" %>
</body>
</html>