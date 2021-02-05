<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Student - Form</title>
</head>
<body>
	<h2>Hi Show Name - Form</h2>
	<form:form action="processForm" modelAttribute="student" method="get">
		<!-- 		firstName is the name of the get method of Student class -->
		First Name: <form:input path="firstName" />
		<br/>
		<!-- 		lastName is the name of the get method of Student class -->
		Last Name: <form:input path="lastName" />
		<br/>
		
		Country: 
<!-- 		on submit it will call student.setCountry from Student class -->
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br/>
		<input type="submit" name="Submit" value="Submit" />
	</form:form>


</body>
</html>