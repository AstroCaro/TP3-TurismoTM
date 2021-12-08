package persistence;

import model.TipoAtraccion;
import persistence.commons.GenericDAO;

public interface TipoAtraccionDAO extends GenericDAO<TipoAtraccion> {

	Integer getIdTipoAtraccion(String tipoAtraccion);

}
