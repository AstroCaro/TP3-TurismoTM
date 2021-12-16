package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PromocionAxB extends Promocion {

	public Atraccion atraccionGratis;

	public PromocionAxB(int id_promocion, String nombre, String descripcion, TipoAtraccion tipoAtraccion,
			ArrayList<Atraccion> atracciones, Atraccion atraccionGratis) {
		super(id_promocion, nombre, descripcion, tipoAtraccion, atracciones);
		this.atraccionGratis = atraccionGratis;
	}

	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	public void setAtraccionGratis(Atraccion atraccionGratis) {
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public int getCosto() {
		costo = 0;
		for (int i = 0; i < atracciones.size(); i++) {
			costo += atracciones.get(i).getCosto();
		}
		costo -= this.atraccionGratis.getCosto();
		return costo;
	}

	@Override
	public String toString() {
		return "" + this.nombre + " contiene las siguientes atracciones de tipo" + "[" + tipoAtraccion + "]:" + "\n\t"
				+ this.getNombreAtracciones() + "\n\tSu precio total es de " + this.getCosto() + " monedas de oro."
				+ "\n\t Siendo la atracción gratis:\n\t" + this.atraccionGratis.getNombre() + "\n\tTiempo Total es de "
				+ this.getTiempo() + "hs.\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(atraccionGratis);
		return result;
	}

	@Override
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	@Override
	public void validate() {
		errors = new HashMap<String, String>();
		if (atraccionGratis == null) {
			errors.put("atraccionGratis", "Debe ingresar una atraccion");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionAxB other = (PromocionAxB) obj;
		return Objects.equals(atraccionGratis, other.atraccionGratis);
	}
}