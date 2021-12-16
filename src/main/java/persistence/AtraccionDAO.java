package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	//XXX se sigue utilizando el findByName?
	
	public abstract Atraccion findPorNombre(String nombreAtraccion);

	public abstract Atraccion find(Integer id_atraccion);

	public abstract int updateCupo(Atraccion t);
	
	public abstract int insert(Atraccion atraccion);
	
	public abstract int update(Atraccion atraccion);

	public abstract int delete(Atraccion atraccion);

	public abstract int softDelete(Atraccion atraccion);
}
