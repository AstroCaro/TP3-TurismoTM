package services;

import model.Usuario;
import model.nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String nombre, String password) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
    	Usuario user = usuarioDAO.findPorNombre(nombre);
    
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUsuario.build();
    	}
    	return user;
	}
	
}
