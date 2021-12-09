package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones/edit.do")
public class EditAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 7722261745778040380L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id_atraccion"));

		Atraccion atraccion = atraccionService.buscar(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_atraccion = Integer.parseInt(req.getParameter("id_atraccion"));
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("descripcion");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cuposDisponibles = Integer.parseInt(req.getParameter("cuposDisponibles"));
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
		
		Atraccion atraccion = atraccionService.update(id_atraccion, nombre, descripcion, costo, tiempo, cuposDisponibles, tipoAtraccion);

		if (atraccion.isValid()) {
			resp.sendRedirect("/TurismoTMTP3/atracciones/listadoAtracciones.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/editar.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
