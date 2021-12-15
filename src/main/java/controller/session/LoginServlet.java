package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7426414066105522340L;

	private LoginService loginService;
	// private OfertaService ofertaService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		// ofertaService = new OfertaService();
	}

	// REQ encapsula las peticiones que viene del usuario
	// RESP encapsula la respuesta qeu le dará el servidor
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Usuario usuario = loginService.login(username, password);

		if (!usuario.isNull()) {

			req.getSession().setAttribute("usuario", usuario);// abstraccion del tiempo que utiliza el usuario dentro
																// de la app
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cuenta_usuario/ofertas.do"); // le
																													// pido
																													// al
																													// contexto
																													// del
																													// servelt
																													// que
																													// me
																													// lleva
																													// a
																													// donde
																													// quiero
																													// redireccionar
			dispatcher.forward(req, resp);
			// resp.sendRedirect("cuenta_usuario.jsp");
		} else {
			req.setAttribute("flash", "Usuario/Contraseña incorrectos");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);// en camino
			// resp.sendRedirect("login.jsp");
		}
	}

}
