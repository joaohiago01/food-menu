<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Language" content="pt-br">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Food Menu</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>
	<%@page import="entity.Restaurant, entity.Menu, entity.Category"%>
	<%
		Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
	Menu menu = (Menu) session.getAttribute("menu");
	Category category = (Category) session.getAttribute("category");
	%>
	<div class="card bg-danger mb-3">
		<div class="card-header">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="user_register.jsp">Cadastrar Restaurante</a></li>
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="login.jsp">Entrar</a></li>
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="../RestaurantServlet?pageURL=index.jsp">Voltar</a></li>
			</ul>
		</div>
	</div>

	<div class="card-body">
		<br />
		<div class="card-body">
			<h1 class="card-title" id="restaurant">
				<%=restaurant.getName()%>
			</h1>
			<br />
			<%
				if (restaurant.getCategory() != null) {
			%>
			<label class="form-col-1 font-weight-bold" id="category">Especialidade: <%=restaurant.getCategory().getName()%></label>
			<br />
			<%
				}
			%>
			<label class="card-text" id="description"> <%=restaurant.getDescription()%>
			</label> <br /> <label class="card-text" id="category"> <%
 	if (category != null)
 	category.getName();
 %>
			</label> <br />
		</div>

		<div class="card-body">
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Horário de
					Funcionamento:</label> <label id="time_open" class="form-col-1"> <%=restaurant.getTime_open()%>
				</label> <label class="form-col-1"></label> <label id="time_close"
					class="form-col-1"> <%=restaurant.getTime_close()%>
				</label>
			</div>

			<div class="form-group col-md-15 font-weight-bold">
				<label for="inputDays">Quais dias o restaurante funciona?</label>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isMonday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck1" name="monday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck1" name="monday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck1">Segunda-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isTuesday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck2" name="tuesday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck2" name="tuesday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck2">Terça-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isWednesday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck3" name="wednesday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck3" name="wednesday" disabled="disabled"> <label
						class="custom-control-label" for="customCheck3">Quarta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isThursday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck4" name="thursday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck4" name="thursday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck4">Quinta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isFriday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck5" name="friday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck5" name="friday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck5">Sexta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isSaturday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck6" name="saturday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck6" name="saturday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck6">Sabádo</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<%
						if (restaurant.isSunday_open()) {
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck7" name="sunday" checked="checked"
						disabled="disabled" />
					<%
						}
					%>
					<input type="checkbox" class="custom-control-input"
						id="customCheck7" name="sunday" disabled="disabled" /> <label
						class="custom-control-label" for="customCheck7">Domingo</label>
				</div>
			</div>

			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Contato: </label> <label
					class="form-col-1" id="phone"> <%=restaurant.getPhone()%>
				</label>
			</div>
		</div>

		<div class="card-body">
			<h4 class="card-title font-weight-bold">Localização</h4>

			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Cidade:</label> <label
					class="form-col-1" id="city"> <%=restaurant.getCity()%>
				</label> <label class="form-col-1 font-weight-bold">Estado:</label> <label
					class="form-col-1" id="state"> <%=restaurant.getState()%>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Endereço: </label> <label
					class="form-col-1" id="address"> <%=restaurant.getAddress()%>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Bairro: </label> <label
					class="form-col-1" id="disctrict"> <%=restaurant.getDistrict()%>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Complemento: </label> <label
					class="form-col-1" id="addition"> <%=restaurant.getAddition()%>
				</label>
			</div>

		</div>

		<div class="card-body form-group col-md-15 font-weight-bold">
			<label for="inputDelivery">O restaurante possui serviço de
				entrega?</label> <br />
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="customRadioDeliveryYes" disabled="disabled"
					name="customRadioDelivery" class="custom-control-input"
					<%if (restaurant.isDelivery())%> checked="checked" /><label
					class="custom-control-label" for="customRadioDeliveryYes">Sim</label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="customRadioDeliveryNo" disabled="disabled"
					name="customRadioDelivery" class="custom-control-input"
					<%if (!restaurant.isDelivery())%> checked="checked" /><label
					class="custom-control-label" for="customRadioDeliveryNo">Não</label>
			</div>
		</div>

		<div class="card-body">
			<h4 class="card-title font-weight-bold">Cardápio</h4>
			<br />

			<div class="row">
				<%@page import="entity.Product, java.util.List" language="java"%>
				<%
					List<Product> listProducts = menu.getProducts();
				if (listProducts == null || listProducts.isEmpty()) {
				%>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Nenhum produto encontrado</h5>
						</div>
					</div>
				</div>
				<%
					} else {
					for (Product product : listProducts) {
				%>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">
								<%=product.getName()%>
							</h5>
							<p class="card-text">
								<%=product.getDescription()%>
							</p>
							<p class="card-text">
								<%="R$ " + product.getPrice()%>
							</p>
						</div>
					</div>
				</div>
				<%
					}
				}
				%>
			</div>
		</div>
	</div>

</body>
</html>