package controller.promociones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.ComprarOfertaService;
import services.PromocionService;

@WebServlet("/agregarPromocionAItinerario.do")
public class ComprarPromocionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3480177878957973545L;

	ComprarOfertaService comprarService;
	PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		comprarService = new ComprarOfertaService();
		promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Integer idPromocion = Integer.parseInt(req.getParameter("id"));
		Promocion promocion = promocionService.buscar(idPromocion);

		Map<String, String> errors = comprarService.comprar(usuario, promocion);

		Usuario usuarioActualizado = DAOFactory.getUsuarioDAO().find(usuario.getId_usuario());
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
