package model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Promocion extends Oferta {
	protected int id_promocion;

	protected int costo;
	protected double tiempoTotal;
	protected int cuposDisponibles;
	public ArrayList<Atraccion> atracciones;

	public Promocion(int id_promocion, String nombre, String descripcion, TipoAtraccion tipoAtraccion,
			ArrayList<Atraccion> atracciones) {
		super(nombre, descripcion, tipoAtraccion);
		this.id_promocion = id_promocion;
		this.atracciones = atracciones;
	}

	public int getId_promocion() {
		return id_promocion;
	}

	public double getTiempo() {
		tiempoTotal = 0;
		for (Atraccion unaAtraccion : atracciones) {
			tiempoTotal += unaAtraccion.getTiempo();
		}
		return tiempoTotal;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public String getClase() {
		return "PROMOCION";
	}

	public ArrayList<String> getNombreAtracciones() {
		ArrayList<String> nombreAtracciones = new ArrayList<String>();
		for (Atraccion unaAtraccion : atracciones) {
			nombreAtracciones.add(unaAtraccion.getNombre());
		}
		return nombreAtracciones;
	}

	public void venderCupo() {
		for (Atraccion unaAtraccion : atracciones) {
			if (unaAtraccion.getCuposDisponibles() > 0)
				unaAtraccion.venderCupo();
		}
	}

	public int getCuposDisponibles() {
		int cupoDisponible = 9999;
		for (Atraccion unaAtraccion : atracciones) {
			if (unaAtraccion.getCuposDisponibles() < cupoDisponible) {
				cupoDisponible = unaAtraccion.getCuposDisponibles();
			}
		}
		return cupoDisponible;
	}

	public Boolean tieneCupo() {
		return this.cuposDisponibles >= 1;
	}
	
	public abstract boolean isValid();
	
	public abstract int getCosto();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(atracciones, costo, cuposDisponibles, id_promocion, tiempoTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atracciones, other.atracciones) && costo == other.costo
				&& cuposDisponibles == other.cuposDisponibles && id_promocion == other.id_promocion
				&& Double.doubleToLongBits(tiempoTotal) == Double.doubleToLongBits(other.tiempoTotal);
	}

	

}