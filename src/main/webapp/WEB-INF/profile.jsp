<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
   	   <link rel="stylesheet" href="/css/style.css">
	   <script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet" href="/css/main.css">
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<div class="profilePg">
	<%-- <div class="containerInfo">
		<div class="card" style="width: 40%;">
		  <div class="card-body">
		    <h3 class="card-title"><c:out value="${user.firstName} ${user.lastName}"/></h3>
		    <p class="card-text"><c:out value="${event.description }"/></p>
		    <p class="card-text"><c:out value="${event.location }"/></p>
		    <p class="card-text"><c:out value="Created By: ${event.creator.firstName}"/></p>
		    <a href="/events/${event.id}/edit" class="card-link">Update</a>
		 </div>
		</div>
	</div> --%>
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
</div>
</body>
</html>