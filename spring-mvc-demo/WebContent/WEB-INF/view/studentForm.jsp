<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Student - Form</title>
</head>
<body>
	<h2>Hi Show Name - Form</h2>
	<form:form action="processForm" modelAttribute="student" method="get">
		<!-- 		firstName is a property of Student class -->
		First Name: <form:input path="firstName" />
		<br/>
		<!-- 		lastName is a property of Student class -->
		Last Name: <form:input path="lastName" />
		<br/>
		
		Country: 
<!-- 		on submit it will call student.setCountry from Student class -->
		<form:select path="country">
			<form:option value="Brazil"  label="Brazil"/>
			<form:option value="France"  label="France"/>
			<form:option value="Norway"  label="Norway"/>
			<form:option value="Romania" label="Romania"/>
		</form:select>
		<br/>
		<input type="submit" name="Submit" value="Submit" />
	</form:form>


</body>
</html>