<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<div class="container">
		<h1>les fournisseurs</h1>
		<c:if test="${param.createOrUpdate != null}">
			<div class="alert alert-primary">${param.createOrUpdate}</div>
		</c:if>
		<c:if test="${param.delete != null}">
			<div class="alert alert-danger">${param.delete}</div>
		</c:if>
		<table class="table">
			<thead>
				<th>id</th>
				<th>nom</th>
				<th>contact</th>
				<th>adresse</th>
				<th></th>
				<th></th>
			</thead>
			<c:forEach items="${fournisseurs}" var="f">
				<tbody>
					<tr>
						<td>${f.id}</td>
						<td>${f.nom}</td>
						<td>${f.contact.prenom}${f.contact.nom}${f.contact.mail}</td>
						<td>${f.adresse.adresseComplete}</td>
						<td><a href="${ctx}/fournisseur/edit/${f.id}"
							class="btn btn-outline-primary"> editer</a></td>
						<td><a href="${ctx}/fournisseur/delete/${f.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<a href="${ctx}/fournisseur/add" class="btn btn-link">ajouter un
			fournisseur</a>
	</div>
</body>
</html>