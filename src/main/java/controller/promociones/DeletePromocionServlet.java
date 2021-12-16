package controller.promociones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PromocionService;

@WebServlet("/promociones/delete.do")
public class DeletePromocionServlet extends HttpServlet {

	private static final long serialVersionUID = -3023326053838554752L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_promocion = Integer.parseInt(req.getParameter("id_promocion"));

		promocionService.delete(id_promocion);

		resp.sendRedirect("/TurismoTMTP3/promociones/listadoPromociones.do");
	}


}
