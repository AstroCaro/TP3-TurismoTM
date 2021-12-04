package persistence;

import java.util.ArrayList;

import model.Atraccion;
import model.Itinerario;
import model.Oferta;
import model.Promocion;
import persistence.commons.GenericDAO;


public interface ItinerarioDAO extends GenericDAO<Itinerario>{

	ArrayList<Oferta> findItinerarioPorCliente(int id_cliente);
	
	public abstract int insertPromocion(int id_cliente, Promocion unaPromocion);
	
	public abstract int insertAtraccion(int id_cliente, Atraccion unaAtraccion);


}
