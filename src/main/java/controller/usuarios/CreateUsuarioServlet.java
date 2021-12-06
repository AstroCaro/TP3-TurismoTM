package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/usuarios/crear.do")
public class CreateUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuarios/crear.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String preferencia = req.getParameter("tipoAtraccion");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		Double tiempo_disponible = Double.parseDouble(req.getParameter("tiempo_disponible"));
		Boolean admin = Boolean.parseBoolean(req.getParameter("tiempo_disponible"));
		
		Usuario usuario = usuarioService.create(nombre, preferencia, presupuesto, tiempo_disponible, admin);

		
		if (usuario.isValid()) {
			resp.sendRedirect("/TurismoTMTP3/usuarios/listadoUsuarios.do");
		} else {
			req.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuarios/crear.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
