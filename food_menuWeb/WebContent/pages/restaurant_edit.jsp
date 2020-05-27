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

<title>Food Menu - Restaurante</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>
	<%@page
		import="entity.Client, entity.Restaurant, entity.Category, java.util.List"%>
	<%
		Client clientLogged = (Client) session.getAttribute("clientLogged");
	Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
	@SuppressWarnings("unchecked")
	List<Category> categories = (List<Category>) session.getAttribute("categories");
	if (clientLogged == null) {
		response.sendRedirect("./login.jsp");
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-danger bg-danger">
		<a class="navbar-brand text-light font-weight-bold"
			href="../ClientServlet?pageURL=main.jsp?&clientID=${clientLogged.getId()}">Food
			Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="../ClientServlet?pageURL=profile.jsp?&clientID=${clientLogged.getId()}">Perfil
				</a></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="../ClientServlet?pageURL=restaurant_edit.jsp?&clientID=${clientLogged.getId()}">Restaurante</a></li>
				<li class="nav-item dropdown text-light"><a
					class="nav-link dropdown-toggle text-light font-weight-bold"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Cardápio </a>
					<div class="dropdown-menu bg-danger"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item text-light font-weight-bold"
							href="../ClientServlet?pageURL=categories.jsp?&clientID=${clientLogged.getId()}">Categorias</a>
						<a class="dropdown-item text-light font-weight-bold"
							href="../ClientServlet?pageURL=products.jsp?&clientID=${clientLogged.getId()}">Produtos</a>
					</div></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="../ClientServlet?pageURL=login.jsp">Sair</a></li>
			</ul>
		</div>
	</nav>

	<div class="card card-group bg-danger">
		<div class="card">
			<div class="card-body">
				<h2 class="card-title font-weight-bold">Sobre o restaurante:</h2>
				<br />
				<form class="needs-validation" novalidate method="get"
					action="../RestaurantServlet">
					<input type="hidden" name="_method" value="PUT" /> <input
						type="hidden" name="clientID" value="${clientLogged.getId()}" />
					<div class="form-group">
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputCnpj">CNPJ</label> <input type="text"
								class="form-control" id="inputCnpj"
								placeholder="Qual o CPNJ do restaurante?" required="required"
								value="<%=restaurant.getCnpj()%>" />
							<div class="invalid-feedback">Por favor, informe o cnpj do
								restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputNameRestaurant">Nome do Restaurante</label> <input
								type="text" class="form-control" id="inputNameRestaurant"
								placeholder="Qual o nome do restaurante?" required="required"
								value="<%=restaurant.getName()%>" min="3" max="60" />
							<div class="invalid-feedback">Por favor, informe o nome do
								restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputDescription">Descrição (Opcional)</label> <input
								type="text" class="form-control" id="inputDescription"
								value="<%=restaurant.getDescription()%>"
								placeholder="Faça uma descrição do seu restaurante" />
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputPhone">Telefone</label> <input type="text"
								class="form-control" id="inputPhone"
								placeholder="Qual é o telefone do restaurante?"
								required="required" value="<%=restaurant.getPhone()%>" />
							<div class="invalid-feedback">Por favor, informe o telefone
								do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputCep">CEP</label> <input type="text"
								class="form-control" id="inputCep"
								placeholder="CEP do restaurante" required="required"
								value="<%=restaurant.getCep()%>" />
							<div class="invalid-feedback">Por favor, informe o CEP do
								restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputCity">Cidade</label> <input type="text"
								class="form-control" id="inputCity"
								placeholder="Cidade do restaurante" required="required"
								value="<%=restaurant.getCity()%>" />
							<div class="invalid-feedback">Por favor, informe a cidade
								do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputState">Estado</label> <input type="text"
								class="form-control" id="inputState"
								placeholder="UF do restaurante" required="required"
								value="<%=restaurant.getState()%>" />
							<div class="invalid-feedback">Por favor, informe o estado
								do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputDistrict">Bairro</label> <input type="text"
								class="form-control" id="inputDistrict"
								placeholder="Bairro do restaurante" required="required"
								value="<%=restaurant.getDistrict()%>" />
							<div class="invalid-feedback">Por favor, informe o bairro
								do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputAddress">Endereço</label> <input type="text"
								class="form-control" id="inputAdress"
								placeholder="Qual o endereço do restaurante?"
								required="required" value="<%=restaurant.getAddress()%>" />
							<div class="invalid-feedback">Por favor, informe o endereço
								do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputNumber">Número</label> <input type="number"
								class="form-control" id="inputNumber"
								placeholder="Número do endereço" required="required"
								value="<%=restaurant.getNumber()%>" />
							<div class="invalid-feedback">Por favor, informe o número
								do endereço do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputAddtion">Complemento (Opcional)</label> <input
								type="text" class="form-control" id="inputAddtion"
								value="<%=restaurant.getAddition()%>"
								placeholder="Complemento do endereço" />
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputTimeBegin">Horário de Abertura</label> <input
								type="text" class="form-control" id="inputTimeBegin"
								placeholder="Qual horário seu estabelecimento abre?"
								required="required" value="<%=restaurant.getTime_open()%>" />
							<div class="invalid-feedback">Por favor, informe o horário
								de abertura do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputTimeEnd">Horário de Encerramento</label> <input
								type="text" class="form-control" id="inputTimeEnd"
								placeholder="Qual horário seu estabelecimento fecha?"
								required="required" value="<%=restaurant.getTime_close()%>" />
							<div class="invalid-feedback">Por favor, informe o horário
								de encerramento do restaurante.</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputDays">Quais dias o restaurante funciona?</label>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isMonday_open()) {
								%>
								<input type="checkbox" class="custom-control-input" id="monday"
									name="monday" checked="checked" onclick="check('monday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input" id="monday"
									name="monday" onclick="check('monday')" /> <label
									class="custom-control-label" for="monday">Segunda-Feira</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isTuesday_open()) {
								%>
								<input type="checkbox" class="custom-control-input" id="tuesday"
									name="tuesday" checked="checked" onclick="check('tuesday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input" id="tuesday"
									name="tuesday" onclick="check('tuesday')" /> <label
									class="custom-control-label" for="tuesday">Terça-Feira</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isWednesday_open()) {
								%>
								<input type="checkbox" class="custom-control-input"
									id="wednesday" name="wednesday" checked="checked"
									onclick="check('wednesday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input"
									id="wednesday" name="wednesday" onclick="check('wednesday')" />
								<label class="custom-control-label" for="wednesday">Quarta-Feira</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isThursday_open()) {
								%>
								<input type="checkbox" class="custom-control-input"
									id="thursday" name="thursday" checked="checked"
									onclick="check('thursday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input"
									id="thursday" name="thursday" onclick="check('thursday')" /> <label
									class="custom-control-label" for="thursday">Quinta-Feira</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isFriday_open()) {
								%>
								<input type="checkbox" class="custom-control-input" id="friday"
									name="friday" checked="checked" onclick="check('friday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input" id="friday"
									name="friday" onclick="check('friday')" /> <label
									class="custom-control-label" for="friday">Sexta-Feira</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isSaturday_open()) {
								%>
								<input type="checkbox" class="custom-control-input"
									id="saturday" name="saturday" checked="checked"
									onclick="check('saturday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input"
									id="saturday" name="saturday" onclick="check('saturday')" /> <label
									class="custom-control-label" for="saturday">Sabádo</label>
							</div>
							<div class="custom-control custom-checkbox custom-control-inline">
								<%
									if (restaurant.isSunday_open()) {
								%>
								<input type="checkbox" class="custom-control-input" id="sunday"
									name="sunday" checked="checked" onclick="check('sunday')" />
								<%
									}
								%>
								<input type="checkbox" class="custom-control-input" id="sunday"
									name="sunday" onclick="check('sunday')" /> <label
									class="custom-control-label" for="sunday">Domingo</label>
							</div>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputEspeciality">Qual a especialidade
								principal do restaurante?</label> <select class="custom-select">
								<option selected="selected"
									value="<%if (restaurant.getCategory() != null)
	restaurant.getCategory().getId();%>">
									<%
										if (restaurant.getCategory() != null)
										restaurant.getCategory().getName();
									%>
								</option>
								<%
									if (categories != null) {
									for (Category category : categories) {
								%>
								<option value="<%category.getId();%>"><%=category.getName()%></option>
								<%
									}
								}
								%>
							</select>
						</div>
						<div class="form-group col-md-15 font-weight-bold">
							<label for="inputDelivery">O restaurante possui serviço
								de entrega?</label>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" id="customRadioDeliveryYes"
									name="customRadioDelivery" class="custom-control-input"
									<%if (restaurant.isDelivery())%> checked="checked" /><label
									class="custom-control-label" for="customRadioDeliveryYes">Sim</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" id="customRadioDeliveryNo"
									name="customRadioDelivery" class="custom-control-input"
									<%if (!restaurant.isDelivery())%> checked="checked" /><label
									class="custom-control-label" for="customRadioDeliveryNo">Não</label>
							</div>
						</div>
					</div>

					<button type="submit"
						class="btn btn-danger btn-lg btn-block font-weight-bold">
						Salvar Mudanças</button>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script type="text/javascript"
		src="https://github.com/igorescobar/jQuery-Mask-Plugin/blob/master/dist/jquery.mask.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputCnpj").mask("99.999.999/9999-99");
		});
		$(document).ready(function() {
			$("#inputCep").mask("99.999-999");
		});
		$(document).ready(function() {
			$("#inputPhone").mask("(00) 0000-00009");
		});
		$("#inputTimeBegin").mask("00:00");
		$("#inputTimeEnd").mask("00:00");

		function check(checkID) {
			var checkBox = document.getElementById(checkID);
			if (checkBox.checked == true) {
				document.getElementById(checkID).value = "on";
			} else {
				document.getElementById(checkID).value = "off";
			}
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