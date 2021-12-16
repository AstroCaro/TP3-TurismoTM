package persistence;

import model.TipoAtraccion;
import persistence.commons.GenericDAO;

public interface TipoAtraccionDAO extends GenericDAO<TipoAtraccion> {

	public abstract Integer getIdTipoAtraccion(String tipoAtraccion);

	public abstract TipoAtraccion find(Integer id_tipoatraccion);

	public abstract int insert(TipoAtraccion tipoDeAtraccion);

}
