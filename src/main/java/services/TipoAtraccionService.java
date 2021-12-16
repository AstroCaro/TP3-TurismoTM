package services;

import java.util.ArrayList;

import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.TipoAtraccionDAO;
import persistence.commons.DAOFactory;

public class TipoAtraccionService {
	public ArrayList<TipoAtraccion> listar() {
		return DAOFactory.getTipoAtraccionDAO().findAll();
	}

	public TipoAtraccion create(String tipoAtraccion, String deleted_at) {
		

		TipoAtraccion tipoDeAtraccion = new TipoAtraccion(tipoAtraccion, deleted_at);

			TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
			tipoAtraccionDAO.insert(tipoDeAtraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		

		return tipoDeAtraccion;
	}

	public Atraccion update(int id, String nombre, String descripcion, int costo, double tiempo, int cuposDisponibles,
			Integer idTipoAtraccion) {
		
		TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(idTipoAtraccion);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setDescripcion(descripcion);
		atraccion.setCosto(costo);
		atraccion.setTiempo(tiempo);
		atraccion.setCuposDisponibles(cuposDisponibles);
		atraccion.setTipoAtraccion(tipoAtraccion);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
		}

		return atraccion;
	}
	
	public Atraccion updateCupo(Atraccion unaAtraccion) {
		
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

		if (unaAtraccion.isValid()) {
			atraccionDAO.updateCupo(unaAtraccion);
		}
		return unaAtraccion;
	}
	

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(id, "", "", 0, 0, 0, null,"");
	

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.softDelete(atraccion);
	}

	public Atraccion buscar(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.find(id);
	}

}
