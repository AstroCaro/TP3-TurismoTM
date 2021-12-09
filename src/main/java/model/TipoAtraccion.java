package model;

import java.util.Objects;

public class TipoAtraccion {
	public Integer idTipoAtraccion;
	public String tipoAtraccion;

	public TipoAtraccion(Integer idTipoAtraccion, String tipoAtraccion) {
		this.idTipoAtraccion = idTipoAtraccion;
		this.tipoAtraccion = tipoAtraccion;
	}

	public Integer getIdTipoAtraccion() {
		return idTipoAtraccion;
	}

	public void setIdTipoAtraccion(Integer idTipoAtraccion) {
		this.idTipoAtraccion = idTipoAtraccion;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipo_atraccion(String tipo_atraccion) {
		this.tipoAtraccion = tipo_atraccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipoAtraccion, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAtraccion other = (TipoAtraccion) obj;
		return Objects.equals(idTipoAtraccion, other.idTipoAtraccion)
				&& Objects.equals(tipoAtraccion, other.tipoAtraccion);
	}

}
