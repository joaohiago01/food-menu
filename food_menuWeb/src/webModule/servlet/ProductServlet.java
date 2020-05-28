package webModule.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	ProductBean productEJB;

	@EJB
	CategoryProductBean categoryProductEJB;

	@EJB
	ClientBean clientEJB;

	@EJB
	RestaurantBean restaurantEJB;

	@EJB
	MenuBean menuEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		System.out.println("Categoria:" + request.getParameter("categoryID"));
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
			Client clientLogged;
			String pageURL;
			if (request.getParameter("clientID") == null) {
				clientLogged = clientEJB.readById(Integer.parseInt(httpSession.getAttribute("clientID").toString()));	
				pageURL = httpSession.getAttribute("pageURL").toString();
			} else {
				clientLogged = clientEJB.readById(Integer.parseInt(request.getParameter("clientID")));	
				pageURL = request.getParameter("pageURL");
			}
			if (clientLogged != null) {
				if (httpSession.getAttribute("pageURL") != null) {//PUT
					response.sendRedirect("./pages/" + pageURL);
				} else {//READ
					Category categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));
					Product product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
					Menu menu = (Menu) httpSession.getAttribute("menu");

					httpSession.setAttribute("category", categoryProduct);
					httpSession.setAttribute("product", product);
					httpSession.setAttribute("menu", menu);
					response.sendRedirect("./pages/" + pageURL);
				}
			} else {
				response.sendRedirect("./pages/login.jsp");
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
			if (request.getParameter("_method") != null) {//PUT METHOD
				if (request.getParameter("_method").equalsIgnoreCase("put")) {
					doPut(request, response);
				}
				else if (request.getParameter("_method").equalsIgnoreCase("delete")) {
					doDelete(request, response);
				}
			}
			else {
				Product product = new Product();
				product.setName(request.getParameter("name"));
				product.setDescription(request.getParameter("description"));
				product.setPrice(Double.parseDouble(request.getParameter("price")));
				Category category = categoryProductEJB.readById(Integer.parseInt(request.getParameter("category")));
				Menu menu = menuEJB.readById(Integer.parseInt(request.getParameter("menuID")));
				product.getMenu().add(menu);
				menu.getProducts().add(product);
				product.setCategory(category);
				productEJB.create(product);
				menuEJB.update(menu);

				int clientID = Integer.parseInt(request.getParameter("clientID"));
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("pageURL", "products.jsp");
				httpSession.setAttribute("clientID", clientID);
				httpSession.setAttribute("menu", menu);
				response.sendRedirect("./ClientServlet");
			}
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			Product product;
			product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));

			HttpSession httpSession = request.getSession();
			Category category = (Category) httpSession.getAttribute("categoryProduct");

			product.setCategory(category);
			productEJB.update(product);

			int clientID = Integer.parseInt(request.getParameter("clientID"));

			httpSession.setAttribute("pageURL", "products.jsp");
			httpSession.setAttribute("clientID", clientID);

		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Product product;
			Menu menu = menuEJB.readById(Integer.parseInt(request.getParameter("menuID")));
			product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
			menu.getProducts().remove(product);
			menu = menuEJB.update(menu);
			productEJB.delete(product);
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("pageURL", "products.jsp");
			httpSession.setAttribute("clientID", clientID);
			httpSession.setAttribute("menu", menu);

		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

}
