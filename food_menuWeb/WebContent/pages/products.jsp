<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<script src="https://unpkg.com/feather-icons"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Food Menu - Produtos</title>

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
					class="nav-link text-light font-weight-bold" href="restaurant.jsp">Restaurante</a></li>
				<li class="nav-item dropdown text-light"><a
					class="nav-link dropdown-toggle text-light font-weight-bold"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Card�pio </a>
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
		<div class="form-row col-sm-6 font-weight-bold">
			<a href="product_register.jsp?newProduct=newProduct">
				<button type="button" data-toggle="tooltip" data-placement="bottom"
					title="Cadastrar novo produto">
					<i data-feather="plus"></i>
				</button>
			</a>
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

			<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog"
				aria-labelledby="ModalExcluir" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<form action="../ProductSevlet?id=${product.getId()}" method="post">
						<input type="hidden" name="_method" value="DELETE" />
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="ModalExcluir">Deseja realmente
									excluir o produto?</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Fechar">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Fechar</button>
								<button type="submit" class="btn btn-danger">Excluir</button>

							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

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
</body>
</html>