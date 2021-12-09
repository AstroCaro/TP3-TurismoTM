package persistence;

import jakarta.servlet.Servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import services.ComprarOfertaService;
import services.OfertaService;

@WebServlet("/oferta/buy.do")
public class ComprarOfertaServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3075455134538602518L;

	ComprarOfertaService comprarService;
	OfertaService ofertaService;
	
	
}
