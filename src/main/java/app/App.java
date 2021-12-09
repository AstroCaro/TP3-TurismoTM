package app;

import java.util.ArrayList;

import model.Atraccion;
import model.Promocion;
import model.PromocionAxB;
import model.TipoAtraccion;
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
    	
    	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
    	
    	TipoAtraccion aventura = new TipoAtraccion(1, "AVENTURA");
    	
    	Atraccion moria = new Atraccion(1, "Moria", "", 10, 2.0, 6, aventura);
		Atraccion bosqueNegro = new Atraccion(2, "Bosque Negro", "", 3, 4.0, 12, aventura);
    	
    	atracciones.add(moria);
    	atracciones.add(bosqueNegro);
    	
    	Promocion promocion = new PromocionAxB(1, "promo", "", aventura,atracciones);
    	
		String tipoPromocion = promocion.getClass().getSimpleName();
		
		System.out.println(promocion.getClass().toString().toUpperCase());
			
		switch (tipoPromocion) {
		case "PromocionAxB": {
			System.out.println("hola");
		}
		}
		System.out.println(tipoPromocion.equals("PromocionAxB"));
    	
	}
}
