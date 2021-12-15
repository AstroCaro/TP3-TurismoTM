package services;

import model.Usuario;
import model.nullobjects.NullUsuario;

public class LoginService {

	public Usuario login(String nombre, String password) {
		UsuarioService usuarioService = new UsuarioService();
    	Usuario user = usuarioService.buscarPorNombre(nombre);
    
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUsuario.build();
    	}
    	return user;
	}
	
}
