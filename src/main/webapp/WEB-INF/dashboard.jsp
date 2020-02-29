<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/main.css">
<meta charset="UTF-8">
<title>USER HOME</title>
</head>
<body>
	<div class="dashPage">
	 	<h1><c:out value="Welcome, ${user.firstName }!"/></h1>
		<br>
		<br>
		<div class = "containerDashTasks">

			<nav class="navbar navbar-expand-lg navbar-light">
			  <a class="navbar-brand" href="/profile">My Profile</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Events Happening Soon!
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="#">Events Today</a>
			          <a class="dropdown-item" href="#">Events This Week</a>
			          <div class="dropdown-divider"></div>
			          <a class="dropdown-item" href="#">Custom Sort</a>
			        </div>
			      </li>
			      <li class="nav-item active">
			        <a class="nav-link" href="/logout">Logout<span class="sr-only">(current)</span></a>
			      </li>
			    </ul>
			    <form action="/events/search">
					<input name="search"/>
					<button type="submit">Search</button>
				</form>
			  </div>
			</nav>
			
			<h1>Lets Get Eventful!</h1>
			<div class="table">
				<table class="table table-striped">
					<thead>
						<tr>
							<font size="6">
							<th><font size="6">Events</font></th>
							<th><font size="6">Created By</font></th>
							<th><font size="6">Date of Event</font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allEvents}" var="event">
						<tr>
							<td>
								<a href="/events/${event.id}" style="a:visited"><font size="6" color="violet"><c:out value="${event.name}"/></font></a>
							</td>
							<td>
								<font size="6" color="violet"><c:out value="${event.creator.firstName} ${event.creator.lastName}"/></font>
							</td>
							<td>
								<font size="6" color="violet"><c:out value="2/30/2098"/></font>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<a href="/events/new" class="btn btn-primary">Add An Event</a>
		</div>
		<br>
		<%-- <div class="containerDashUsers">
			<h1>Users</h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>User</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allUsers}" var="user">
						<tr>
							<td>
								<a href="/profile"><c:out value="${user.lastName}, ${user.firstName}"/></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	 	<a href="/" class="btn btn-success">Home Page</a> --%>
	</div>
</body>
</html>