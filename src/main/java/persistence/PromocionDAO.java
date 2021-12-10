package persistence;

import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {

	public abstract Promocion find(Integer id_promocion);

	public abstract Promocion findPorNombre(String nombre);

	public abstract ArrayList<Promocion> findAll();

	public abstract int insert(Promocion promocion);

	public abstract int update(Promocion promocion);

	public abstract int delete(Promocion promocion);

	public abstract ArrayList<Atraccion> listarAtraccionesIncluidas(Integer idPromocion);

	public abstract int insertAtraccionIncluida(Promocion promocion, Integer idAtraccion);
}
