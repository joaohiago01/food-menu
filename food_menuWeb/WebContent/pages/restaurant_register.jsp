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

<title>Food Menu - Restaurantes</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>

	<div class="card card bg-danger">

		<div class="card-header card bg-danger mb-3">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="user_register.jsp">Voltar</a></li>
			</ul>
		</div>

		<div class="card card-group bg-danger">
			<div class="card">
				<div class="card-body">
					<h2 class="card-title font-weight-bold">Sobre o restaurante:</h2>
					<br />
					<form class="needs-validation" novalidate method="post"
						action="../RestaurantServlet">
						<div class="form-group">
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputCnpj">CNPJ</label> <input type="text"
									class="form-control" id="inputCnpj" name="cnpj"
									placeholder="Qual o CPNJ do restaurante?" required="required" />
								<div class="invalid-feedback">Por favor, informe o cnpj do
									restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNameRestaurant">Nome do Restaurante</label> <input
									type="text" class="form-control" id="inputNameRestaurant"
									name="name" placeholder="Qual o nome do restaurante?"
									required="required" min="3" max="60" />
								<div class="invalid-feedback">Por favor, informe o nome do
									restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDescription">Descri��o (Opcional)</label> <input
									type="text" class="form-control" id="inputDescription"
									name="description"
									placeholder="Fa�a uma descri��o do seu restaurante" />
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputPhone">Telefone</label> <input type="text"
									class="form-control" id="inputPhone" name="phone"
									placeholder="Qual � o telefone do restaurante?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o
									telefone do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputCep">CEP</label> <input type="text"
									class="form-control" id="inputCep" name="cep"
									placeholder="CEP do restaurante" required="required" />
								<div class="invalid-feedback">Por favor, informe o CEP do
									restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputCity">Cidade</label> <input type="text"
									class="form-control" id="inputCity" name="city"
									placeholder="Cidade do restaurante" required="required" />
								<div class="invalid-feedback">Por favor, informe a cidade
									do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputState">Estado</label> <input type="text"
									class="form-control" id="inputState" name="state"
									placeholder="UF do restaurante" required="required" />
								<div class="invalid-feedback">Por favor, informe o estado
									do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDistrict">Bairro</label> <input type="text"
									class="form-control" id="inputDistrict" name="district"
									placeholder="Bairro do restaurante" required="required" />
								<div class="invalid-feedback">Por favor, informe o bairro
									do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputAddress">Endere�o</label> <input type="text"
									class="form-control" id="inputAdress" name="address"
									placeholder="Qual o endere�o do restaurante?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o
									endere�o do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNumber">N�mero</label> <input type="number"
									class="form-control" id="inputNumber" name="number"
									placeholder="N�mero do endere�o" required="required" />
								<div class="invalid-feedback">Por favor, informe o n�mero
									do endere�o do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputAddtion">Complemento (Opcional)</label> <input
									type="text" class="form-control" id="inputAddtion"
									name="addition" placeholder="Complemento do endere�o" />
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputTimeBegin">Hor�rio de Abertura</label> <input
									type="text" class="form-control" id="inputTimeBegin"
									name="time_open"
									placeholder="Qual hor�rio seu estabelecimento abre?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o hor�rio
									de abertura do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputTimeEnd">Hor�rio de Encerramento</label> <input
									type="text" class="form-control" id="inputTimeEnd"
									name="time_close"
									placeholder="Qual hor�rio seu estabelecimento fecha?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o hor�rio
									de encerramento do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDays">Quais dias o restaurante
									funciona?</label>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck1" name="monday"> <label
										class="custom-control-label" for="customCheck1">Segunda-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck2" name="tuesday"> <label
										class="custom-control-label" for="customCheck2">Ter�a-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck3" name="wednesday"> <label
										class="custom-control-label" for="customCheck3">Quarta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck4" name="thursday"> <label
										class="custom-control-label" for="customCheck4">Quinta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck5" name="friday"> <label
										class="custom-control-label" for="customCheck5">Sexta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck6" name="saturday"> <label
										class="custom-control-label" for="customCheck6">Sab�do</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										id="customCheck7" name="sunday"> <label
										class="custom-control-label" for="customCheck7">Domingo</label>
								</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDelivery">O restaurante possui servi�o
									de entrega?</label>
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" id="customRadioDeliveryYes" name="delivery"
										class="custom-control-input" /><label
										class="custom-control-label" for="customRadioDeliveryYes">Sim</label>
								</div>
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" id="customRadioDeliveryNo" name="delivery"
										class="custom-control-input" checked="checked" /><label
										class="custom-control-label" for="customRadioDeliveryNo">N�o</label>
								</div>
							</div>
						</div>

						<button type="submit"
							class="btn btn-danger btn-lg btn-block font-weight-bold">
							Confirmar</button>
					</form>
				</div>
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