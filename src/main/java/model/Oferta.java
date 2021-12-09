package model;

import java.util.Objects;

public abstract class Oferta {
	protected String nombre;
	protected String descripcion;
	protected double tiempo;
	protected TipoAtraccion tipoAtraccion;

	public Oferta(String nombre, String descripcion, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public TipoAtraccion getTipoAtraccion() {
		return this.tipoAtraccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTipoAtraccion(TipoAtraccion tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	protected abstract int getCuposDisponibles();

	public abstract void venderCupo();

	protected abstract int getCosto();

	protected abstract double getTiempo();

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre, tiempo, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipoAtraccion, other.tipoAtraccion);
	}

}