package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones/verAtraccion.do")

public class VerUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8348190042470480487L;
	
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
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/verAtraccion.jsp");
		dispatcher.forward(req, resp);
	}

}