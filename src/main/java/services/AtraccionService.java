package services;

import java.util.ArrayList;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {
	public ArrayList<Atraccion> listar(){
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, Integer costo, Double tiempo, Integer cuposDisponibles, String tipoAtraccion) {

		Atraccion atraccion = new Atraccion (-1, nombre, costo, tiempo, cuposDisponibles, tipoAtraccion);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion update(int id, String nombre, int costo, double tiempo, int cuposDisponibles, String tipoAtraccion) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempo(tiempo);
		atraccion.setCuposDisponibles(cuposDisponibles);
		atraccion.setTipoAtraccion(tipoAtraccion);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(id, "", 0, 0, 0, null);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion buscar(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.find(id);
	}
}
