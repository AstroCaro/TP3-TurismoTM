package services;

import java.util.ArrayList;
import java.util.Collections;

import model.Atraccion;
import model.ComparadorDeOfertas;
import model.Oferta;
import model.Promocion;
import persistence.commons.DAOFactory;

public class OfertaService {
	public ArrayList<Oferta> listarOrdenado(String preferencia) {
		ArrayList<Atraccion> atracciones = DAOFactory.getAtraccionDAO().findAll();
		ArrayList<Promocion> promociones = DAOFactory.getPromocionDAO().findAll(atracciones);
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		ofertas.addAll(atracciones);
		ofertas.addAll(promociones);
		ordenarOfertas(ofertas, preferencia);
		return ofertas;
	}

	public void ordenarOfertas(ArrayList<Oferta> ofertas, String preferencia) {
		Collections.sort(ofertas, new ComparadorDeOfertas(preferencia));
	}
}
