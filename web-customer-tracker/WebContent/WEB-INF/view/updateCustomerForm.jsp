<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<meta charset="ISO-8859-1">
</head>
<body>
	<h2>Add Customer Form</h2>
	<div class="container">
		<form:form action="updateCustomer" modelAttribute="customer" method="POST">
		<!-- very important for update to work -->
			<form:hidden path="id" />
			
			<div class="form-group">
				<label for="firstName">First Name</label> 
				<form:input path="firstName" class="form-control" placeholder="Enter First Name"/>  
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name</label> 
				<form:input path="lastName" class="form-control" placeholder="Enter Last Name"/>  
			</div>
			
			<div class="form-group">
				<label for="email">Email</label> 
				<form:input path="email" class="form-control" placeholder="Enter Email"/>  
			</div>
			
			<div class="mt-3">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
			
			<div class="mt-3">
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/list" role="button">Back to Customer list</a>
			</div>

		</form:form>
	</div>
</body>
</html>