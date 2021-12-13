package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {

	@Override
	public ArrayList<Atraccion> findAll() {
		try {
			String sql = "SELECT * FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int updateCupo(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET cupos_disponibles = ? WHERE id_atraccion = ?;";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getCuposDisponibles());
			statement.setInt(2, atraccion.getId_atraccion());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO atracciones (nombre, costo, tiempo, cupos_disponibles, fk_tipoatraccion) VALUES (?, ?, ?, ?, ?)";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCuposDisponibles());
			statement.setInt(5, atraccion.getTipoAtraccion().getIdTipoAtraccion());
			int rows = statement.executeUpdate();

			ResultSet resultado = statement.getGeneratedKeys();
			if (resultado.next()) {
				int id = resultado.getInt(1);
				atraccion.setId_atraccion(id);
			}

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET nombre = ?, descripcion = ?, costo = ?, tiempo = ?,"
					+ "cupos_disponibles = ?, fk_tipoatraccion = ? WHERE id_atraccion = ?;";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCuposDisponibles());
			statement.setInt(5, atraccion.getTipoAtraccion().getIdTipoAtraccion());
			statement.setInt(6, atraccion.getId_atraccion());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion atraccion) {
		try {
			String sql = "DELETE FROM atracciones WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getId_atraccion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

//BORRAR!!
	@Override
	public Atraccion findPorNombre(String nombreAtraccion) {
		try {
			String sql = "SELECT * FROM atracciones WHERE nombre LIKE ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, nombreAtraccion);
			ResultSet resultado = statement.executeQuery();

			Atraccion atraccion = null;
			if (resultado.next()) {
				atraccion = toAtraccion(resultado);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Atraccion find(Integer id_atraccion) {
		try {
			String sql = "SELECT * FROM atracciones WHERE id_atraccion = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id_atraccion);
			ResultSet resultado = statement.executeQuery();

			Atraccion atraccion = null;
			if (resultado.next()) {
				atraccion = toAtraccion(resultado);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados) {
		try {
			Integer idTipoAtraccion = resultados.getInt("fk_tipoatraccion");
			TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(idTipoAtraccion);
			return new Atraccion(resultados.getInt("id_atraccion"), resultados.getString("nombre"),
					resultados.getString("descripcion"), resultados.getInt("costo"), resultados.getDouble("tiempo"),
					resultados.getInt("cupos_disponibles"), tipoAtraccion);

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
