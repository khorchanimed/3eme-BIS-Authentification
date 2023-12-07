package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getSession().removeAttribute("user") ;
		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect("index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login, pw;

		login = request.getParameter("login");
		pw = request.getParameter("pwd");

		if (login.equals("admin") && pw.equals("admin")) {

			User u = new User("TOUNSI", "Med Ali", login, pw);

			request.getSession().setAttribute("user", u);

			request.getRequestDispatcher("accueil.jsp").forward(request, response);
			// response.sendRedirect("accueil.jsp");
		} else {
			request.setAttribute("erreur", true);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
