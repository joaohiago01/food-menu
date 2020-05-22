<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Food Menu - Produtos</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>

	<div class="card card bg-danger">

		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item">
					<form action="../ProductServlet" method="get">
						<input class="nav-link btn btn-danger btn-lg" value="Voltar"
							type="submit" />
					</form>
				</li>
			</ul>
		</div>

		<div class="card card-group bg-danger">
			<%@page
				import="entity.Product, entity.CategoryProduct, java.util.List"
				language="java"%>

			<%
				Product product = (Product) request.getSession().getAttribute("product");
			CategoryProduct categoryProduct = (CategoryProduct) request.getSession().getAttribute("category");
			%>

			<div class="card">
				<div class="card-body">
					<h2 class="card-title font-weight-bold">Sobre o produto:</h2>
					<br />
					<form class="needs-validation" novalidate
						action="../ProductServlet" method="post">
						<input type="hidden" name="_method" value="PUT" />
						<div class="form-group">
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNameProduct">Nome</label> <input type="text"
									class="form-control" id="inputNameProduct" name="name"
									placeholder="Qual o nome deste produto?" required="required"
									value="<%product.getName();%>" />
								<div class="invalid-feedback">Por favor, informe o nome do
									produto.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputPriceProduct">Pre�o</label> <input type="text"
									class="form-control" id="inputPriceProduct" name="price"
									placeholder="Qual o pre�o deste produto?" required="required"
									value="<%product.getPrice();%>" />
								<div class="invalid-feedback">Por favor, informe o pre�o
									do produto.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDescription">Descri��o (Opcional)</label> <input
									type="text" class="form-control" id="inputDescription"
									name="description"
									placeholder="Fa�a uma descri��o deste produto"
									value="<%product.getDescription();%>" />
							</div>

							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputEspeciality">Qual a categoria deste
									produto?</label> <select class="custom-select" required="required"
									name="category">
									<option selected="selected"><%=categoryProduct.getName()%></option>
									<%
										@SuppressWarnings("unchecked")
									List<CategoryProduct> listCategoryProducts = (List<CategoryProduct>) request.getSession().getAttribute("categories");
									if (listCategoryProducts != null) {
										for (CategoryProduct category : listCategoryProducts) {
									%>
									<option value="<%category.getName();%>"></option>
									<%
										}
									}
									%>
								</select>
								<div class="invalid-feedback">Por favor, informe a
									categoria deste produto.</div>
							</div>
						</div>

						<button type="submit"
							class="btn btn-danger btn-lg btn-block font-weight-bold">Salvar
							Mudan�as</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputPriceProduct").mask("99.99");
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