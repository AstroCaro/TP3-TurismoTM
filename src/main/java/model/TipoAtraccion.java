package model;

public class TipoAtraccion {
	public Integer id_tipoatraccion;
	public String tipo_atraccion;
	
	public TipoAtraccion(Integer id_tipoatraccion, String tipo_atraccion) {
		this.id_tipoatraccion = id_tipoatraccion;
		this.tipo_atraccion = tipo_atraccion;
	}

	public Integer getId_tipoatraccion() {
		return id_tipoatraccion;
	}

	public void setId_tipoatraccion(Integer id_tipoatraccion) {
		this.id_tipoatraccion = id_tipoatraccion;
	}

	public String getTipo_atraccion() {
		return tipo_atraccion;
	}

	public void setTipo_atraccion(String tipo_atraccion) {
		this.tipo_atraccion = tipo_atraccion;
	}
}
