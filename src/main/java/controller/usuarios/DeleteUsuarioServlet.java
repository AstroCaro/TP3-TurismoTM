package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UsuarioService;

@WebServlet("/usuarios/delete.do")
public class DeleteUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -813897280677434577L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

		usuarioService.delete(id_usuario);

		resp.sendRedirect("/TurismoTMTP3/usuarios/listadoUsuarios.do");
	}


}
