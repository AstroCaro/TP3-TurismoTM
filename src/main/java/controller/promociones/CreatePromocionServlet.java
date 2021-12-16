package controller.promociones;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionService;

@WebServlet("/promociones/crear.do")
public class CreatePromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/crear.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		Integer idTipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));

		Integer cantidadAtracciones = Integer.parseInt(req.getParameter("cantidadAtracciones"));
		ArrayList<Integer> atraccionesIncluidas = new ArrayList<Integer>();
		for (int i = 1; i <= cantidadAtracciones; i++) {
			atraccionesIncluidas.add(Integer.parseInt(req.getParameter("atracciones" + i)));
		}
		String tipoPromocion = req.getParameter("tipoPromocion");
		Integer costo = Integer.parseInt(req.getParameter("costo"));

		Integer idAtraccionGratis = 0;
		if (req.getParameter("atraccionGratis") == null) {
			idAtraccionGratis = 0;
		} else {
			idAtraccionGratis = Integer.parseInt(req.getParameter("atraccionGratis"));
		}
		Double descuento = Double.parseDouble(req.getParameter("descuento"));
		System.out.println(nombre + " " + descripcion + " " + tipoPromocion + " " + idTipoAtraccion + " " + costo + " "
				+ descuento + " " + idAtraccionGratis + " " + atraccionesIncluidas);

		Promocion promocion = promocionService.create(nombre, descripcion, tipoPromocion, idTipoAtraccion, costo,
				descuento, idAtraccionGratis, atraccionesIncluidas);

		if (promocion.isValid()) {
			resp.sendRedirect("/TurismoTMTP3/promociones/listadoPromociones.do");
		} else {
			req.setAttribute("promocion", promocion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		}

	}

}