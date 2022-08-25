<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>prenom:</th>
					<th>nom:</th>
					<th>mail:</th>
					<th>adresse:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
						<td>${client.id}</td>
						<td>${client.prenom}</td>
						<td>${client.nom}</td>
						<td>${client.mail}</td>
						<td>${client.adresse.adresseComplete}</td>
						<td><a href="?q=edit&id=${client.id}"
							class="btn btn-outline-primary">editer</a></td>
						<td><a href="?q=delete&id=${client.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="?q=add" class="btn btn-link">nouveau client</a>
		</div>
	</div>
</body>
</html>