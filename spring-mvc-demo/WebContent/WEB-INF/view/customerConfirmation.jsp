<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<title>Customer Confirmation</title>
</head>
<body>
	<h2>CustomerPage</h2>
	<p><a href="/spring-mvc-demo">Main Page</a></p>
	<p>Customer: ${customer.firstName} ${customer.lastName}</p>
	<p>Free Passes: ${customer.freePasses}</p>
	<p>Postal Code: ${customer.postalCode}</p>
	<p>Course Code: ${customer.courseCode}</p>
</body>
</html>