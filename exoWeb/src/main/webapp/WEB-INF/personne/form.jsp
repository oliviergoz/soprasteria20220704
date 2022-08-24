<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE
html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${error != null }">
		un message d'erreur
	</c:if>
	<form action="" method="post">
		<input name="prenom"><br> <input name="nom"><br>
		<button type="submit">envoyer</button>
	</form>
</body>
</html>