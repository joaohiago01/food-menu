package webModule.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.remote.MenuBeanRemote;
import bean.remote.ProductBeanRemote;
import bean.remote.RestaurantBeanRemote;
import entity.Menu;
import entity.Product;
import entity.Restaurant;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	MenuBeanRemote menuEJB;
	
	@EJB
	RestaurantBeanRemote restaurantEJB;
	
	@EJB
	ProductBeanRemote productEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
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
			case "/allProducts":
				doGetAllProducts(request, response);
				break;
			}
			List<Menu> menus = menuEJB.read();
			request.setAttribute("listMenus", menus);
			request.getRequestDispatcher("/MenuList.xhtml").forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

	private void doGetAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Menu menu = menuEJB.readById(Integer.parseInt(request.getParameter("id")));
			List<Product> products = menuEJB.readAllProducts(menu);
			request.setAttribute("listProductsByMenu", products);
			request.getRequestDispatcher("/ProductsByMenuList.xhtml").forward(request, response);
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
			Restaurant restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("id")));
			String[] idProducts = request.getParameterValues("products");
			List<Product> products = new ArrayList<Product>();
			for (String id: idProducts) {
				int idProduct = Integer.parseInt(id);
				Product product = productEJB.readById(idProduct);
				products.add(product);
			}
			Menu menu = new Menu();
			menu.setRestaurant(restaurant);
			menu.setMenu(products);
			
			menuEJB.create(menu);
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
			Restaurant restaurant = restaurantEJB.readById(Integer.parseInt(request.getParameter("restaurant_id")));
			String[] idProducts = request.getParameterValues("products");
			List<Product> products = new ArrayList<Product>();
			for (String id: idProducts) {
				int idProduct = Integer.parseInt(id);
				Product product = productEJB.readById(idProduct);
				products.add(product);
			}
			Menu menu;
			menu = menuEJB.readById(Integer.parseInt("id"));
			menu.setRestaurant(restaurant);
			menu.setMenu(products);
			
			menuEJB.update(menu);
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
			Menu menu;
			menu = menuEJB.readById(Integer.parseInt(request.getParameter("id")));
			
			menuEJB.delete(menu);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

}
