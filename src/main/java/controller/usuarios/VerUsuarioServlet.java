package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/usuarios/verUsuario.do")

public class VerUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8348190042470480487L;
	
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

		Usuario usuario = usuarioService.buscar(id_usuario);
		req.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/verUsuario.jsp");
		dispatcher.forward(req, resp);
	}

}