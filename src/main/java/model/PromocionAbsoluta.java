package model;

import java.util.ArrayList;
import java.util.HashMap;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(int id_promocion, String nombre, String descripcion, TipoAtraccion tipoAtraccion,
			int costo, ArrayList<Atraccion> atracciones) {
		super(id_promocion, nombre, descripcion, tipoAtraccion, atracciones);
		this.costo = costo;
	}

	@Override
	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	@Override
	public void validate() {
		errors = new HashMap<String, String>();
		if (costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
	}

	@Override
	public String toString() {
		return "" + nombre + " contiene las siguientes atracciones de tipo " + "[" + tipoAtraccion + "]:" + "\n\t"
				+ this.getNombreAtracciones() + "\n\tSu costo total es de " + this.getCosto() + " monedas de oro"
				+ "\n\tEl tiempo total necesario es de " + this.getTiempo() + " Hs.\n";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}