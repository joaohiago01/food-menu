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

	<nav class="navbar navbar-expand-lg navbar-danger bg-danger">
		<a class="navbar-brand text-light font-weight-bold" href="main.html">Food
			Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="profile.html">Perfil</a></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="restaurant_register.html">Restaurante</a></li>
				<li class="nav-item dropdown text-light"><a
					class="nav-link dropdown-toggle text-light font-weight-bold"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Card�pio </a>
					<div class="dropdown-menu bg-danger"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item text-light font-weight-bold"
							href="category.html">Categorias</a> <a
							class="dropdown-item text-light font-weight-bold"
							href="product.html">Produtos</a>
					</div></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="login.html">Sair</a></li>
			</ul>
		</div>
	</nav>

	<div class="card-body">
		<form class="needs-validation" novalidate method="post"
			action="../ClientSevlet">
			<div class="form-group">
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputName">Nome Completo</label> <input type="text"
						class="form-control" id="inputName"
						placeholder="Qual o nome do dono do restaurante?"
						required="required" value="<%=request.getAttribute("name")%>" />
					<div class="invalid-feedback">Por favor, informe o nome do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputEmail">E-mail</label> <input type="email"
						class="form-control" id="inputEmail"
						placeholder="Qual o e-mail do dono do restaurante?"
						required="required" value="<%=request.getAttribute("email")%>" />
					<div class="invalid-feedback">Por favor, informe o e-mail do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputCpf">CPF</label> <input type="text"
						class="form-control" id="inputCpf"
						placeholder="Qual o CPF do dono do restaurante?"
						required="required" value="<%=request.getAttribute("cpf")%>" />
					<div class="invalid-feedback">Por favor, informe o cpf do
						dono do restaurante.</div>
				</div>
				<div class="form-group col-md-15 font-weight-bold">
					<label for="inputPassword">Senha</label> <input type="password"
						class="form-control" id="inputPassword"
						placeholder="Digite uma senha" required="required"
						value="<%=request.getAttribute("password")%>" />
					<div class="invalid-feedback">Por favor, informe a senha do
						dono do restaurante.</div>
				</div>
				<!-- <div class="form-group col-md-15 font-weight-bold">
					<label for="inputPasswordConfirm">Confirmar Senha</label> <input
						type="password" class="form-control" id="inputPasswordConfirm"
						placeholder="Confirme sua senha" />
				</div>  -->
			</div>

			<button type="submit"
				class="btn btn-danger btn-lg btn-block font-weight-bold">Salvar
				Mudan�as</button>
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
		// Exemplo de JavaScript inicial para desativar envios de formul�rio, se houver campos inv�lidos.
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Pega todos os formul�rios que n�s queremos aplicar estilos de valida��o Bootstrap personalizados.
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