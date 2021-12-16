package services;

import java.util.ArrayList;

import model.Itinerario;
import model.Oferta;
import model.TipoAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {
	public ArrayList<Usuario> listar() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, String password, Integer preferencia, int presupuesto, double tiempo,
			boolean admin, String deleted_at) {

		TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(preferencia);

		Usuario usuario = new Usuario(nombre, password, tipoAtraccion, presupuesto, tiempo, admin, deleted_at);

		if (usuario.isValid()) {
			UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
			usuarioDAO.insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public Usuario update(int id_usuario, String nombre, String password, Integer preferencia, int presupuesto,
			double tiempo, boolean admin) {

		TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(preferencia);

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id_usuario);

		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setPreferencia(tipoAtraccion);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempo_disponible(tiempo);
		usuario.setAdmin(admin);

		if (usuario.isValid()) {
			usuarioDAO.update(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public void delete(Integer id) {
		Usuario usuario = new Usuario(id, "", "", null, 0, 0, false,"");

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.softDelete(usuario);
	}

	public Usuario buscar(Integer id) {

		Usuario usuario = DAOFactory.getUsuarioDAO().find(id);
		ArrayList<Oferta> itinerario = DAOFactory.getItinerarioDAO().findItinerarioPorUsuario(id);
		usuario.setItinerario(new Itinerario(itinerario));
		return usuario;
	}
	
	public Usuario buscarPorNombre(String nombre) {
		Usuario usuario = DAOFactory.getUsuarioDAO().findPorNombre(nombre);
		return usuario;
	}

	public Usuario update(Usuario unUsuario) {

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(unUsuario.getId_usuario());

		usuario.setNombre(unUsuario.getNombre());
		usuario.setPassword(unUsuario.getPassword());
		usuario.setPreferencia(unUsuario.getPreferencia());
		usuario.setPresupuesto(unUsuario.getPresupuesto());
		usuario.setTiempo_disponible(unUsuario.getTiempo_disponible());
		usuario.setAdmin(unUsuario.getAdmin());

		if (usuario.isValid()) {
			usuarioDAO.update(usuario);
		}

		return usuario;

	}

}
