<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<meta charset="UTF-8">
<title>GREAT IDEAS ARE UPDATED HERE</title>
</head>
<body>
<div class="updatePg">
	<h1>Edit This Event:</h1>
	<a href="/events/${event.id}" class="btn btn-primary">Cancel</a>
	<br>
	<br>
	<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
		<p>
			New Event Title:
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			Event Details:
			<form:input path="description" />
			<form:errors path="description" />
		</p>
		<form:input type="hidden" path="creator" value="${event.creator.id}" />
		<br>
		<button type="submit" class="btn btn-success">Submit Changes</button>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="/delete/${event.id}" class="btn btn-danger">DELETE THIS IDEA</a>
</div>
</body>
</html>