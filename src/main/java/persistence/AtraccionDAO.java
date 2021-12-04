package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	public abstract int updateCupo(Atraccion t);

	public abstract Atraccion findAtraccionPorNombre(String nombreAtraccion);
	
	public abstract Atraccion findAtraccionPorId(int id_atraccion);
}
