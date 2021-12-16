package controller.session;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import model.Oferta;
import model.Usuario;
import services.ItinerarioService;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7426414066105522340L;

	private LoginService loginService;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		itinerarioService = new ItinerarioService();
	}

	// REQ encapsula las peticiones que viene del usuario
	// RESP encapsula la respuesta qeu le dará el servidor
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Usuario usuario = loginService.login(username, password);

		if (!usuario.isNull()) {
			ArrayList<Oferta> itinerario = itinerarioService.buscarPorUsuario(usuario.getId_usuario());
			usuario.setItinerario(new Itinerario(itinerario));
			req.getSession().setAttribute("usuario", usuario);// abstraccion del tiempo que utiliza el usuario dentro
															// de la app
			
			if(usuario.getAdmin()) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/panel_administrador.jsp");				
				dispatcher.forward(req, resp);
			}
			else {
				// le pido al contexto del servelt que me lleva a donde quiero redireccionar
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cuenta_usuario/ofertas.do");				
				dispatcher.forward(req, resp);				
			}
		} else {
			req.setAttribute("flash", "Usuario/Contraseña incorrectos");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);// en camino
			// resp.sendRedirect("login.jsp");
		}
	}

}
