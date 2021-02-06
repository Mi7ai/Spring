<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>
	<h2>Student Page</h2>
	<p>Student: ${student.firstName} ${student.lastName}</p>
	<p>Country: ${student.country}</p>
	<p>Favourite Programming Language: ${student.programmingLanguage}</p>
	<p>Operating System: </p>
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>