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
			HttpSession httpSession = request.getSession();
			if (!request.getParameter("category_id").isEmpty() && !request.getParameter("product_id").isEmpty()) {
				CategoryProduct categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("category_id")));
				Product product = productEJB.readById(Integer.parseInt(request.getParameter("product_id")));
				List<CategoryProduct> list = categoryProductEJB.read();
				httpSession.setAttribute("category", categoryProduct);
				httpSession.setAttribute("product", product);
				httpSession.setAttribute("categories", list);
				response.sendRedirect("./pages/category_edit.jsp");
			} else if (!request.getParameter("newProduct").isEmpty()) {
				List<CategoryProduct> categoryProducts = categoryProductEJB.read();
				httpSession.setAttribute("listCategoryProducts", categoryProducts);
				response.sendRedirect("./pages/product_register.jsp");
			} else {
				List<Product> products = productEJB.readAll();
				httpSession.setAttribute("listProducts", products);
				response.sendRedirect("./pages/products.jsp");
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
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			

			productEJB.create(product);
			
			response.sendRedirect("./pages/products.jsp");
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
			product = productEJB.readById(Integer.parseInt(request.getParameter("id")));
			product.setName(request.getParameter("name"));
			product.setDescription(request.getParameter("description"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));

			productEJB.update(product);
			response.sendRedirect("./pages/products.jsp");
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
			product = productEJB.readById(Integer.parseInt(request.getParameter("id")));

			productEJB.delete(product);
			response.sendRedirect("./pages/products.jsp");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

}
