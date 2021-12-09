package persistence;

import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {


	public abstract Promocion findPorNombre(Integer idPromocion, ArrayList<Atraccion> atracciones);

	public abstract ArrayList<Promocion> findAll(ArrayList<Atraccion> atracciones);

	public abstract ArrayList<Atraccion> listarAtraccionesIncluidas(Integer idPromocion, ArrayList<Atraccion> atracciones);

	public abstract int insert(Promocion promocion);
	
	public abstract int update(Promocion promocion);
	
	public abstract int delete(Promocion promocion);

}
