package webModule.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CategoryProductBean;
import bean.ClientBean;
import bean.MenuBean;
import bean.ProductBean;
import bean.RestaurantBean;
import entity.Category;
import entity.Client;
import entity.Menu;
import entity.Product;
import entity.Restaurant;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(name = "ClientServlet", urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	ClientBean clientEJB;

	@EJB
	RestaurantBean restaurantEJB;

	@EJB
	MenuBean menuEJB;

	@EJB
	CategoryProductBean categoryProductEJB;

	@EJB
	ProductBean productEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");

			if (email != null && password != null) {//AUTHENTICATION
				System.out.println(email);
				Client client = clientEJB.signIn(email, password);
				if (client != null) {
					Restaurant restaurant = restaurantEJB.readByUser(client);
					Menu menu = menuEJB.findByRestaurant(restaurant.getId());
					List<Product> products = productEJB.readAllProducts(menu);
					menu.setProducts(products);
					List<Category> categoryProducts = categoryProductEJB.readByMenu(menu);

					request.setAttribute("clientLogged", client);
					request.setAttribute("restaurant", restaurant);
					request.setAttribute("menu", menu);
					request.setAttribute("categories", categoryProducts);
					request.getRequestDispatcher("./pages/main.jsp").forward(request, response);
				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			} else {//AUTHORIZATION
				Client clientLogged = clientEJB.readById(Integer.parseInt(request.getParameter("clientID")));
				if(clientLogged != null) {

					String pageURL = request.getParameter("pageURL");

					Restaurant restaurant = restaurantEJB.readByUser(clientLogged);
					Menu menu = menuEJB.findByRestaurant(restaurant.getId());
					List<Product> products = productEJB.readAllProducts(menu);
					menu.setProducts(products);
					List<Category> categoryProducts = categoryProductEJB.readByMenu(menu);

					request.setAttribute("clientLogged", clientLogged);
					request.setAttribute("restaurant", restaurant);
					request.setAttribute("menu", menu);
					request.setAttribute("categories", categoryProducts);
					request.getRequestDispatcher("./pages/" + pageURL).forward(request, response);

				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			}
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("_method") != null && request.getParameter("_method").equalsIgnoreCase("put")) {
			doPut(request, response);
		} else {

			Client client = new Client();
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("client", client);
			response.sendRedirect("./pages/restaurant_register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Client client = clientEJB.readById(Integer.parseInt(request.getParameter("clientID")));
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));
			client = clientEJB.update(client);

			request.getRequestDispatcher("./ClientServlet?pageURL=main.jsp&clientID=${client.getId()}").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
