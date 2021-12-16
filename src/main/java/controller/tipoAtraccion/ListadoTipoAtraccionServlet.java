package controller.tipoAtraccion;

import java.io.IOException;
import java.util.ArrayList;

import model.Atraccion;
import model.TipoAtraccion;
import services.AtraccionService;
import services.TipoAtraccionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tipoAtraccion/listadoTipoAtraccion.do")

public class ListadoTipoAtraccionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7252040525286394631L;

	private TipoAtraccionService tipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoAtraccionService = new TipoAtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<TipoAtraccion> tipoAtraccion = tipoAtraccionService.listar();		
		req.setAttribute("tipoAtraccion", tipoAtraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/tipoAtraccion/listadoTipoAtraccion.jsp");
		dispatcher.forward(req, resp);
	}
}