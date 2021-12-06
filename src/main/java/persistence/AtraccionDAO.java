package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	public abstract int updateCupo(Atraccion t);

	public abstract Atraccion findAtraccionPorNombre(String nombreAtraccion);
	
	public abstract Atraccion find(Integer id_atraccion);

	int update(Atraccion atraccion);

	Integer getIdTipoAtraccion(String tipoAtraccion);

	int insert(Atraccion atraccion);

	int delete(Atraccion atraccion);
}
