package controller.tipoAtraccion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;

@WebServlet("/tipoAtraccion/delete.do")
public class DeleteAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = -3023326053838554752L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_atraccion = Integer.parseInt(req.getParameter("id_atraccion"));

		atraccionService.delete(id_atraccion);

		resp.sendRedirect("/TurismoTMTP3/atracciones/listadoAtracciones.do");
	}


}
