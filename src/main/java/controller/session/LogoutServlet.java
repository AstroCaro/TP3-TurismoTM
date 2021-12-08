package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 132276158438139880L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("username");
		req.setAttribute("flash", "Hasta la próxima");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp"); //le pido al contexto del servelt que me lleva a donde quiero direccionar
		dispatcher.forward(req, resp);//en camino
	}

}
