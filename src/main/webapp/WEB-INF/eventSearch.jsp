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
<title>SEARCH RESULTS</title>
</head>
<body>
	<div class="eventSearch">
		<h1>Your Search Results</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Event Name</th>
					<th>Created By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${results}" var="event">
					<tr>
						<td>
							<a href="/events/${event.id}"><font color="black"><c:out value="${event.name}"/></a>
						</td>
						<td>
							<c:out value="${event.creator.firstName}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br><a href="/events" class="btn btn-success">Dashboard</a>
</body>
</html>