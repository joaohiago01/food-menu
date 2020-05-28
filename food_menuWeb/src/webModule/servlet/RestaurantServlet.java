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

	@EJB
	CategoryProductBean categoryProductEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestaurantServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		super.service(request, response);
		if(request.getParameter("_method") != null) {
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession httpSession = request.getSession();
			String pageURL = request.getParameter("pageURL");
			
			if (pageURL != null) {
				if (pageURL.equals("index.jsp")) {
					String flagStartWebSite = "flagStartWebSite";

					List<Restaurant> restaurants = restaurantEJB.read();
					httpSession.setAttribute("restaurants", restaurants);
					httpSession.setAttribute("flagStartWebSite", flagStartWebSite);
					response.sendRedirect("./pages/" + pageURL); 
				} else {
					Restaurant restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("restaurantID")));
					if (restaurant != null) {
						Menu menu = menuEJB.findByRestaurant(restaurant.getId());
						httpSession.setAttribute("menu", menu);
						httpSession.setAttribute("restaurant", restaurant);
						httpSession.setAttribute("category", restaurant.getCategory());
						
						response.sendRedirect("./pages/" + pageURL);
					} 
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

		if (request.getParameter("_method") != null) {//PUT METHOD
			doPut(request, response);
		} else {

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
				if (request.getParameter("delivery") != null && (request.getParameter("delivery").equalsIgnoreCase("offYes") || request.getParameter("delivery").equalsIgnoreCase("onNo"))) {
					delivery = false;
				} else {
					delivery = true;
				}
				restaurant.setDelivery(delivery);
				boolean sunday = true, monday = true, tuesday = true, wednesday = true, thursday = true, friday = true, saturday = true;

				if (request.getParameter("sunday") == null || request.getParameter("sunday").equals("off")) {
					sunday = false;
				} if (request.getParameter("monday") == null || request.getParameter("monday").equals("off")) {
					monday = false;
				} if (request.getParameter("tuesday") == null || request.getParameter("tuesday").equals("off")) {
					tuesday = false;
				} if (request.getParameter("thurday") == null || request.getParameter("thurday").equals("off")) {
					thursday = false;
				} if (request.getParameter("wednesday") == null || request.getParameter("wednesday").equals("off")) {
					wednesday = false;
				} if (request.getParameter("friday") == null || request.getParameter("friday").equals("off")) {
					friday = false;
				} if (request.getParameter("saturday") == null || request.getParameter("saturday").equals("off")) {
					saturday = false;
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

				HttpSession httpSession = request.getSession();
				Client client = (Client) httpSession.getAttribute("client");
				restaurant.setClient(client);
				Menu menu = new Menu();
				menu.setRestaurant(restaurant);
				menuEJB.create(menu);

				httpSession.setAttribute("email", client.getEmail());
				httpSession.setAttribute("password", client.getPassword());
				response.sendRedirect("./pages/main.jsp");
			} catch (SQLException e) {

				throw new ServletException(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Restaurant restaurant;
			restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("restaurantID")));
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
			if (request.getParameter("delivery") != null && (request.getParameter("delivery").equalsIgnoreCase("offYes") || request.getParameter("delivery").equalsIgnoreCase("onNo"))) {
				delivery = false;
			} else {
				delivery = true;
			}
			restaurant.setDelivery(delivery);
			boolean sunday = true, monday = true, tuesday = true, wednesday = true, thursday = true, friday = true, saturday = true;

			if (request.getParameter("sunday") == null || request.getParameter("sunday").equals("off")) {
				sunday = false;
			} if (request.getParameter("monday") == null || request.getParameter("monday").equals("off")) {
				monday = false;
			} if (request.getParameter("tuesday") == null || request.getParameter("tuesday").equals("off")) {
				tuesday = false;
			} if (request.getParameter("thurday") == null || request.getParameter("thurday").equals("off")) {
				thursday = false;
			} if (request.getParameter("wednesday") == null || request.getParameter("wednesday").equals("off")) {
				wednesday = false;
			} if (request.getParameter("friday") == null || request.getParameter("friday").equals("off")) {
				friday = false;
			} if (request.getParameter("saturday") == null || request.getParameter("saturday").equals("off")) {
				saturday = false;
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

			HttpSession httpSession = request.getSession();

			Menu menu = (Menu) httpSession.getAttribute("menu");
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			Client client = clientEJB.readById(clientID);
			Category category = categoryProductEJB.readById(Integer.parseInt(request.getParameter("category")));

			restaurant.setCategory(category);
			menu.setRestaurant(restaurant);
			restaurant.setClient(client);

			restaurant = restaurantEJB.update(restaurant);
			menu = menuEJB.update(menu);

			httpSession.setAttribute("pageURL", "main.jsp");
			httpSession.setAttribute("clientID", clientID);
			httpSession.setAttribute("restaurant", restaurant);
			httpSession.setAttribute("menu", menu);

		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
