<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Hi from Home</h1>
	<h3>User: <security:authentication property="principal.username" /></h3>
	<h3>Role(s): <security:authentication property="principal.authorities" /></h3>
	
	<security:authorize access="hasRole('manager')">
		<!-- Add link to managers only -->
		<div class="container">
			<a href="${pageContext.request.contextPath}/leaders">Leadership</a>
		</div>
	</security:authorize>
	
	<security:authorize access="hasRole('admin')">
		<!-- Add link to admins only -->
		<div class="container">
			<a href="${pageContext.request.contextPath}/systems">Administration</a>
		</div>
	</security:authorize>
	
	<form:form class="container" action="${pageContext.request.contextPath}/logout"
		method="POST">

		<button type="submit" class="btn btn-primary">Logout</button>
	</form:form>
</body>
</html>