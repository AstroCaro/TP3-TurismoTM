package controller.promociones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String nombre = req.getParameter("nombre");
//		String descripcion = req.getParameter("descripcion");
//		Integer idTipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
//		Integer cantidadAtracciones = Integer.parseInt(req.getParameter("cantidadAtracciones"));
//		for (int i = 0; i < cantidadAtracciones; i++) {
//
//		}
//		String tipoPromocion = req.getParameter("tipoPromocion");
//		Integer idTipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
//		Integer costo = Integer.parseInt(req.getParameter("costo"));
//		// Integer cost = req.getParameter("cost").trim() == "" ? null :
//		// Integer.parseInt(req.getParameter("cost"));
//		Double descuento = Double.parseDouble(req.getParameter("descuento"));
//		Integer idAtraccionGratis = Integer.parseInt(req.getParameter("idAtraccionGratis"));
//
//		Promocion atraccion = promocionService.create(nombre, descripcion, tipoPromocion, idTipoAtraccion, costo,
//				descuento, idAtraccionGratis, nombreAtracciones);
//
//		if (atraccion.isValid()) {
//			resp.sendRedirect("/TurismoTMTP3/atracciones/listadoAtracciones.do");
//		} else {
//			req.setAttribute("atraccion", atraccion);
//
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/crear.jsp");
//			dispatcher.forward(req, resp);
//		}
//
//	}
//
//}
