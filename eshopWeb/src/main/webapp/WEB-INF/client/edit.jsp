<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>creation client</h1>
		<form action="" method="post">
			<input type="hidden" name="action" value="${action}" readonly="readonly">
			<div class="form-group">
				<label for="id">id:</label> <input name="id" id="id"
					class="form-control" value="${client.id}" readonly="readonly"
					placeholder="id generer automatiquement">
			</div>
			<div class="form-group">
				<label for="prenom">prenom:</label> <input name="prenom" id="prenom"
					class="form-control" value="${client.prenom}">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input name="nom" id="nom"
					class="form-control" value="${client.nom}">
			</div>
			<div class="form-group">
				<label for="mail">mail:</label> <input type="email" name="mail"
					id="mail" class="form-control" value="${client.mail}">
			</div>
			<div class="form-group">
				<label for="numero">numero:</label> <input name="numero" id="numero"
					class="form-control" value="${client.adresse.numero}">
			</div>
			<div class="form-group">
				<label for="rue">rue:</label> <input name="rue" id="rue"
					class="form-control" value="${client.adresse.rue}">
			</div>
			<div class="form-group">
				<label for="codePostal">code postal:</label> <input
					name="codePostal" id="codePostal" class="form-control"
					value="${client.adresse.codePostal}">
			</div>
			<div class="form-group">
				<label for="ville">ville:</label> <input name="ville" id="ville"
					class="form-control" value="${client.adresse.ville}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="?q=" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>