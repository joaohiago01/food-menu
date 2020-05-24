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
			Restaurant restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("rstaurantID")));
			String pageURL = request.getParameter("pageURL");
			if (restaurant != null) {
				Menu menu = menuEJB.findByRestaurant(restaurant.getId());
				request.setAttribute("menu", menu);
				request.setAttribute("restaurant", restaurant);
				request.getRequestDispatcher("./pages/" + pageURL).forward(request, response);	
			} else {
				List<Restaurant> restaurants = restaurantEJB.read();
				request.setAttribute("restaurants", restaurants);
				request.getRequestDispatcher("./pages/" + pageURL).forward(request, response);				
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
			if (request.getParameter("sunday").equals("on")) {
				sunday = true;
			} if (request.getParameter("monday").equals("on")) {
				monday = true;
			} if (request.getParameter("tuesday").equals("on")) {
				tuesday = true;
			} if (request.getParameter("thurday").equals("on")) {
				thursday = true;
			} if (request.getParameter("wednesday").equals("on")) {
				wednesday = true;
			} if (request.getParameter("friday").equals("on")) {
				friday = true;
			} if (request.getParameter("saturday").equals("on")) {
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

			HttpSession httpSession = request.getSession();
			Client client = (Client) httpSession.getAttribute("client");
			restaurant.setClient(client);
			Menu menu = new Menu();
			menu.setRestaurant(restaurant);
			menuEJB.create(menu);

			request.getRequestDispatcher("./ClientServlet?pageURL=main.jsp&clientID=${client.getId()}").forward(request, response);
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
			if (request.getParameter("sunday").equals("on")) {
				sunday = true;
			} if (request.getParameter("monday").equals("on")) {
				monday = true;
			} if (request.getParameter("tuesday").equals("on")) {
				tuesday = true;
			} if (request.getParameter("thurday").equals("on")) {
				thursday = true;
			} if (request.getParameter("wednesday").equals("on")) {
				wednesday = true;
			} if (request.getParameter("friday").equals("on")) {
				friday = true;
			} if (request.getParameter("saturday").equals("on")) {
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
			@SuppressWarnings("unused")
			int clientID = Integer.parseInt(request.getParameter("clientID"));

			request.getRequestDispatcher("./ClientServlet?pageURL=main.jsp?&clientID=${clientID}").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
