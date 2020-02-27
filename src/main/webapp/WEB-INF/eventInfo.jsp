<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>ABOUT THIS EVENT</title>
</head>
<body>
	<h1>All about this event!</h1>
	<br>
	<a href="/events" class="btn btn-primary">Back to Your Events Page</a>
	<br>
	<br>
	<br>
	<div class="containerInfo">
		<div class="card" style="width: 40%;">
		  <div class="card-body">
		    <h3 class="card-title"><c:out value="${event.name }"/></h3>
		    <p class="card-text"><c:out value="${event.description }"/></p>
		    <p class="card-text"><c:out value="${event.location }"/></p>
		    <p class="card-text"><c:out value="Created By: ${event.user.creator}"/></p>
		    <a href="/event/${event.id}/edit" class="card-link">Update</a>
		  </div>
		</div>
	</div>
</body>
</html>