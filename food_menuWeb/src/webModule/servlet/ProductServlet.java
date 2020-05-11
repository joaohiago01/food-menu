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

import bean.CategoryProductBean;
import bean.ProductBean;
import entity.CategoryProduct;
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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String action = request.getServletPath();
			switch (action) {
			case "/productsByCategory":
				doGetByCategory(request, response);
				break;
			}
			List<Product> products = productEJB.read();
			request.setAttribute("listProducts", products);
			request.getRequestDispatcher("/ProductList.xhtml").forward(request, response);
		} catch (SQLException e) {
			
			throw new ServletException(e);
		}
	}

	private void doGetByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			CategoryProduct categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
			List<Product> products = productEJB.readByCategory(categoryProduct);
			request.setAttribute("listProducts", products);
			request.getRequestDispatcher("/ProductsList.xhtml").forward(request, response);
		} catch (SQLException e) {
			
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));

			productEJB.create(product);
		} catch (SQLException e) {
			
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Product product;
			product = productEJB.readById(Integer.parseInt(request.getParameter("id")));
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));

			productEJB.update(product);
		} catch (SQLException e) {
			
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Product product;
			product = productEJB.readById(Integer.parseInt(request.getParameter("id")));

			productEJB.delete(product);
		} catch (SQLException e) {
			
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

}
