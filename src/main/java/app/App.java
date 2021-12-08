package app;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;
import utils.Crypt;


public class App {


	public static void main(String[] args) {
		UsuarioDAO clienteDAO = DAOFactory.getUsuarioDAO();
    	Usuario user = clienteDAO.findPorNombre("Eowyn");
    	
    	String password = "Eowyn";
    	String passwordhash = Crypt.hash(password);
    	boolean hash = Crypt.match(password,passwordhash);
    	
    	System.out.println(passwordhash + hash);
    	
	}
}
