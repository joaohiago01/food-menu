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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
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
					httpSession.removeAttribute("pageURL");
					response.sendRedirect("./pages/" + pageURL);
				} else {//READ
					Category categoryProduct = new Category();
					Product product;
					if (request.getParameter("categoryID") != null) {
						categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));
					}
					product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
					product.setCategory(categoryProduct);
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
				HttpSession httpSession = request.getSession();
				Product product = new Product();
				product.setName(request.getParameter("name"));
				product.setDescription(request.getParameter("description"));
				product.setPrice(request.getParameter("price"));
				Category category = categoryProductEJB.readById(Integer.parseInt(request.getParameter("category")));
				Menu menu = (Menu) httpSession.getAttribute("menu");
				product.getMenu().add(menu);
				menu.getProducts().add(product);
				product.setCategory(category);
				productEJB.create(product);
				menu = menuEJB.update(menu);

				int clientID = Integer.parseInt(request.getParameter("clientID"));
				
				httpSession.setAttribute("clientID", clientID);
				httpSession.setAttribute("menu", menu);
				httpSession.setAttribute("pageURL", "products.jsp");
				response.sendRedirect("./ProductServlet");
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
			HttpSession httpSession = request.getSession();

			Product product = (Product) httpSession.getAttribute("product");
			Category category = categoryProductEJB.readById(Integer.parseInt(request.getParameter("category")));
			Menu menu = (Menu) httpSession.getAttribute("menu");
			product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(request.getParameter("price"));
			product.setCategory(category);
			
			product = productEJB.update(product);
			menu = menuEJB.update(menu);
			
			httpSession.removeAttribute("menu");

			int clientID = Integer.parseInt(request.getParameter("clientID"));
			httpSession.setAttribute("clientID", clientID);
			httpSession.setAttribute("menu", menu);
			httpSession.removeAttribute("product");

		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession httpSession = request.getSession();
			Product product = new Product();
			Menu menu = (Menu) httpSession.getAttribute("menu");
			Category category = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));
			product.setCategory(category);
			product = productEJB.readById(Integer.parseInt(request.getParameter("productID")));
			menu.getProducts().remove(product);
			productEJB.delete(product);
			
			List<Product> products = productEJB.readAllProducts(menu);
			menu.setProducts(products);
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			
			httpSession.setAttribute("clientID", clientID);
			httpSession.removeAttribute("product");
			httpSession.setAttribute("menu", menu);

		} catch (SQLException e) {

			throw new ServletException(e);
			
		}
	}

}
