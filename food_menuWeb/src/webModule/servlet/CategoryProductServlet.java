package webModule.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CategoryProductBean;
import bean.ClientBean;
import entity.Category;
import entity.Client;

/**
 * Servlet implementation class CategoryProductServlet
 */
@WebServlet(name = "CategoryProductServlet", urlPatterns = "/CategoryProductServlet")
public class CategoryProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	CategoryProductBean categoryProductEJB;
	
	@EJB
	ClientBean clientEJB;

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
			Client clientLogged = clientEJB.readById(Integer.parseInt(request.getParameter("clientID")));
			if (clientLogged != null) {
				Category categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));
				String pageURL = request.getParameter("pageURL");
				
				request.setAttribute("clientLogged", clientLogged);
				request.setAttribute("category", categoryProduct);
				request.getRequestDispatcher("./pages/" + pageURL).forward(request, response);
				
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
			Category categoryProduct = new Category();
			categoryProduct.setName(request.getParameter("name"));

			categoryProductEJB.create(categoryProduct);
			@SuppressWarnings("unused")
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			request.getRequestDispatcher("./ClientServlet?pageURL=categories.jsp?&clientID=${clientID}").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Category categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));
			categoryProduct.setName(request.getParameter("name"));

			categoryProductEJB.update(categoryProduct);
			@SuppressWarnings("unused")
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			request.getRequestDispatcher("./ClientServlet?pageURL=categories.jsp?&clientID=${clientID}").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Category categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("categoryID")));

			categoryProductEJB.delete(categoryProduct);
			@SuppressWarnings("unused")
			int clientID = Integer.parseInt(request.getParameter("clientID"));
			request.getRequestDispatcher("./ClientServlet?pageURL=categories.jsp?&clientID=${clientID}").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

}
