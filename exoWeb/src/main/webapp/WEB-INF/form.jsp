<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (request.getAttribute("error") != null) {
	%>
	<div><%=request.getAttribute("error")%></div>
	<%
	}
	%>
	<form action="hello" method="post">
		<input name="prenom">
		<button type="submit">ok</button>
	</form>
</body>
</html>