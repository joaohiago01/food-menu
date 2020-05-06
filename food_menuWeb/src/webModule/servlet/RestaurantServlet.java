package webModule.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.remote.CategoryProductBeanRemote;
import bean.remote.ClientBeanRemote;
import bean.remote.RestaurantBeanRemote;
import entity.CategoryProduct;
import entity.Client;
import entity.Restaurant;

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	RestaurantBeanRemote restaurantEJB;
	
	@EJB
	ClientBeanRemote clientEJB;
	
	@EJB
	CategoryProductBeanRemote categoryProductEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getServletPath();
			switch (action) {
			case "/restaurantsByUser":
				doGetByUser(request, response);
				break;

			case "/restaurantsByCategory":
				doGetByCategory(request, response);
				break;
			}
			
			List<Restaurant> restaurants = restaurantEJB.read();
			request.setAttribute("listRestaurants", restaurants);
			request.getRequestDispatcher("/RestaurantsList.xhtml").forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	protected void doGetByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Client client = clientEJB.readById(Integer.parseInt(request.getParameter("id")));
			List<Restaurant> restaurants = restaurantEJB.readByUser(client);
			request.setAttribute("listRestaurants", restaurants);
			request.getRequestDispatcher("/RestaurantsList.xhtml").forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	protected void doGetByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryProduct categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
			List<Restaurant> restaurants = restaurantEJB.readByCategory(categoryProduct);
			request.setAttribute("listRestaurants", restaurants);
			request.getRequestDispatcher("/RestaurantsList.xhtml").forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			@SuppressWarnings("deprecation")
			Date timeOpen = new Date(request.getParameter("time_open"));
			@SuppressWarnings("deprecation")
			Date timeClose = new Date(request.getParameter("time_close"));
			restaurant.setTime_open(timeOpen);
			restaurant.setTime_close(timeClose);
			
			restaurantEJB.create(restaurant);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			@SuppressWarnings("deprecation")
			Date timeOpen = new Date(request.getParameter("time_open"));
			@SuppressWarnings("deprecation")
			Date timeClose = new Date(request.getParameter("time_close"));
			restaurant.setTime_open(timeOpen);
			restaurant.setTime_close(timeClose);
			
			restaurantEJB.update(restaurant);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Restaurant restaurant;
			restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("id")));
			restaurantEJB.delete(restaurant);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}
}
