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
			HttpSession httpSession = request.getSession();
			String email = (String) request.getParameter("email");
			String password = (String) request.getParameter("password");
			
			if (email != null && password != null) {//AUTHENTICATION
				System.out.println(email);
				Client client = clientEJB.signIn(email, password);
				if (client != null) {
					httpSession.setAttribute("clientLogged", client);
					Restaurant restaurant = restaurantEJB.readByUser(client);
					Menu menu = menuEJB.findByRestaurant(restaurant.getId());
					List<Product> products = productEJB.readAllProducts(menu);
					menu.setProducts(products);
					List<Category> categoryProducts = categoryProductEJB.readByMenu(menu);
					
					String logged = "logged";

					httpSession.setAttribute("restaurant", restaurant);
					httpSession.setAttribute("menu", menu);
					httpSession.setAttribute("categories", categoryProducts);
					httpSession.setAttribute("logged", logged);
					response.sendRedirect("./pages/main.jsp");
				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			} else {//AUTHORIZATION
				if(httpSession.getAttribute("clientLogged") != null) {
					Client clientLogged = (Client) request.getAttribute("clientLogged");
					String pageURL = (String) request.getSession().getAttribute("page");

					Restaurant restaurant = restaurantEJB.readByUser(clientLogged);
					Menu menu = menuEJB.findByRestaurant(restaurant.getId());
					List<Product> products = productEJB.readAllProducts(menu);
					menu.setProducts(products);
					List<Category> categoryProducts = categoryProductEJB.readByMenu(menu);

					httpSession.setAttribute("clientLogged", clientLogged);
					httpSession.setAttribute("restaurant", restaurant);
					httpSession.setAttribute("menu", menu);
					httpSession.setAttribute("categories", categoryProducts);
					response.sendRedirect(pageURL);
				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			}
			/*else if (!request.getParameter("id").isEmpty()) {
				Client client = clientEJB.readById(Integer.parseInt(request.getParameter("id")));
				httpSession.setAttribute("client", client);
				response.sendRedirect("./pages/profile.jsp");
			}*/ 
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Client client = new Client();
		client.setCpf(request.getParameter("cpf"));
		client.setName(request.getParameter("name"));
		client.setEmail(request.getParameter("email"));
		client.setPassword(request.getParameter("password"));

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("client", client);
		response.sendRedirect("./pages/restaurant_register.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Client client;
			client = (Client) request.getSession().getAttribute("client");
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));
			clientEJB.update(client);

			/*HttpSession httpSession = request.getSession();
			client = clientEJB.signIn(client.getEmail(), client.getPassword());
			Restaurant restaurant = restaurantEJB.readByUser(client);
			Menu menu = menuEJB.findByRestaurant(restaurant.getId());
			List<Product> products = menuEJB.readAllProducts(menu);
			menu.setProducts(products);
			List<CategoryProduct> categoryProducts = categoryProductEJB.readByMenu(menu);

			httpSession.setAttribute("clientLogged", client);
			httpSession.setAttribute("restaurant", restaurant);
			httpSession.setAttribute("menu", menu);
			httpSession.setAttribute("categories", categoryProducts);*/
			response.sendRedirect("./pages/main.jsp");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
