<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="container-fluid-p-3">
	<div class="row">
		<div class="col-md-3">
			<h3>Book Store</h3>
		</div>
		<div class="col-md-6">
			
		</div>
		<div class="col-md-3">
		<c:if test="${not empty sellerObj }">
			<a href="login.jsp" class="btn btn-success">${sellerObj.name}</a>
			<a href="../login.jsp" class="btn btn-primary">LogOut</a>	
		</c:if>
		<c:if test="${empty sellerObj }">
		
			<a href="../login.jsp" class="btn btn-success">Login</a>
			<a href="../register.jsp" class="btn btn-primary">SignUp</a>
		</c:if>



	</div>

</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="../index.jsp">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Book List
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
		
	</div>
</nav>