<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
</head>
<body>
	<h2>List Customers is coming</h2>
	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<!-- customer is the attribute from CustomerController  -->
				<c:forEach var="tempCustomer" items="$(customers)">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>