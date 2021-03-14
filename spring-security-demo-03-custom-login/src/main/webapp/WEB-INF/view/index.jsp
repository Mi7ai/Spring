<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Hi from Home</h1>
	<form:form class="container" action="${pageContext.request.contextPath}/logout"
		method="POST">

		<button type="submit" class="btn btn-primary">Logout</button>
	</form:form>
</body>
</html>