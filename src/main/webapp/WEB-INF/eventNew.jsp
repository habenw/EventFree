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
<title>GREAT IDEAS ARE BORN HERE</title>
</head>
<body>
 	<h1>GREAT IDEAS ARE BORN HERE!!!</h1>
 	<a href="/dashboard" class="btn btn-primary">Cancel</a>
	<div class="container">
		<form:form action="/ideaNew" method="post" modelAttribute="new">
			<p>
				New Idea Title:
				<form:input path="ideaName" />
				<form:errors path="ideaName" />
			</p>
			<p>
				Idea Details (explain):
				<form:input path="ideaDetail" />
				<form:errors path="ideaDetail" />
			</p>
			<form:input type="hidden" path="user" value="${user.id }" />
			<br>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>