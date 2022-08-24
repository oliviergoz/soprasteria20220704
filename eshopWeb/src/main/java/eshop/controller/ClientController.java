package eshop.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.config.AppConfig;
import eshop.entities.Adresse;
import eshop.entities.Client;
import eshop.services.ClientService;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) this.getServletContext()
				.getAttribute("spring");
		clientService = ctx.getBean(ClientService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		if (request.getParameter("q") == null || request.getParameter("q").isEmpty()) {
			rd = list(request, response);
		} else if (request.getParameter("q").equals("add")) {
			rd = add(request, response);
		} else if (request.getParameter("q").equals("delete")) {
			rd = delete(request, response);
		} else if (request.getParameter("q").equals("edit")) {
			rd = edit(request, response);
		}
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		if (request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()) {
			rd = update(request, response);
		} else {
			rd = create(request, response);
		}
		rd.forward(request, response);

	}

	private RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Client client = getClientFromRequest(request);
		client.setId(id);
		clientService.update(client);
		return list(request, response);
	}

	private Client getClientFromRequest(HttpServletRequest request) {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String mail = request.getParameter("mail");
		String numero = request.getParameter("numero");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");

		return new Client(prenom, nom, mail, new Adresse(numero, rue, codePostal, ville));
	}

	private RequestDispatcher create(HttpServletRequest request, HttpServletResponse response) {
		Client client = getClientFromRequest(request);
		clientService.create(client);
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("clients", clientService.getAll());
		return request.getRequestDispatcher("/WEB-INF/client/list.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		clientService.deleteById(id);
		return list(request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "create");
		return goFormEdit(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("action", "update");
		request.setAttribute("client", clientService.getById(id));
		return goFormEdit(request, response);
	}

	private RequestDispatcher goFormEdit(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/client/edit.jsp");
	}

}
