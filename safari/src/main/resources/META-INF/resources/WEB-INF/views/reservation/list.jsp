<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp"></jsp:include>
		<h1>liste des reservations</h1>
		<table class="table">
			<c:forEach items="${reservations}" var="r">
				<tr>
					<td>${r.id}</td>
					<td>${r.statut}</td>
					<td>${r.date}</td>
					<td>${r.note}</td>
					<td>${r.activite.getClass().simpleName}</td>
					<td>${r.participant.identite}</td>
					<td><a href="${ctx}/reservation/edit?id=${r.id}" class="btn btn-outline-primary">edition</a></td>
					<td><a href="${ctx}/reservation/delete?id=${r.id}" class="btn btn-outline-danger">suppression</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/reservation/add/aquatique" class="btn btn-link">reservation activite aquatique</a>
		<a href="${ctx}/reservation/add/safari" class="btn btn-link">reservation activite safari</a>
	</div>
	
</body>
</html>