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

import bean.remote.CategoryProductBeanRemote;
import entity.CategoryProduct;

/**
 * Servlet implementation class CategoryProductServlet
 */
@WebServlet("/CategoryProductServlet")
public class CategoryProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	CategoryProductBeanRemote categoryProductEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<CategoryProduct> categoryProducts = categoryProductEJB.read();
			request.setAttribute("listCategoryProducts", categoryProducts);
			request.getRequestDispatcher("/CategoryProductList.xhtml").forward(request, response);
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
			CategoryProduct categoryProduct = new CategoryProduct();
			categoryProduct.setName(request.getParameter("name"));
			
			categoryProductEJB.create(categoryProduct);
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
			CategoryProduct categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
			categoryProduct.setName(request.getParameter("name"));
			
			categoryProductEJB.update(categoryProduct);
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
			CategoryProduct categoryProduct;
			categoryProduct = categoryProductEJB.readById(Integer.parseInt(request.getParameter("id")));
			
			categoryProductEJB.delete(categoryProduct);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		request.setCharacterEncoding(getServletInfo());
		request.getRequestDispatcher("/Main.xhtml").forward(request, response);
	}

}
