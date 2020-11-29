<%@ page language="java" contentType="text/html; charset=utf-8"%>
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://unpkg.com/feather-icons"></script>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Food Menu - Editar Produto</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>
	<%@page
		import="entity.Product, entity.Category, entity.Client, entity.Category, java.util.List"
		language="java"%>

	<%
		Product product = (Product) session.getAttribute("product");
	if (product == null) {
		response.sendRedirect("./products.jsp");
	} else {
		Client clientLogged = (Client) session.getAttribute("clientLogged");
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) session.getAttribute("categories");
		if (clientLogged == null) {
			response.sendRedirect("./login.jsp");
		} else {
	%>
	<div class="card card bg-danger">
		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="products.jsp">Voltar</a></li>
			</ul>
		</div>

		<div class="card card-group bg-danger">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title font-weight-bold">Sobre o produto:</h2>
					<br />
					<div class="form-group col-md-15 font-weight-bold">
						<button type="button" data-toggle="tooltip"
							onclick="popup();return false;" data-placement="bottom" id="buttonDelete"
							title="Remova este produto" data-target="#modalExcluir">
							<i data-feather="trash-2"></i>
						</button>
					</div>

					<div class="modal fade" id="modalExcluir" tabindex="-1"
						role="dialog" aria-labelledby="ModalExcluir" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<form action="../ProductServlet" method="get">
								<input type="hidden" name="pageURL" value="products.jsp" /> <input
									type="hidden" name="_method" value="delete" /> <input
									type="hidden" name="clientID" value="${clientLogged.getId()}" />
								<input type="hidden" name="menuID" value="${menu.getId()}" /> <input
									type="hidden" name="productID" value="${product.getId()}" /> <input
									type="hidden" name="categoryID"
									value="${product.getCategory().getId()}" />
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="ModalExcluir">Deseja
											realmente excluir o produto?</h5>
										<button type="button" class="close" data-dismiss="modal" id="buttonCloseDelete"
											aria-label="Fechar">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" id="buttonCancelDelete"
											data-dismiss="modal">Fechar</button>
										<button type="submit" id="buttonConfirmDelete" class="btn btn-danger">Excluir</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<form class="needs-validation" novalidate
						action="../ProductServlet" method="get">
						<input type="hidden" name="pageURL" value="products.jsp" /> <input
							type="hidden" name="clientID" value="${clientLogged.getId()}" />
						<input type="hidden" name="menuID" value="${menu.getId()}" /> <input
							type="hidden" name="categoryID"
							value="${product.getCategory().getId()}" /> <input type="hidden"
							name="productID" value="${product.getId()}" /> <input
							type=hidden name=_method value=PUT />
						<div class="form-group">
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNameProduct">Nome</label> <input type="text"
									class="form-control" id="inputNameProduct" name="name"
									placeholder="Qual o nome deste produto?" required="required"
									value="<%=product.getName()%>" />
								<div class="invalid-feedback">Por favor, informe o nome do
									produto.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputPriceProduct">Preço</label> <input type="text"
									class="form-control" id="inputPriceProduct" name="price"
									placeholder="Qual o preço deste produto?" required="required"
									value="<%=product.getPrice()%>" />
								<div class="invalid-feedback">Por favor, informe o preço
									do produto.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDescription">Descrição (Opcional)</label> <input
									type="text" class="form-control" id="inputDescription"
									name="description"
									placeholder="Faça uma descrição deste produto"
									value="<%=product.getDescription()%>" />
							</div>

							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputEspeciality">Qual a categoria deste
									produto?</label> <select class="custom-select" required="required"
									id="inputCategory" name="category">
									<%
										if (product.getCategory() != null) {
									%>
									<option selected="selected"
										value="<%=product.getCategory().getId()%>"><%=product.getCategory().getName()%></option>
									<%
										} else {
									%>
									<option selected="selected"></option>
									<%
										}
									if (categories != null) {
										for (Category category : categories) {
									%>
									<option value="<%=category.getId()%>"><%=category.getName()%></option>
									<%
										}
									}
									%>
								</select>
								<div class="invalid-feedback">Por favor, informe a
									categoria deste produto.</div>
							</div>
						</div>

						<button type="submit" id="buttonSubmit"
							class="btn btn-danger btn-lg btn-block font-weight-bold">Salvar
							Mudanças</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	}
	%>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputPriceProduct").mask("99.99");
		});
	</script>
	<script>
		feather.replace()
	</script>
	<script type="text/javascript">
		$(function() {
			$("[rel='tooltip']").tooltip('show');
		});
		function popup() {
			$('[id*="modalExcluir"]').modal('show');
		}
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