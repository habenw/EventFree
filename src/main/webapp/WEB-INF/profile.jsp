<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
   	   <link rel="stylesheet" href="/css/style.css">
	   <script type="text/javascript" src="js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<div id="container">
		<div id="head">
			<h1>My Profile</h1>
		</div>
		<div id="main">
			<p>My name is <c:out value="${user.firstName} ${user.lastName}"/>.</p>
			<p>My email address is <c:out value="${user.email}"/>.</p>
		</div>
		<div id="foot">
			<a href="/editprofile">Edit My Profile</a>  -  <a href="/events">Back to Dashboard</a>
		</div>
	</div>
</body>
</html>