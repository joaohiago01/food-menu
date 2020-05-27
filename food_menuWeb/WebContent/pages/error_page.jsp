<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Menu - Erro</title>
</head>
<body>
	<%@page isErrorPage="true"%>
	<% try {
		
	} catch (Exception e) {
		
		%>
	<div class="card-header card bg-danger mb-3">
		<div class="alert alert-danger" role="alert">
			Um erro ocorreu, por favor <a href="login.jsp" class="alert-link">clique
				aqui</a> para ser redirecionado.
		</div>
	</div>
	<% } %>
</body>
</html>