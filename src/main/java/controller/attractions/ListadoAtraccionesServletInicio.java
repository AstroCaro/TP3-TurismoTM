package controller.attractions;

import java.io.IOException;
import java.util.ArrayList;

import model.Atraccion;
import services.AtraccionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/atracciones/listadoAtraccionesInicio.do")

public class ListadoAtraccionesServletInicio extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 8592293829771286800L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Atraccion> atracciones = atraccionService.listar();		
		req.setAttribute("atracciones", atracciones);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/listadoAtraccionesInicio.jsp");
		dispatcher.forward(req, resp);
	}
}