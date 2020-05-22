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
			HttpSession httpSession = request.getSession();
			if (!request.getParameter("signIn").isEmpty()) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				Client client = clientEJB.signIn(email, password);
				if (client != null) {
					httpSession.setAttribute("clientLogged", client);
					response.sendRedirect("./pages/main.jsp");
				} else {
					response.sendRedirect("./pages/login.jsp");
				}
			} else if (!request.getParameter("id").isEmpty()) {
				Client client = clientEJB.readById(Integer.parseInt(request.getParameter("id")));
				httpSession.setAttribute("client", client);
				response.sendRedirect("./pages/profile.jsp");
			} else {
				List<Client> clients = clientEJB.read();
				request.setAttribute("listClients", clients);
				response.sendRedirect("./pages/index.jsp");
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
			Client client = new Client();
			client.setCpf(request.getParameter("cpf"));
			client.setName(request.getParameter("name"));
			client.setEmail(request.getParameter("email"));
			client.setPassword(request.getParameter("password"));
			
			clientEJB.create(client);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("client", client);
			response.sendRedirect("./pages/restaurant_register.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			response.sendRedirect("./pages/main.jsp");
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
			response.sendRedirect("./pages/main.jsp");
		} catch (SQLException e) {

			throw new ServletException(e);
		}
	}
}
