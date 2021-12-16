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

	public ArrayList<Promocion> listar() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion create(String nombre, String descripcion, String tipoPromocion, Integer idTipoAtraccion,
			Integer costo, Double descuento, Integer idAtraccionGratis, ArrayList<Integer> idAtracciones) {

		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoAtraccion tipoAtraccion = tipoAtraccionDAO.find(idTipoAtraccion);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();

		for (Integer idAtraccion : idAtracciones) {
			atraccionesIncluidas.add(atraccionDAO.find(idAtraccion));
		}
		System.out.println(nombre + " " + descripcion + " " + tipoPromocion + " " + idTipoAtraccion + " " + costo + " "
				+ descuento + " " + idAtraccionGratis + " " + atraccionesIncluidas);

		Promocion promocion = null;

		switch (tipoPromocion) {
		case "PromocionAbsoluta":
			promocion = new PromocionAbsoluta(-1, nombre, descripcion, tipoAtraccion, costo, atraccionesIncluidas);
			break;
		case "PromocionAxB":

			Atraccion atraccionGratis = atraccionDAO.find(idAtraccionGratis);

			System.out.println(nombre + " " + descripcion + " " + tipoPromocion + " " + tipoAtraccion + " " + costo
					+ " " + descuento + " " + atraccionGratis + " " + atraccionesIncluidas + " "
					+ atraccionGratis.getCosto());

			promocion = new PromocionAxB(-1, nombre, descripcion, tipoAtraccion, atraccionesIncluidas, atraccionGratis);
			break;
		case "PromocionPorcentual":
			promocion = new PromocionPorcentual(-1, nombre, descripcion, tipoAtraccion, descuento,
					atraccionesIncluidas);
			break;
		}

		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocion = promocionDAO.insert(promocion);
			for (Atraccion atraccion : atraccionesIncluidas) {
				promocionDAO.insertAtraccionIncluida(promocion, atraccion);
			}
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

	public void delete(Integer id) {
		Promocion promocion = new PromocionAbsoluta(id, "", "", null, 0, null);

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.softDelete(promocion);
	}

	public Promocion update(Integer id_promocion, String nombre, String descripcion, Integer idTipoAtraccion) {

		TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(idTipoAtraccion);

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.find(id_promocion);

		promocion.setNombre(nombre);
		promocion.setDescripcion(descripcion);
		promocion.setTipoAtraccion(tipoAtraccion);

		if (promocion.isValid()) {
			promocionDAO.update(promocion);
		}

		return promocion;
	}
}
