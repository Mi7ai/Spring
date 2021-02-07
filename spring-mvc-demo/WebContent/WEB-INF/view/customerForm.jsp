<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Customer - Form</title>
<style type="text/css">
	.error {color:red}
</style>
</head>
<body>
	<h2>Hi Customer Registration - Form</h2>
	<p>Fill out the form!</p>
	<form:form action="processForm" modelAttribute="customer">
		First Name: <form:input path="firstName" />
		<br/>
		
		Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>
		<br/>
		
		Free passes: <form:input path="freePasses" value="1"/>
		<form:errors path="freePasses" cssClass="error"/>
		<br/>
		
		Postal Code: <form:input path="postalCode" value="12345"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br/>
		
		<br/>
		<input type="submit" name="Submit" value="Submit" />
	</form:form>


</body>
</html>