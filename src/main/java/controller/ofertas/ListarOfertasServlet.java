package controller.ofertas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Oferta;
import model.Usuario;
import services.ItinerarioService;
import services.OfertaService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cuenta_usuario/ofertas.do")
public class ListarOfertasServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -6716801637279364441L;

	private OfertaService ofertaService;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		ofertaService = new OfertaService();
		itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		ArrayList<Oferta> ofertas = ofertaService.listarOrdenado(usuario.getPreferencia().getTipoAtraccion());
		req.getSession().setAttribute("ofertas", ofertas);
		ArrayList<Oferta> itinerario = itinerarioService.buscarPorUsuario(usuario.getId_usuario());
		req.setAttribute("itinerario",itinerario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/cuentaUsuario/index.jsp"); /*le pido al contexto del servlet que me lleve a donde quiero direccionar*/

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		ArrayList<Oferta> ofertas = ofertaService.listarOrdenado(usuario.getPreferencia().getTipoAtraccion());
		req.getSession().setAttribute("ofertas", ofertas);
		ArrayList<Oferta> itinerario = itinerarioService.buscarPorUsuario(usuario.getId_usuario());
		req.setAttribute("itinerario",itinerario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/cuentaUsuario/index.jsp");
		dispatcher.forward(req, resp);
	}
}
