package model;

public class Compra {
	private Integer usuario;
	private Integer atraccion;
	private Integer promocion;
	private Integer costo;
	private Double tiempo;

	public Compra(Integer usuario, Integer atraccion, Integer promocion, Integer costo, Double tiempo) {
		this.usuario = usuario;
		this.atraccion = atraccion;
		this.promocion = promocion;
		this.costo = costo;
		this.tiempo = tiempo;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getAtraccion() {
		return atraccion;
	}

	public void setAtraccion(Integer atraccion) {
		this.atraccion = atraccion;
	}

	public Integer getPromocion() {
		return promocion;
	}

	public void setPromocion(Integer promocion) {
		this.promocion = promocion;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}

}
