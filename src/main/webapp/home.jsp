<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDetails"%>
<%@page import="com.entity.Seller"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer:home</title>
<%@include file="allcomponent/allCss.jsp"%>
</head>
<body>
	<%@include file="allcomponent/navbar.jsp"%>
	<%
	Seller sel = (Seller) session.getAttribute("sellerObj");
	%>
	<div>
		<h2 class="text-center text-danger">Welcome to <%=sel.getName() %></h2>
	</div>
	<div class="container">
		<a href="admin/orders.jsp" class="btn btn-sm btn-success">Purchased
			Book</a>
		</td>

	</div>
	<c:if test="${not empty succMsg }">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>

	<br>
	

	<br>
	<div class="container text-center p-4 col-md-12">
		<div class="row">

			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
			List<BookDetails> list = dao.getAllBook();
			for (BookDetails b : list) {
			%>
			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto()%>"
							style="width: 100px; height: 100px">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>
						<div class="row">
							<%-- 
							<%
							if (sel == null) {
							%>
							<a href="login.jsp" class="btn btn-success btn-sm ml-4">Buy</a>
							<%
							} else {
							%>
							<!-- 
							<a href="CartServlet?bid=<%=b.getBookId()%>&&sid=<%=sel.getId()%>"
								class="btn btn-success btn-sm ml-4">Buy</a>
							-->
							<%
							}
							%>
					--%>
							<a href="order.jsp?id=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-4">Buy</a> <a href=""
								class="btn btn-primary btn-sm ml-4"><%=b.getPrice()%><i
								class="fas fa-rupee-sign"></i></a>
						</div>

					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>

	</div>

	<%@include file="allcomponent/footer.jsp"%>

</body>
</html>