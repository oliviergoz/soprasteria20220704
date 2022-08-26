<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="${ctx}/produit" method="post"
			modelAttribute="produit">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true"
					placeholder="generation automatique" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="libelle">libelle:</form:label>
				<form:input path="libelle" cssClass="form-control" />
				<form:errors path="libelle" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="description">description:</form:label>
				<form:textarea path="description" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="prixUnitaire">prix:</form:label>
				<form:input path="prixUnitaire" type="number"
					cssClass="form-control" />
				<form:errors path="prixUnitaire">
					<div>message d'erreur</div>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="fournisseur.id">fournisseur:</form:label>
				<form:select path="fournisseur.id" cssClass="form-control">
					<form:option value="">pas de fournisseur</form:option>
					<form:options items="${fournisseurs}" itemValue="id"
						itemLabel="name" />
				</form:select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>