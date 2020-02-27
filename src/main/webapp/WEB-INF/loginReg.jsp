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
<title>LOGIN & REGISTRATION</title>
</head>
<body>
	<div class="logRegPg">
		<br>
		<br>
		<br>
		<div class="regContainer">
			<h3>Registration</h3>
			<form:form action="/register" method="post" modelAttribute="user">
				<p>
					Name:
					<form:input path="name" />
					<form:errors path="name" />
				</p>
				<p>
					Email
					<form:input type="email" path="email" />
					<form:errors path="email" />
					<form:errors path="duplicate" />
				</p>
				<p>
					Password:
					<form:input type="password" path="password" />
					<form:errors path="password" />
				</p>
				<p>
					Password Confirmation.:
					<form:input type="password" path="passwordConf" />
					<form:errors path="passwordConf" />
				</p>
				<button type="submit" class="btn btn-success btn-block">Register</button>
			</form:form>
		</div>
		<hr>
		<div class="loginContainer">
			<h3>Login</h3>
			<form action="/login" method="post">
				<p>
					Email:
					<input name="email" />
				</p>
				<p>
					Password:
					<input type="password" name="password" />
					<button type="submit" class="btn btn-success">Login</button>
				</p>
				<c:out value="${invalid }" />
			</form>
		</div>
	</div>
</html>