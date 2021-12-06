package controller.usuarios;

import java.io.IOException;
import java.util.ArrayList;

import model.Usuario;
import services.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios/listadoUsuarios.do")

public class ListadoUsuariosServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = -6068564252281199071L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Usuario> usuarios = usuarioService.listar();		
		req.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/listadoUsuarios.jsp");
		dispatcher.forward(req, resp);
	}
}