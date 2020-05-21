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
import entity.CategoryProduct;

/**
 * Servlet implementation class CategoryProductServlet
 */
@WebServlet(name = "CategoryProductServlet", urlPatterns = "/CategoryProductServlet")
public class CategoryProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	CategoryProductBean categoryProductEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryProductServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession httpSession = request.getSession();
			if (!request.getParameter("id").isEmpty()) {
				CategoryProduct categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
				httpSession.setAttribute("category", categoryProduct.getName());
				response.sendRedirect("./pages/category_edit");
			} else {
				List<CategoryProduct> categoryProducts = categoryProductEJB.read();
				httpSession.setAttribute("listCategoryProducts", categoryProducts);
				response.sendRedirect("./pages/categories.jsp");
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
			CategoryProduct categoryProduct = new CategoryProduct();
			categoryProduct.setName(request.getParameter("name"));

			categoryProductEJB.create(categoryProduct);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		response.sendRedirect("./pages/categories.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			CategoryProduct categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
			categoryProduct.setName(request.getParameter("name"));

			categoryProductEJB.update(categoryProduct);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		response.sendRedirect("./pages/categories.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			CategoryProduct categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));

			categoryProductEJB.delete(categoryProduct);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		response.sendRedirect("./pages/categories.jsp");
	}

}
