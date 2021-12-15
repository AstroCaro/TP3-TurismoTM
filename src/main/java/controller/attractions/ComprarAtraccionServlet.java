package controller.attractions;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Usuario;
import services.AtraccionService;
import services.ComprarOfertaService;
import services.UsuarioService;

@WebServlet("/agregarAtraccionAItinerario.do")
public class ComprarAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3480177878957973545L;

	ComprarOfertaService comprarService;
	AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		comprarService = new ComprarOfertaService();
		atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Integer idAtraccion = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = atraccionService.buscar(idAtraccion);

		Map<String, String> errors = comprarService.comprar(usuario, atraccion);
		
		UsuarioService usuarioService = new UsuarioService();

		Usuario usuarioActualizado = usuarioService.buscar(usuario.getId_usuario());

		req.getSession().setAttribute("usuario", usuarioActualizado);

		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cuenta_usuario/ofertas.do");
		dispatcher.forward(req, resp);

	}
}
