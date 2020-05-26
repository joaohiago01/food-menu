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
import bean.RestaurantBean;
import entity.Category;
import entity.Client;
import entity.Menu;
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
			if (email == null && request.getAttribute("email") != null) {
				email = request.getAttribute("email").toString();
				password = request.getAttribute("password").toString();
			}

			if (email != null && password != null) {//AUTHENTICATION
				
				Client client = clientEJB.signIn(email, password);
				if (client != null) {
					Restaurant restaurant = restaurantEJB.readByUser(client);
					Menu menu = menuEJB.findByRestaurant(restaurant.getId());
					List<Category> categoryProducts = categoryProductEJB.read();

					httpSession.setAttribute("clientLogged", client);
					httpSession.setAttribute("restaurant", restaurant);
					httpSession.setAttribute("menu", menu);
					httpSession.setAttribute("categories", categoryProducts);
					
					response.sendRedirect("./pages/main.jsp");
				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			} else {//AUTHORIZATION
				
				int clientID = Integer.parseInt(request.getParameter("clientID"));
				String pageURL = request.getParameter("pageURL");
				if (pageURL == null && httpSession.getAttribute("pageURL") != null) {
					clientID = Integer.parseInt(httpSession.getAttribute("clientID").toString());
					pageURL = httpSession.getAttribute("pageURL").toString();
				}
				Client clientLogged = clientEJB.readById(clientID);
				if(clientLogged != null) {

					Restaurant restaurant = (Restaurant) httpSession.getAttribute("restaurant");
					Menu menu = (Menu) httpSession.getAttribute("menu");
					@SuppressWarnings("unchecked")
					List<Category> categoryProducts = (List<Category>) httpSession.getAttribute("categories");

					httpSession.setAttribute("clientLogged", clientLogged);
					httpSession.setAttribute("restaurant", restaurant);
					httpSession.setAttribute("menu", menu);
					httpSession.setAttribute("categories", categoryProducts);
					
					response.sendRedirect("./pages/" + pageURL);
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
			HttpSession httpSession = request.getSession();
			Client client = clientEJB.readById(Integer.parseInt(request.getParameter("clientID")));
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));
			client = clientEJB.update(client);
			
			httpSession.setAttribute("clientID", client.getId());
			httpSession.setAttribute("pageURL", "main.jsp");
			response.sendRedirect("./ClientServlet");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
