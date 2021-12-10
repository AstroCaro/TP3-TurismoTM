package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utils.Crypt;

public class Usuario {
	protected Integer id_usuario;
	protected String nombre;
	private String password;
	protected TipoAtraccion preferencia;
	protected int presupuesto;
	protected double tiempoDisponible;
	protected boolean admin;
	protected Itinerario itinerario;

	private Map<String, String> errors;

	public Usuario(Integer id_usuario, String nombre, String password, TipoAtraccion preferencia, int presupuesto,
			double tiempo, boolean admin) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempo;
		this.admin = admin;
		this.itinerario = new Itinerario();
	}

//	public Usuario(String nombre, String password, String preferencia, int presupuesto, double tiempo, boolean admin) {
//		this.id_usuario = null;
//		this.nombre = nombre;
//		this.password = Crypt.hash(password);
//		this.preferencia = preferencia;
//		this.presupuesto = presupuesto;
//		this.tiempo_disponible = tiempo;
//		this.admin = admin;
//		this.itinerario = new Itinerario();
//	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public TipoAtraccion getPreferencia() {
		return preferencia;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo_disponible() {
		return tiempoDisponible;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempo_disponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void comprarOferta(Oferta unaOferta) {
		descontarOroYTiempo(unaOferta);
		this.itinerario.agregarAlItinerario(unaOferta);
	}

	public boolean puedeComprar(Oferta unaOferta) {
		return presupuesto >= unaOferta.getCosto();
	}
	
	public boolean puedeAsistir(Oferta unaOferta) {
		return tiempoDisponible >= unaOferta.getTiempo();
	}

	public void descontarOroYTiempo(Oferta unaOferta) {
		this.presupuesto -= unaOferta.getCosto();
		this.tiempoDisponible -= unaOferta.getTiempo();
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public boolean isNull() {
		return false;
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto <= 0) {
			errors.put("presupuesto", "Debe ser positivo");
		}
		if (tiempoDisponible <= 0) {
			errors.put("tiempo_disponible", "Debe ser positivo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admin, errors, id_usuario, itinerario, nombre, password, preferencia, presupuesto,
				tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return admin == other.admin && Objects.equals(errors, other.errors)
				&& Objects.equals(id_usuario, other.id_usuario) && Objects.equals(itinerario, other.itinerario)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(preferencia, other.preferencia) && presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempo=" + tiempoDisponible + "]\n";
	}
}