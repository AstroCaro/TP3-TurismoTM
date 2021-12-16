package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TipoAtraccion;
import persistence.TipoAtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TipoAtraccionDAOImpl implements TipoAtraccionDAO {

	@Override
	public ArrayList<TipoAtraccion> findAll() {
		try {
			String sql = "SELECT id_tipoatraccion, tipo_atraccion FROM \"tipo atraccion\";";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<TipoAtraccion> tipos_atraccion = new ArrayList<TipoAtraccion>();
			while (resultados.next()) {
				tipos_atraccion.add(toTipoAtraccion(resultados));
			}

			return tipos_atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer getIdTipoAtraccion(String tipoAtraccion) {
		try {
			String sql = "SELECT id_tipoatraccion " + "FROM \"tipo atraccion\" " + "WHERE tipo_atraccion LIKE ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tipoAtraccion);
			ResultSet resultado = statement.executeQuery();

			Integer id_tipoatraccion = null;
			if (resultado.next()) {
				id_tipoatraccion = resultado.getInt("id_tipoatraccion");
			}

			return id_tipoatraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public TipoAtraccion find(Integer id_tipoatraccion) {
		try {
			String sql = "SELECT * FROM \"tipo atraccion\" WHERE id_tipoatraccion = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id_tipoatraccion);
			ResultSet resultado = statement.executeQuery();

			TipoAtraccion tipoAtraccion = null;
			if (resultado.next()) {
				tipoAtraccion = toTipoAtraccion(resultado);
			}

			return tipoAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private TipoAtraccion toTipoAtraccion(ResultSet resultados) {
		try {
			return new TipoAtraccion(resultados.getInt("id_tipoatraccion"), resultados.getString("tipo_atraccion"));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(TipoAtraccion tipoDeAtraccion) {
		try {
			String sql = "INSERT INTO tipo atraccion (tipo_atraccion, deleted_at) VALUES (?, ?)";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			statement.setString(1, tipoDeAtraccion.getTipoAtraccion());
			statement.setString(2, tipoDeAtraccion.getDeleted_at());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	

}
