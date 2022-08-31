<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>les produits</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>libelle</th>
					<th>description</th>
					<th>prix</th>
					<th>fournisseur</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produits}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.libelle}</td>
						<td>${p.description}</td>
						<td>${p.prixUnitaire}</td>
						<td>${p.fournisseur.nom }</td>
						<td><a href="${ctx}/produit/edit/${p.id}"
							class="btn btn-outline-primary">editer</a></td>
						<td><a href="${ctx}/produit/delete/${p.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${ctx}/produit/add" class="btn btn-link">ajouter un
			produit</a>
	</div>
</body>
</html>