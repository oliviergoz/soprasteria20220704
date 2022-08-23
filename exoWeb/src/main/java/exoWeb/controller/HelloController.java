package exoWeb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prenom = req.getParameter("prenom");
		RequestDispatcher rd = null;
		if (prenom == null || prenom.isEmpty()) {
			// erreur
			rd = req.getRequestDispatcher("/WEB-INF/form.jsp");
			req.setAttribute("error", "prenom obligatoire");
		} else {
			// ok
			req.setAttribute("prenom", prenom);
			rd = req.getRequestDispatcher("/WEB-INF/hello.jsp");
		}
		rd.forward(req, resp);
	}
}
