<%@page import="entity.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Food Menu - Categoria</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>
	<%@page import="java.util.List, entity.Client"%>
	<%
		Client clientLogged = (Client) session.getAttribute("clientLogged");
	if (clientLogged == null) {
		response.sendRedirect("./login.jsp");
	}
	%>
	<div class="card card bg-danger">
		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="../ClientServlet?pageURL=categories.jsp?&clientID=${clientLogged.getId()}">Voltar</a>
				</li>
			</ul>
		</div>

		<div class="card card-group bg-danger">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title font-weight-bold">Sobre a categoria:</h2>
					<br />
					<form class="needs-validation" novalidate
						action="../CategoryProductServlet" method="post">
						<input type="hidden" name="clientID"
							value="${clientLogged.getId()}" />
						<div class="form-group">
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNameProduct">Nome</label> <input type="text"
									class="form-control" id="inputNameProduct" name="name"
									placeholder="Qual o nome desta categoria?" required="required" />
								<div class="invalid-feedback">Por favor, informe o nome da
									categoria.</div>
							</div>
						</div>

						<button type="submit"
							class="btn btn-danger btn-lg btn-block font-weight-bold">Cadastrar</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		
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