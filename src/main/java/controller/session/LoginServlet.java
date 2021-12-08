package controller.session;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Usuario;
import model.ComparadorDeOfertas;
import services.AtraccionService;
import services.LoginService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7426414066105522340L;

	private LoginService loginService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		atraccionService = new AtraccionService();
	}

	//REQ	encapsula las peticiones que viene del usuario
	//RESP  encapsula  la respuesta qeu le dará el servidor
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Usuario user = loginService.login(username, password);
		
		if (!user.isNull()) {
			List<Atraccion> atracciones = atraccionService.listar();
			ordenarOfertas(atracciones, user.getPreferencia());
			req.getSession().setAttribute("atracciones", atracciones);
			req.getSession().setAttribute("username", username);//abstraccion del tiempo que utiliza el usuario dentro de la app
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cuenta_usuario.jsp"); //le pido al contexto del servelt que me lleva a donde quiero direccionar
			dispatcher.forward(req, resp);
			//resp.sendRedirect("cuenta_usuario.jsp");
		} else {
			req.setAttribute("flash", "Usuario incorrecta");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp"); //le pido al contexto del servelt que me lleva a donde quiero direccionar
			dispatcher.forward(req, resp);//en camino
			//resp.sendRedirect("login.jsp");
		}
	}
	

}
