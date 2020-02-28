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
<title>USER HOME</title>
</head>
<body>
	<div class="dashPage">
	 	<h1><c:out value="Welcome, ${user.firstName }!"/></h1>
	 	<a href="/logout" class="btn btn-danger">Logout...Bye Bye</a>
		<br>
		<br>
		<div class = "containerDashTasks">
			<h1>Lets Get Eventful!</h1>
			<%-- <div>
				<p>
				<form action="/search/event">
					<input name="search"/>
					<button type="submit">Search</button>
				</form>
				</p>
			</div> --%>
			<div class="table">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Events</th>
							<th>Created By</th>
							<th>Stuff & Things</th>
						</tr>
					</thead>
					<tbody>
						<%-- <c:forEach items="${allEvents}" var="event">
							<tr>
								<td>
									<a href="/events/${idea.id}" style="a:visited"><c:out value="${event.name}"/></a>
								</td>
								<td>
									<a href="/user/info/${idea.user.id}"><c:out value="${event.user.name}"/></a>
								</td>
								<td>
									<a href="/user/info/${idea.id}"><c:out value="Like"/></a>
									
									<a href="/user/info/${idea.id}"><c:out value="Dislike"/></a>
								</td>
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
			</div>
			<a href="/events/new" class="btn btn-primary">Add An Event</a>
		</div>
		<br>
		<div class="containerDashUsers">
			<h1>Users</h1>
			<%-- <div>
				<p>
				<form action="/search/user">
					<input name="search"/>
					<button type="submit">Search</button>
				</form>
				</p>
			</div> --%>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>User</th>
					</tr>
				</thead>
				<tbody>
					<%-- <c:forEach items="${allUsers}" var="user">
						<tr>
							<td>
								<a href="/user/info/${user.id}"><c:out value="${user.name}"/></a>
							</td>
						</tr>
					</c:forEach> --%>
				</tbody>
			</table>
		</div>
	 	<a href="/" class="btn btn-success">Home Page</a>
	</div>
</body>
</html>