<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<title>Food Menu</title>

<link rel="sortcut icon" href="../assets/favicon.ico"
	type="image/x-icon" />

</head>
<body>

	<%@page import="java.util.List, entity.Restaurant"%>
	<%
	if (session.getAttribute("flagStartWebSite") == null) {
		response.sendRedirect("../RestaurantServlet?pageURL=index.jsp");
	}
	@SuppressWarnings("unchecked")
	List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurants");
	%>
	<div class="card bg-danger mb-3">
		<div class="card-header">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="user_register.jsp">Food Menu</a></li>
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="../RestaurantServlet?pageURL=index.jsp">Restaurantes</a></li>
				<li class="nav-item"><a class="nav-link btn btn-danger btn-lg"
					href="login.jsp">Entrar</a></li>
			</ul>
		</div>
	</div>

	<div class="card-body">
		<h4 class="card-title font-weight-bold col-sm-2">Restaurantes</h4>
		<br />
		<nav class="navbar navbar-light bg-light">
			<form class="form-inline" method="get" action="../RestaurantServlet">
				<input class="form-control mr-sm-2" type="search" name="search"
					placeholder="Pesquisar restaurante" aria-label="Pesquisar" />
				<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Pesquisar</button>
			</form>
		</nav>
		<br />

		<div class="row">
			<%
				if (restaurants == null || restaurants.isEmpty()) {
			%>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Nenhum restaurante encontrado</h5>
					</div>
				</div>
			</div>
			<%
				} else {
				for (Restaurant restaurant : restaurants) {
			%>
			<div class="col-sm-6">
				<div class="card">
					<form class="card-body" method="get" action="../RestaurantServlet">
						<input type="hidden" name="restaurantID"
							value="<%=restaurant.getId()%>" />
						<h5 class="card-title">
							<%=restaurant.getName()%>
						</h5>
						<p>
							<%
								if (restaurant.getCategory() != null)
								restaurant.getCategory().getName();
							%>
						</p>
						<button type="submit"
							class="btn btn-danger btn-lg btn-block font-weight-bold">Acessar</button>
					</form>
				</div>
			</div>
			<%
				}
			}
			%>
		</div>
	</div>

</body>
</html>