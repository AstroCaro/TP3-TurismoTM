package persistence.commons;

import persistence.AtraccionDAO;
import persistence.ClienteDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.impl.AtraccionDAOImpl;
import persistence.impl.ClienteDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionDAOImpl;

public class DAOFactory {
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}
	
	public static ClienteDAO getClienteDAO() {
		return new ClienteDAOImpl();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
}
