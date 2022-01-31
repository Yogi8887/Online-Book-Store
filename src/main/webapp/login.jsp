<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookSotre: Login</title>
<%@include file="allcomponent/allCss.jsp"%>
</head>
<body>
	<%@include file="allcomponent/navbar.jsp"%>
	<div class="container p-2">
		<div class="row">
			<div class="col md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Login Page</h2>
						
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session"/>
						</c:if>
					
						
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email" >
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							
							<button type="submit" class="btn btn-primary text-center">Submit</button>
							<br>
							<a href="register.jsp">create account</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>