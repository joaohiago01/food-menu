<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="overflow: hidden;">
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<title>Food Menu</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>	
	<img class="card-img" src="../assets/restaurant_login.jpg" />
	<div class="card-img-overlay">
		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="../RestaurantServlet?pageURL=index.jsp">Voltar</a></li>
			</ul>
			<br />
			<div class="card col-sm-12 form-group-lg">
				<br />
				<form class="needs-validation" novalidate method="get"
					action="../ClientServlet">
					<div class="form-group row">
						<label for="inputEmail"
							class="col-sm-2 col-form-label font-weight-bold"> E-mail:</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail"
								name="email" placeholder="Seu E-mail" required="required" />
							<div class="invalid-feedback">Por favor, informe seu
								e-mail.</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword"
							class="col-sm-2 col-form-label font-weight-bold"> Senha:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword"
								name="password" placeholder="Sua Senha" required="required" />
							<div class="invalid-feedback">Por favor, informe sua senha.</div>
						</div>
					</div>

					<button type="submit"
						class="btn btn-danger btn-lg btn-block font-weight-bold">
						Entrar</button>
				</form>
				<br />
			</div>
		</div>
	</div>

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