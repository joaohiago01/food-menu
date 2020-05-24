<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<title>Food Menu</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>
	<%@page import="entity.Client, javax.servlet.http.HttpSession"
		language="java"%>
	<%
		HttpSession httpSession = request.getSession();
	httpSession.setAttribute("clientLogged", request.getSession().getAttribute("clientLogged"));
	httpSession.setAttribute("page", "./pages/profile.jsp");
	response.sendRedirect("../ClientServlet");
	Client client = (Client) request.getSession().getAttribute("clientLogged");
	%>
	<nav class="navbar navbar-expand-lg navbar-danger bg-danger">
		<a class="navbar-brand text-light font-weight-bold" href="main.jsp">Food
			Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="profile.jsp">Perfil</a></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="restaurant_edit.jsp">Restaurante</a></li>
				<li class="nav-item dropdown text-light"><a
					class="nav-link dropdown-toggle text-light font-weight-bold"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Cardápio </a>
					<div class="dropdown-menu bg-danger"
						aria-labelledby="navbarDropdownMenuLink">
						<form action="../CategoryProductServlet" method="get">
							<input class="dropdown-item text-light font-weight-bold"
								type="submit" value="Categorias" />
						</form>
						<form action="../ProductServlet" method="get">
							<input class="dropdown-item text-light font-weight-bold"
								type="submit" value="Produtos" />
						</form>
					</div></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="login.jsp">Sair</a></li>
			</ul>
		</div>
	</nav>

	<div class="card-body">
		<form class="needs-validation" novalidate method="post"
			action="../ClientSevlet">
			<input type="hidden" name="_method" value="PUT" />
			<div class="form-group">
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputName">Nome Completo</label> <input type="text"
						class="form-control" id="inputName" name="name"
						placeholder="Qual o nome do dono do restaurante?"
						required="required" value="<%client.getName();%>" />
					<div class="invalid-feedback">Por favor, informe o nome do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputEmail">E-mail</label> <input type="email"
						class="form-control" id="inputEmail" name="email"
						placeholder="Qual o e-mail do dono do restaurante?"
						required="required" value="<%client.getEmail();%>" />
					<div class="invalid-feedback">Por favor, informe o e-mail do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputCpf">CPF</label> <input type="text"
						class="form-control" id="inputCpf" name="cpf"
						placeholder="Qual o CPF do dono do restaurante?"
						required="required" value="<%client.getCpf();%>" />
					<div class="invalid-feedback">Por favor, informe o cpf do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputPassword">Senha</label> <input type="password"
						class="form-control" id="inputPassword" name="password"
						placeholder="Digite uma senha" required="required"
						value="<%client.getPassword();%>" />
					<div class="invalid-feedback">Por favor, informe a senha do
						dono do restaurante.</div>
				</div>
			</div>

			<button type="submit"
				class="btn btn-danger btn-lg btn-block font-weight-bold">Salvar
				Mudanças</button>
		</form>
	</div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputCpf").mask("999.999.999-99");
		});
	</script>
	<script>
		// Exemplo de JavaScript inicial para desativar envios de formulário, se houver campos inválidos.
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Pega todos os formulários que nós queremos aplicar estilos de validação Bootstrap personalizados.
						var forms = document
								.getElementsByClassName('needs-validation');
						// Faz um loop neles e evita o envio
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>
</body>
</html>