package persistence;

import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Promocion> {


	public abstract Promocion findPromocionPorNombre(String nombrePromocion, ArrayList<Atraccion> atracciones);

	public abstract ArrayList<Promocion> findAll(ArrayList<Atraccion> atracciones);

	public abstract ArrayList<Atraccion> listarAtraccionesIncluidas(String nombrePromo, ArrayList<Atraccion> atracciones);

}
