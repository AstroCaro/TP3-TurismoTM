package services;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Oferta;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class ComprarOfertaService {

	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Map<String, String> comprar(Usuario usuario, Oferta oferta) {
		// verificaciones
		Map<String, String> errors = new HashMap<String, String>();

		if (!oferta.tieneCupo()) {
			errors.put("oferta", "No hay cupo disponible");
		}
		if (!usuario.puedeComprar(oferta)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.puedeAsistir(oferta)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
			UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

			usuario.descontarOroYTiempo(oferta);
			oferta.venderCupo();
			usuarioDAO.update(usuario);

			if (oferta instanceof Promocion) {
				Promocion promocion = (Promocion) oferta;
				for (Atraccion atraccion : promocion.getAtracciones()) {
					atraccionDAO.updateCupo(atraccion);
				}
				itinerarioDAO.insertPromocion(usuario.getId_usuario(), promocion);
			} else if (oferta instanceof Atraccion) {
				Atraccion atraccion = (Atraccion) oferta;
				atraccionDAO.updateCupo(atraccion);
				itinerarioDAO.insertAtraccion(usuario.getId_usuario(), atraccion);
			}
		}
		return errors;
	}

}
