package services;

import java.util.ArrayList;

import model.Oferta;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	public ArrayList<Oferta> buscarPorUsuario(int id_usuario) {
		return DAOFactory.getItinerarioDAO().findItinerarioPorUsuario(id_usuario);
	}

}
