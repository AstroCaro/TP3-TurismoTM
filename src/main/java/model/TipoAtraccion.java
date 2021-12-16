package model;

import java.util.Objects;

public class TipoAtraccion {
	public Integer idTipoAtraccion;
	public String tipoAtraccion;
	public String deleted_at;

	public TipoAtraccion(Integer idTipoAtraccion, String tipoAtraccion) {
		this.idTipoAtraccion = idTipoAtraccion;
		this.tipoAtraccion = tipoAtraccion;
		
	}
	public TipoAtraccion(String tipoAtraccion) {
		this.idTipoAtraccion = null;
		this.tipoAtraccion = tipoAtraccion;
	
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
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
	public boolean isValid() {
		String errors = null;
		return errors.isEmpty();
	}
	

}
