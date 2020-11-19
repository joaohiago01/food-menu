<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<title>Food Menu - Cadastro Restaurante</title>

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
								<label for="inputDescription">Descrição (Opcional)</label> <input
									type="text" class="form-control" id="inputDescription"
									name="description"
									placeholder="Faça uma descrição do seu restaurante" />
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputPhone">Telefone</label> <input type="text"
									class="form-control" id="inputPhone" name="phone"
									placeholder="Qual é o telefone do restaurante?"
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
								<label for="inputAddress">Endereço</label> <input type="text"
									class="form-control" id="inputAdress" name="address"
									placeholder="Qual o endereço do restaurante?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o
									endereço do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputNumber">Número</label> <input type="number"
									class="form-control" id="inputNumber" name="number"
									placeholder="Número do endereço" required="required" />
								<div class="invalid-feedback">Por favor, informe o número
									do endereço do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputAddtion">Complemento (Opcional)</label> <input
									type="text" class="form-control" id="inputAddtion"
									name="addition" placeholder="Complemento do endereço" />
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputTimeBegin">Horário de Abertura</label> <input
									type="text" class="form-control" id="inputTimeBegin"
									name="time_open"
									placeholder="Qual horário seu estabelecimento abre?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o horário
									de abertura do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputTimeEnd">Horário de Encerramento</label> <input
									type="text" class="form-control" id="inputTimeEnd"
									name="time_close"
									placeholder="Qual horário seu estabelecimento fecha?"
									required="required" />
								<div class="invalid-feedback">Por favor, informe o horário
									de encerramento do restaurante.</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDays">Quais dias o restaurante
									funciona?</label>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('monday')" id="monday" value="off"
										name="monday"> <label class="custom-control-label"
										for="monday">Segunda-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										name="tuesday" onclick="check('tuesday')" value="off"
										id="tuesday"> <label class="custom-control-label"
										for="tuesday">Terça-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('wednesday')" id="wednesday" value="off"
										name="wednesday"> <label class="custom-control-label"
										for="wednesday">Quarta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('thursday')" id="thursday" value="off"
										name="thursday"> <label class="custom-control-label"
										for="thursday">Quinta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('friday')" id="friday" value="off"
										name="friday"> <label class="custom-control-label"
										for="friday">Sexta-Feira</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('saturday')" id="saturday" value="off"
										name="saturday"> <label class="custom-control-label"
										for="saturday">Sabádo</label>
								</div>
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input type="checkbox" class="custom-control-input"
										onclick="check('sunday')" id="sunday" value="off"
										name="sunday"> <label class="custom-control-label"
										for="sunday">Domingo</label>
								</div>
							</div>
							<div class="form-group col-md-15 font-weight-bold">
								<label for="inputDelivery">O restaurante possui serviço
									de entrega?</label>
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" id="customRadioDeliveryYes"
										onclick="radio('customRadioDeliveryYes', 'customRadioDeliveryNo')"
										name="delivery" class="custom-control-input" /><label
										class="custom-control-label" for="customRadioDeliveryYes">Sim</label>
								</div>
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" id="customRadioDeliveryNo"
										onclick="radio('customRadioDeliveryYes', 'customRadioDeliveryNo')"
										name="delivery" class="custom-control-input" checked="checked" value="offYes"/><label
										class="custom-control-label" for="customRadioDeliveryNo">Não</label>
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

		function check(checkID) {
			var checkBox = document.getElementById(checkID);
			if (checkBox.checked == true) {
				document.getElementById(checkID).value = "on";
			} else {
				document.getElementById(checkID).value = "off";
			}
		}

		function radio(radioIDY, radioIDN) {
			var radioY = document.getElementById(radioIDY);
			var radioN = document.getElementById(radioIDN);
			if (radioY.checked == true) {
				document.getElementById(radioIDY).value = "onYes";
				document.getElementById(radioIDN).value = "offNo";
			} else {
				document.getElementById(radioIDY).value = "offYes";
				document.getElementById(radioIDN).value = "onNo";
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