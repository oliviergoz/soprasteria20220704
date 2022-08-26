<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><c:set
	var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form action="${ctx}/fournisseur" method="post"
			modelAttribute="fournisseur">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.prenom">prenom du contact:</form:label>
				<form:input path="contact.prenom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.nom">nom du contact:</form:label>
				<form:input path="contact.nom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="contact.mail">mail du contact:</form:label>
				<form:input path="contact.mail" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero:</form:label>
				<form:input path="adresse.numero" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.rue">rue:</form:label>
				<form:input path="adresse.rue" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.codePostal">code postal:</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/fournisseur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>