package persistence;

import java.util.ArrayList;

import model.Atraccion;
import model.Itinerario;
import model.Oferta;
import model.Promocion;
import persistence.commons.GenericDAO;


public interface ItinerarioDAO extends GenericDAO<Itinerario>{

	ArrayList<Oferta> findItinerarioPorUsuario(int id_usuario);
	
	public abstract int insertPromocion(int id_usuario, Promocion unaPromocion);
	
	public abstract int insertAtraccion(int id_usuario, Atraccion unaAtraccion);


}
