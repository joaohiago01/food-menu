<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<title>Food Menu - Faça Parte</title>

<link rel="sortcut icon" href="../assets/favicon.ico" type="image/x-icon" />

</head>

<body>

	<div class="card card bg-danger">
		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="../RestaurantServlet?pageURL=index.jsp">Início</a></li>
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="login.jsp">Entrar</a></li>
			</ul>
		</div>

		<div class="card card-group bg-danger">

			<div class="card">
				<img class="card-img" src="../assets/restaurant_image.jpg" />
			</div>

			<div class="card">
				<div class="card-body">
					<h2 class="card-title font-weight-bold">Cadastre seu
						restaurante</h2>
					<h5 class="card-subtitle mb-2 text-muted">Faça parte do Food
						Menu!</h5>
					<br />
					<form class="needs-validation" novalidate method="post" action="../ClientServlet">
						<div class="form-group">
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputName">Nome Completo</label> <input type="text"
									class="form-control" id="inputName" name="name"
									placeholder="Qual o nome do dono do restaurante?"
									required="required" min="5" max="60"/>
								<div class="invalid-feedback">Por favor, informe o nome do
									dono do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputEmail">E-mail</label> <input type="email"
									class="form-control" id="inputEmail" name="email"
									placeholder="Qual o e-mail do dono do restaurante?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o e-mail
									do dono do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputCpf">CPF</label> <input type="text"
									class="form-control" id="inputCpf" name="cpf"
									placeholder="Qual o CPF do dono do restaurante?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o cpf do
									dono do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputPassword">Senha</label> <input type="password"
									class="form-control" id="inputPassword" name="password"
									placeholder="Digite uma senha" required="required" min="5" max="20"/>
								<div class="invalid-feedback">Por favor, informe a senha
									do dono do restaurante.</div>
							</div>
						</div> 

							<button type="submit" id="buttonSubmit"
								class="btn btn-danger btn-lg btn-block font-weight-bold">Começar
								Cadastro</button>
					</form>
				</div>
			</div>
		</div>

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