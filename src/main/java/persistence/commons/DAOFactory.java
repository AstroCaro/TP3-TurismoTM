package persistence.commons;

import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.UsuarioDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionDAOImpl;

public class DAOFactory {
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
}
