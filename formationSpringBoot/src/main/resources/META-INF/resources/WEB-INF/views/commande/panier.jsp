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
		<h1>selectionner vos articles</h1>
		<table class="table">
			<thead>
				<tr>
					<th>article</th>
					<th>description</th>
					<th>prix</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produits}" var="p">
					<tr>
						<td>${p.libelle}</td>
						<td>${p.description}</td>
						<td>${p.prixUnitaire}</td>
						<td><a href="${ctx}/commande/add/${p.id}"
							class="btn btn-link">ajouter au panier</a></td>
						<td>${panier[p]}</td>
						<td><c:if test="${panier[p]>0}">
								<a href="${ctx}/commande/remove/${p.id}" class="btn btn-link">retirer</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${ctx}/commande/validation" class="btn btn-link">validation du
			panier</a>
	</div>
</body>
</html>