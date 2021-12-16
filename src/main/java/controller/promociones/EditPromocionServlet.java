package controller.promociones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Promocion;

import services.PromocionService;

@WebServlet("/promociones/edit.do")
public class EditPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 7722261745778040380L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id_promocion"));

		Promocion promocion = promocionService.buscar(id);
		req.setAttribute("promocion", promocion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_promocion = Integer.parseInt(req.getParameter("id_promocion"));
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");

		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));

		Promocion promocion = promocionService.update(id_promocion, nombre, descripcion, tipoAtraccion);

		if (promocion.isValid()) {
			resp.sendRedirect("/TurismoTMTP3/promociones/listadoPromociones.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
