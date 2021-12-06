package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Atraccion extends Oferta {

	private int id_atraccion;
	private int costo;
	private int cuposDisponibles;
	
	private Map<String, String> errors;

	public Atraccion(int id_atraccion, String nombre, int costo, double tiempo, int cuposDisponibles, String tipoAtraccion) {
		super(nombre, tipoAtraccion);
		this.costo = costo;
		this.tiempo = tiempo;
		this.cuposDisponibles = cuposDisponibles;
		this.id_atraccion = id_atraccion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void venderCupo() {
		this.cuposDisponibles--;
	}

	public int getCuposDisponibles() {
		return cuposDisponibles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cuposDisponibles, id_atraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cuposDisponibles == other.cuposDisponibles && id_atraccion == other.id_atraccion;
	}

	public int getId_atraccion() {
		return id_atraccion;
	}

	@Override
	public String toString() {
		return "\nAtraccion: " + nombre + "\nCosto: " + costo + "\nDuración: " + tiempo + "\nTipo: " + tipoAtraccion
				+ "\nCupos Disponibles: " + cuposDisponibles;
	}
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
		if (cuposDisponibles <= 0) {
			errors.put("cuposDisponibles", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
}