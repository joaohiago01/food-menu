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

import bean.ClientBean;
import entity.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(name = "ClientServlet", urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	ClientBean clientEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try { 
			String action = request.getServletPath();
			if (action.equalsIgnoreCase("/signIn")) {
				signIn(request, response);
			} else {
				List<Client> clients = clientEJB.read();
				request.setAttribute("listClients", clients);
				//request.getRequestDispatcher("/.html").forward(request, response);
			}
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	protected void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Client client = clientEJB.signIn(email, password);
			request.setAttribute("client", client);
			request.getRequestDispatcher("../pages/main.html").forward(request, response);
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Client client = new Client();
		client.setCpf(request.getParameter("cpf"));
		client.setName(request.getParameter("name"));
		client.setEmail(request.getParameter("email"));
		client.setPassword(request.getParameter("password"));
		response.sendRedirect("./pages/restaurant_register.html");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Client client;
			client = clientEJB.readById(Integer.parseInt(request.getParameter("id")));
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));
			clientEJB.update(client);
			response.sendRedirect("./pages/profile.html");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Client client;
			client = clientEJB.readById(Integer.parseInt(request.getParameter("id")));
			clientEJB.delete(client);
			response.sendRedirect("./pages/profile.html");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
