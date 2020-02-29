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
		<div class="loginReg">
		<marquee loop=".5" direction="left" scrollamount="25" behavior="slide"><img src="/images/eventfree2.png"></marquee>
	</div>
		<br>
		<div class="regContainer">
			<h3><font color="violet">Registration</font></h3>
			<form:form action="/register" method="post" modelAttribute="user">
				<p>
					<font color="violet">First Name:</font>
					<form:input path="firstName" />
					<form:errors path="firstName" />
				</p>
				<p>
					<font color="violet">Last Name:</font>
					<form:input path="lastName" />
					<form:errors path="lastName" />
				</p>
				<p>
					<font color="violet">Email:</font>
					<form:input type="email" path="email" />
					<form:errors path="email" />
					<form:errors path="duplicate" />
				</p>
				<p>
					<font color="violet">Password:</font>
					<form:input type="password" path="password" />
					<form:errors path="password" />
				</p>
				<p>
					<font color="violet">Password Confirmation:</font>
					<form:input type="password" path="passwordConfirmation" />
					<form:errors path="passwordConfirmation" />
				</p>
				<button type="submit" class="btn btn-info btn-block">Register</button>
			</form:form>
		</div>
		<hr>
		<div class="loginContainer">
			<h3><font color="violet">Login</font></h3>
			<form action="/login" method="post">
				<p>
					<font color="violet">Email:</font>
					<input name="email" />
				</p>
				<p>
					<font color="violet">Password:</font>
					<input type="password" name="password" />
					<button type="submit" class="btn btn-info">Login</button>
				</p>
				<c:out value="${invalid }" />
			</form>
		</div>
	</div>
</html>