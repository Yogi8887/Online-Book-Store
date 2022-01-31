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
<title>All book</title>
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
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
			List<BookDetails> list = dao.getAllBook();
			for(BookDetails b : list){
			%>
			<tr>
				<th><%= b.getBookId() %></th>
				<td><img src="../book/<%=b.getPhoto() %>"
					style="width: 50px; height: 50px;"></td>
				<td><%= b.getBookname() %></td>
				<td><%= b.getAuthor() %></td>
				<td><%= b.getPrice() %></td>
				<td><a href="edit_books.jsp?id=<%=b.getBookId() %>"
					class="btn btn-sm btn-primary">Edit</a>
					 <a href="../BooksDelete?id=<%=b.getBookId() %>"
					class="btn btn-sm btn-danger">Delete</a></td>
			</tr>

			<% 
			}
		%>
		</tbody>
	</table>

	<%@include file="footer.jsp"%>

</body>
</html>