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
<title>GREAT IDEAS ARE UPDATED HERE</title>
</head>
<body>
	<h1>GREAT IDEAS ARE UPDATED HERE!!!</h1>
	<a href="/idea/info/${idea.id }" class="btn btn-primary">Cancel</a>
	<br>
	<br>
	<form:form action="/idea/update/${idea.id }" method="post" modelAttribute="idea">
		<input type="hidden" name="_method" value="put">
		<p>
			Idea Name:
			<form:input path="ideaName" />
			<form:errors path="ideaName" />
		</p>
		<p>
			Idea Details:
			<form:input path="ideaDetail" />
			<form:errors path="ideaDetail" />
		</p>
		<form:input type="hidden" path="user" value="${idea.user.id }" />
		<br>
		<button type="submit" class="btn btn-success">Submit Changes</button>
	</form:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="/idea/delete/${idea.id}" class="btn btn-danger">DELETE THIS IDEA</a>
</body>
</html>