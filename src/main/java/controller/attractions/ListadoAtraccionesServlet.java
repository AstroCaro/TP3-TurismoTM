package controller.attractions;

import java.io.IOException;
import java.util.ArrayList;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")

public class ListadoAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7252040525286394631L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		ArrayList<Atraccion> atracciones = atraccionDAO.findAll();
		
		req.setAttribute("atracciones", atracciones);	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/listadoAtracciones.jsp");
		dispatcher.forward(req, resp);
		
		//resp.sendRedirect("views/listadoAtracciones.jsp"); //getServletContext()
		
		/*RequestDispatcher dispatcher = req.getRequestDispatcher("/listadoAtracciones.jsp");
		dispatcher.forward(req, resp);*/
		
		//req.getRequestDispatcher("listadoAtracciones.jsp").forward(req, resp);
		}
        catch(Exception e){
        	req.setAttribute("flash", "error 333");
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/botonAtracciones.jsp");
    		dispatcher.forward(req, resp);
        }
	}
}