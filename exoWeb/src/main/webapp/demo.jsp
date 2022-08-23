<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String texte = "du texte";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>ma jsp</h1>
	<div>debut de la scriptlet</div>
	<%
	for (int i = 10; i < 30; i=i+5) {
	%>
		<p style="font-size: <%=i%>px">i=<%=i%></p>
	<%
	}
	%>
	<div>fin de la scriplet</div>
</body>
</html>