package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

@WebServlet("/mostrar-atraccion")

public class VerAtraccionServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8348190042470480487L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id_atraccion = req.getParameter("boton");
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.findAtraccionPorId(Integer.parseInt(id_atraccion));
		req.setAttribute("atraccion", atraccion);
		RequestDispatcher dispatcher = req/*getServletContext()*/.getRequestDispatcher("/views/verAtraccion.jsp");
		dispatcher.forward(req, resp);
		//resp.sendRedirect("verAtraccion.jsp");
	}

}