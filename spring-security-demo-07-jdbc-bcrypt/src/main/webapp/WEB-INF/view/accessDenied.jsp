<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
</head>
<body>
	<h1>Access Denied- You are not authorized to see this page</h1>
	<p><img width="300" height="300" src="https://media.giphy.com/media/JVGLHEuzbVviw/giphy.gif" alt="funny GIF" width="100%"></p>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a> 
</body>
</html>