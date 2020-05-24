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

import bean.ClientBean;
import bean.MenuBean;
import bean.ProductBean;
import bean.RestaurantBean;
import entity.Client;
import entity.Menu;
import entity.Product;
import entity.Restaurant;

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet(name = "RestaurantServlet", urlPatterns = "/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	RestaurantBean restaurantEJB;

	@EJB
	ClientBean clientEJB;
	
	@EJB
	MenuBean menuEJB;
	
	@EJB
	ProductBean productEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestaurantServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession httpSession = request.getSession();
			if (!request.getParameter("id").isEmpty()) {
				Restaurant restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("id")));
				Menu menu = menuEJB.findByRestaurant(restaurant.getId());
				httpSession.setAttribute("food_menu", restaurant);
				httpSession.setAttribute("listProducts", menu.getProducts());
				response.sendRedirect("./pages/food_menu.jsp");
			} /*else if (!request.getParameter("client_id").isEmpty()) {
				Client client = clientEJB.readById(Integer.parseInt(request.getParameter("client_id")));
				Restaurant restaurant = restaurantEJB.readByUser(client);
				httpSession.setAttribute("client", client);
				httpSession.setAttribute("restaurant", restaurant);
				response.sendRedirect("./pages/restaurant_edit.jsp");
			} */else { 
				List<Restaurant> restaurants = restaurantEJB.read();
				httpSession.setAttribute("listRestaurants", restaurants);
				response.sendRedirect("../pages/index.jsp");
			}
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setCnpj(request.getParameter("cnpj"));
			restaurant.setName(request.getParameter("name"));
			restaurant.setDescription(request.getParameter("description"));
			restaurant.setState(request.getParameter("state"));
			restaurant.setCity(request.getParameter("city"));
			restaurant.setCep(request.getParameter("cep"));
			restaurant.setDistrict(request.getParameter("district"));
			restaurant.setAddress(request.getParameter("address"));
			restaurant.setNumber(request.getParameter("number"));
			restaurant.setAddition(request.getParameter("addition"));
			restaurant.setPhone(request.getParameter("phone"));
			boolean delivery;
			if (request.getParameter("delivery").equalsIgnoreCase("SIM")) {
				delivery = true;
			} else {
				delivery = false;
			}
			restaurant.setDelivery(delivery);
			boolean sunday = false, monday = false, tuesday = false, wednesday = false, thursday = false, friday = false, saturday = false;
			/*if (request.getParameter("sunday").equals("checked")) {
				sunday = true;
			} if (request.getParameter("monday").equals("checked")) {
				monday = true;
			} if (request.getParameter("tuesday").equals("checked")) {
				tuesday = true;
			} if (request.getParameter("thurday").equals("checked")) {
				thursday = true;
			} if (request.getParameter("wednesday").equals("checked")) {
				wednesday = true;
			} if (request.getParameter("friday").equals("checked")) {
				friday = true;
			} if (request.getParameter("saturday").equals("checked")) {
				saturday = true;
			}*/
			restaurant.setSunday_open(sunday);
			restaurant.setMonday_open(monday);
			restaurant.setTuesday_open(tuesday);
			restaurant.setThursday_open(thursday);
			restaurant.setWednesday_open(wednesday);
			restaurant.setFriday_open(friday);
			restaurant.setSaturday_open(saturday);
			restaurant.setTime_open(request.getParameter("time_open"));
			restaurant.setTime_close(request.getParameter("time_close"));

			HttpSession httpSession = request.getSession();
			Client client = (Client) httpSession.getAttribute("client");
			restaurant.setClient(client);
			Menu menu = new Menu();
			menu.setRestaurant(restaurant);
			menuEJB.create(menu);
			
			/*client = clientEJB.signIn(client.getEmail(), client.getPassword());
			restaurant = restaurantEJB.readByUser(client);
			menu = menuEJB.findByRestaurant(restaurant.getId());
			List<Product> products = menuEJB.readAllProducts(menu);
			menu.setProducts(products);
			
			System.out.println("id client " + client.getId());
			System.out.println("id restaurant " + restaurant.getId());
			System.out.println("id menu " + menu.getId());
			httpSession.setAttribute("restaurant", restaurant);
			httpSession.setAttribute("menu", menu);*/
			httpSession.setAttribute("clientLogged", client);
			response.sendRedirect("./pages/main.jsp");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Restaurant restaurant;
			restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("id")));
			restaurant.setCnpj(request.getParameter("cnpj"));
			restaurant.setName(request.getParameter("name"));
			restaurant.setDescription(request.getParameter("description"));
			restaurant.setState(request.getParameter("state"));
			restaurant.setCity(request.getParameter("city"));
			restaurant.setCep(request.getParameter("cep"));
			restaurant.setDistrict(request.getParameter("district"));
			restaurant.setAddress(request.getParameter("address"));
			restaurant.setNumber(request.getParameter("number"));
			restaurant.setAddition(request.getParameter("addition"));
			restaurant.setPhone(request.getParameter("phone"));
			boolean delivery;
			if (request.getParameter("delivery").equalsIgnoreCase("SIM")) {
				delivery = true;
			} else {
				delivery = false;
			}
			restaurant.setDelivery(delivery);
			boolean sunday = false, monday = false, tuesday = false, wednesday = false, thursday = false, friday = false, saturday = false;
			if (request.getParameter("sunday").equals("checked")) {
				sunday = true;
			} if (request.getParameter("monday").equals("checked")) {
				monday = true;
			} if (request.getParameter("tuesday").equals("checked")) {
				tuesday = true;
			} if (request.getParameter("thurday").equals("checked")) {
				thursday = true;
			} if (request.getParameter("wednesday").equals("checked")) {
				wednesday = true;
			} if (request.getParameter("friday").equals("checked")) {
				friday = true;
			} if (request.getParameter("saturday").equals("checked")) {
				saturday = true;
			}
			restaurant.setSunday_open(sunday);
			restaurant.setMonday_open(monday);
			restaurant.setTuesday_open(tuesday);
			restaurant.setThursday_open(thursday);
			restaurant.setWednesday_open(wednesday);
			restaurant.setFriday_open(friday);
			restaurant.setSaturday_open(saturday);
			restaurant.setTime_open(request.getParameter("time_open"));
			restaurant.setTime_close(request.getParameter("time_close"));
			

			restaurantEJB.update(restaurant);
			HttpSession httpSession = request.getSession();
			Client client = clientEJB.readById(Integer.parseInt(request.getParameter("client_id")));
			restaurant = restaurantEJB.readByUser(client);
			Menu menu = menuEJB.findByRestaurant(restaurant.getId());
			List<Product> products = productEJB.readAllProducts(menu);
			menu.setProducts(products);
			
			httpSession.setAttribute("clientLogged", client);
			httpSession.setAttribute("restaurant", restaurant);
			httpSession.setAttribute("menu", menu);
			response.sendRedirect("./pages/main.jsp");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
