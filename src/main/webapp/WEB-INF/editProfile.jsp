<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
   	   <link rel="stylesheet" href="/css/style.css">
	   <script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet" href="/css/main.css">
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
<div class="editPro">
	<div id="container">
		<div id="head">
			<h1>Edit Profile</h1>
		</div>
		<div id="main">
			<form:form action="/update_profile" method="post" modelAttribute="user">
				<input type="hidden" name="_method" value="put">
				<p>
				Change My Name:
					<form:input path="firstName" />
					<form:errors path="firstName" />
					<form:input path="lastName"/>
					<form:errors path="lastName"/>
				<p>
				Change My Email:
					<form:input path="email" />
					<form:errors path="email" />
				</p>
				<br>
				<button type="submit" class="btn btn-info">Submit Changes</button>
			</form:form>
		</div>
		<div id="foot">
			<p>
				<a href="/events">Back to Dashboard</a>
			</p>
		</div>
	</div>
<div>
</div></body>
</html>