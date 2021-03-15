<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	<h1 class="text-center">Hi from Login</h1>

	<form class="container" action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<!-- Check for login error -->

		<c:if test="${param.error != null}">
			<div class="text-danger">Sorry! You entered invalid username/password.</div>
		</c:if>
		
		<!-- Check for logout error -->

		<c:if test="${param.logout != null}">
			<div class="text-primary">You have been logged out!</div>
		</c:if>

		<div class="mb-3">
			<label for="exampleInputName" class="form-label" >User name: </label>
			<input type="text" name="username" placeholder="Username" class="form-control" id="exampleInputName" aria-describedby="nameHelp">
		</div>
		
		<div class="mb-3">
			<label for="exampleInputPass" class="form-label">Password: </label>
			<input type="password" name="password" placeholder="Password" class="form-control" id="exampleInputPass" aria-describedby="passHelp">
		</div>
	 
		<button type="submit" class="btn btn-primary">Submit</button>
		<!-- Added manual csrf -->
		<!-- Deleted form:>>>form tags -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>