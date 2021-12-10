package services;

import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.TipoAtraccionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {

	public ArrayList<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion create(String nombre, String descripcion, String tipoPromocion, Integer idTipoAtraccion, Integer costo, Double descuento, Integer idAtraccionGratis, ArrayList<String> nombreAtracciones) {

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tipoAtraccion = tipoAtraccionDAO.find(idTipoAtraccion);
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
		
		for(String nombreAtraccion: nombreAtracciones) {
			atraccionesIncluidas.add(atraccionDAO.findPorNombre(nombreAtraccion));
		}
		
		Promocion promocion = null ;
		
		switch (tipoPromocion) {
			case "Promocion Absoluta":
				promocion = new PromocionAbsoluta(-1, nombre, descripcion, tipoAtraccion, costo, atraccionesIncluidas);
				break;
			case "Promocion AxB":
				promocion = new PromocionAxB(-1, nombre, descripcion, tipoAtraccion, atraccionesIncluidas);
				break;
			case "Promocion Porcentual":
				promocion = new PromocionPorcentual(-1, nombre, descripcion, tipoAtraccion, descuento, atraccionesIncluidas);
				break;
		}
		
		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
		}

		return promocion;
	}

	public Promocion updateCupo(Promocion unaPromocion) {

		ArrayList<Atraccion> atraccionesIncluidas = unaPromocion.getAtracciones();

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

		for (Atraccion atraccion : atraccionesIncluidas) {
			if (atraccion.isValid()) {
				atraccionDAO.updateCupo(atraccion);
			}
		}
		return unaPromocion;
	}

	public void find(Promocion promocion) {
		
		
	}

	public Promocion buscar(Integer id) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.find(id);

		
	}
}
