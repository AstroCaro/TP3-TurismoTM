package services;

import java.util.ArrayList;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {
	public ArrayList<Usuario> listar(){
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, String preferencia, int presupuesto, double tiempo, boolean admin) {

		Usuario usuario = new Usuario (-1, nombre, preferencia, presupuesto, tiempo, admin);

		if (usuario.isValid()) {
			UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
			usuarioDAO.insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public Usuario update(int id_usuario, String nombre, String preferencia, int presupuesto, double tiempo, boolean admin) {

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id_usuario);

		usuario.setNombre(nombre);
		usuario.setPreferencia(preferencia);
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
		Usuario usuario = new Usuario(id, "", "", 0, 0, false);

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.delete(usuario);
	}

	public Usuario buscar(Integer id) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		return usuarioDAO.find(id);
	}
}
