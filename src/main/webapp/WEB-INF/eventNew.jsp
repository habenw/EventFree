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
<title>EVENTS ARE BORN HERE</title>
</head>
<body>
 	<h1>EVENTS ARE BORN HERE!!!</h1>
 	<a href="/events" class="btn btn-primary">Cancel</a>
	<div class="container">
		<form:form action="/events/new" method="post" modelAttribute="new">
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
			<form:input type="hidden" path="creator" value="${user.id }" />
			<br>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>