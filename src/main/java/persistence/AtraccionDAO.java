package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	//XXX se sigue utilizando el findByName?
	
	public abstract Atraccion findPorNombre(String nombreAtraccion);

	public abstract Atraccion find(Integer id_atraccion);

	public abstract int updateCupo(Atraccion t);
	
	public int insert(Atraccion atraccion);
	
	public int update(Atraccion atraccion);

	public int delete(Atraccion atraccion);
}
