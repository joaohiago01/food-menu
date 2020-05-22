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

<title>Food Menu</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-danger bg-danger">
		<a class="navbar-brand text-light font-weight-bold" href="main.jsp">Food
			Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="profile.jsp">Perfil</a></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold"
					href="restaurant_edit.jsp">Restaurante</a></li>
				<li class="nav-item dropdown text-light"><a
					class="nav-link dropdown-toggle text-light font-weight-bold"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Cardápio </a>
					<div class="dropdown-menu bg-danger"
						aria-labelledby="navbarDropdownMenuLink">
						<form action="../CategoryProductServlet" method="get">
							<input class="dropdown-item text-light font-weight-bold"
								type="submit" value="Categorias" />
						</form>
						<form action="../ProductServlet" method="get">
							<input class="dropdown-item text-light font-weight-bold"
								type="submit" value="Produtos" />
						</form>
					</div></li>
				<li class="nav-item"><a
					class="nav-link text-light font-weight-bold" href="login.jsp">Sair</a></li>
			</ul>
		</div>
	</nav>

	<div class="card-body">
		<%@page import="entity.Restaurant, java.util.List"%>
		<%
			Restaurant restaurant = (Restaurant) request.getSession().getAttribute("food_menu");
		%>
		<br />
		<div class="card-body">
			<h1 class="card-title" id="restaurant">
				<%
					restaurant.getName();
				%>
			</h1>

			<label class="card-text" id="description"> <%
 	restaurant.getDescription();
 %>
			</label> <br />
		</div>

		<div class="card-body">
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Horário de
					Funcionamento:</label> <label id="time_open" class="form-col-1"> <%
 	restaurant.getTime_open();
 %>
				</label> <label class="form-col-1">às</label> <label id="time_close"
					class="form-col-1"> <%
 	restaurant.getTime_close();
 %>
				</label>
			</div>

			<div class="form-group col-md-15 font-weight-bold">
				<label for="inputDays">Quais dias o restaurante funciona?</label>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck1" name="monday"
						<%if (restaurant.isMonday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck1">Segunda-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck2" name="tuesday"
						<%if (restaurant.isTuesday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck2">Terça-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck3" name="wednesday"
						<%if (restaurant.isWednesday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck3">Quarta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck4" name="thursday"
						<%if (restaurant.isThursday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck4">Quinta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck5" name="friday"
						<%if (restaurant.isFriday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck5">Sexta-Feira</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck6" name="saturday"
						<%if (restaurant.isSaturday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck6">Sabádo</label>
				</div>
				<div class="custom-control custom-checkbox custom-control-inline">
					<input type="checkbox" class="custom-control-input"
						id="customCheck7" name="sunday"
						<%if (restaurant.isSunday_open())%> checked="checked" /> <label
						class="custom-control-label" for="customCheck7">Domingo</label>
				</div>
			</div>

			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Contato: </label> <label
					class="form-col-1" id="phone"> <%
 	restaurant.getPhone();
 %>
				</label>
			</div>
		</div>

		<div class="card-body">
			<h4 class="card-title font-weight-bold">Localização</h4>

			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Cidade:</label> <label
					class="form-col-1" id="city"> <%
 	restaurant.getCity();
 %>
				</label> <label class="form-col-1 font-weight-bold">Estado:</label> <label
					class="form-col-1" id="state"> <%
 	restaurant.getState();
 %>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Endereço: </label> <label
					class="form-col-1" id="address"> <%
 	restaurant.getAddress();
 %>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Bairro: </label> <label
					class="form-col-1" id="disctrict"> <%
 	restaurant.getDistrict();
 %>
				</label>
			</div>
			<div class="form-row">
				<label class="form-col-1 font-weight-bold">Complemento: </label> <label
					class="form-col-1" id="addition"> <%
 	restaurant.getAddition();
 %>
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
			<div class="form-group col-md-15 font-weight-bold">
				<select class="custom-select">
					<option selected="selected">Categoria 1</option>
					<option value="0">Categoria 2</option>
				</select>
			</div>
			<br />

			<div class="row">
				<%@page import="entity.Product, java.util.List" language="java"%>
				<%
					@SuppressWarnings("unchecked")
				List<Product> listProducts = (List<Product>) request.getSession().getAttribute("listProducts");
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
								<%
									product.getName();
								%>
							</h5>
							<p class="card-text">
								<%
									product.getDescription();
								%>
							</p>
							<p class="card-text">
								<%
									product.getPrice();
								%>
							</p>
							<form method="get"
								action="../ProductServlet?id=${product.getId()}">
								<button type="button" data-toggle="tooltip"
									data-placement="bottom" title="Edite este produto">
									<i data-feather="edit"></i>
								</button>
								<input type="submit" />
							</form>
							<button type="button" data-toggle="tooltip"
								onclick="popup();return false;" data-placement="bottom"
								title="Remova este produto" data-target="#modalExcluir">
								<i data-feather="delete"></i>
							</button>
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