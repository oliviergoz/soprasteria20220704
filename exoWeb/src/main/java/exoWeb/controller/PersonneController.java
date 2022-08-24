package exoWeb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exoWeb.model.Personne;

/**
 * Servlet implementation class PersonneController
 */
@WebServlet("/personne")
public class PersonneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/personne/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		RequestDispatcher rd = null;
		if (prenom == null || prenom.isEmpty() || nom == null || nom.isEmpty()) {
			rd = request.getRequestDispatcher("/WEB-INF/personne/form.jsp");
			request.setAttribute("error", true);
		} else {
			request.setAttribute("personne", new Personne(prenom, nom));
			rd = request.getRequestDispatcher("/WEB-INF/personne/hello.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("personneSession", new Personne(prenom, nom));
			ServletContext ctx = this.getServletContext();
			ctx.setAttribute("personneApplication", new Personne(prenom, nom));

		}

		rd.forward(request, response);
	}

}
