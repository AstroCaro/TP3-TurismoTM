package controller.ofertas;

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
import persistence.commons.DAOFactory;
import services.AtraccionService;
import services.ComprarOfertaService;
import services.PromocionService;

@WebServlet("/ofertas/agregarAItinerarioOfera.do")
public class ComprarOfertaServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3800623316523866327L;

	ComprarOfertaService comprarService;
	AtraccionService atraccionService;
	PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		comprarService = new ComprarOfertaService();
		atraccionService = new AtraccionService();
		promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Integer idAtraccion = Integer.parseInt(req.getParameter("id"));
		Atraccion atraccion = atraccionService.buscar(idAtraccion);

		Map<String, String> errors = comprarService.comprar(usuario, atraccion);

		Usuario usuarioActualizado = DAOFactory.getUsuarioDAO().find(usuario.getId_usuario());
		req.getSession().setAttribute("usuario", usuarioActualizado);

		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cuenta_usuario/listado.do");
		dispatcher.forward(req, resp);

	}
}

