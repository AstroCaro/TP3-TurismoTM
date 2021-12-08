package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utils.Crypt;

public class Usuario {
	protected Integer id_usuario;
	protected String nombre;
	private String password;
	protected String preferencia;
	protected int presupuesto;
	protected double tiempo_disponible;
	protected boolean admin;
	protected Itinerario itinerario;

	private Map<String, String> errors;
	
	public Usuario(Integer id_usuario, String nombre, String preferencia, int presupuesto, double tiempo,
			boolean admin) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo;
		this.admin = admin;
		this.itinerario = new Itinerario();
	}

	public Usuario(Integer id_usuario, String nombre, String password, String preferencia, int presupuesto, double tiempo,
			boolean admin) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo;
		this.admin = admin;
		this.itinerario = new Itinerario();
	}

	public Usuario(String nombre, String password, String preferencia, int presupuesto, double tiempo, boolean admin) {
		this.id_usuario = null;
		this.nombre = nombre;
		this.password = Crypt.hash(password);
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempo_disponible = tiempo;
		this.admin = admin;
		this.itinerario = new Itinerario();
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo_disponible() {
		return tiempo_disponible;
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

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempo_disponible(double tiempo_disponible) {
		this.tiempo_disponible = tiempo_disponible;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void comprarOferta(Oferta unaOferta) {
		descontarOroYTiempo(unaOferta);
		this.itinerario.agregarAlItinerario(unaOferta);
	}

	private void descontarOroYTiempo(Oferta unaOferta) {
		this.presupuesto -= unaOferta.getCosto();
		this.tiempo_disponible -= unaOferta.getTiempo();
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
		if (tiempo_disponible <= 0) {
			errors.put("tiempo_disponible", "Debe ser positivo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario, nombre, preferencia, presupuesto, tiempo_disponible);
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
		return id_usuario == other.id_usuario && Objects.equals(nombre, other.nombre)
				&& Objects.equals(preferencia, other.preferencia) && presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempo_disponible) == Double.doubleToLongBits(other.tiempo_disponible);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempo=" + tiempo_disponible + "]\n";
	}

	//XXX ELIMINAR!!!!
	public boolean responderPregunta() throws IOException {

		String laRespuesta = null;
		boolean r = false;

		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);

		laRespuesta = br.readLine();
		laRespuesta = laRespuesta.toLowerCase();

		int intentos = 3;
		int ans = -1;

		while (intentos >= 1 && ans == -1) {
			if (laRespuesta.equals("si") || laRespuesta.equals("s")) {
				ans = 1;
				r = true;
			} else if (laRespuesta.equals("no") || laRespuesta.equals("n")) {
				ans = 0;
				r = false;
			} else if (intentos > 1) {
				System.out.println(
						".. la respuesta ingresada es incorrecta, debe contestar con 'Si' o 'No' (intentos restantes "
								+ (intentos - 1) + ")");
				laRespuesta = br.readLine();
				laRespuesta = laRespuesta.toLowerCase();
			} else {
				System.out.println(".. intentos agotados, la oferta se rechazara automaticamente .. ");
				ans = 0;
				r = false;
			}
			intentos--;
		}
		return r;
	}
}