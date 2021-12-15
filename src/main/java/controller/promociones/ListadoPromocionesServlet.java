package controller.promociones;

import java.io.IOException;
import java.util.ArrayList;

import model.Promocion;
import services.PromocionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/promociones/listadoPromociones.do")

public class ListadoPromocionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7252040525286394631L;

	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Promocion> promociones = promocionService.listar();
		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/listadoPromociones.jsp");
		dispatcher.forward(req, resp);
	}
}