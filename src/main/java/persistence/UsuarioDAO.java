package persistence;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public abstract int delete(Usuario usuario);

	public abstract int insert(Usuario usuario);

	public abstract int update(Usuario t);

	public abstract Usuario find(int id_usuario);
	
	public abstract Usuario findPorNombre(String nombre);

	public abstract int softDelete(Usuario usuario);


}
