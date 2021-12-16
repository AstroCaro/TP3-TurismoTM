package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import persistence.commons.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public Promocion find(Integer id_promocion) {
		try {
			String sql = "SELECT id_promocion, nombre, descripcion, tipo_promocion, fk_tipoatraccion, costo, descuento, atraccion_gratis "
					+ "FROM promociones "
					+ "JOIN \"tipo promocion\" ON \"tipo promocion\".id_tipopromocion = promociones.fk_tipopromocion "
					+ "WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id_promocion);
			ResultSet resultado = statement.executeQuery();

			Promocion promocion = null;
			if (resultado.next()) {
				promocion = toPromocion(resultado);
			}
			return promocion;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Promocion findPorNombre(String nombre) {

		try {
			String sql = "SELECT id_promocion, nombre, descripcion, tipo_promocion, fk_tipoatraccion, costo, descuento, atraccion_gratis "
					+ "FROM promociones "
					+ "JOIN \"tipo promocion\" ON \"tipo promocion\".id_tipopromocion = promociones.fk_tipopromocion "
					+ "WHERE nombre = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion(resultados);
			}
			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ArrayList<Promocion> findAll() {
		try {
			String sql = "SELECT id_promocion, nombre, descripcion, tipo_promocion, \"fk_tipoatraccion\", costo, descuento, atraccion_gratis "
					+ "FROM promociones "
					+ "JOIN \"tipo promocion\" ON \"tipo promocion\".id_tipopromocion = promociones.fk_tipopromocion;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Promocion> promociones = new ArrayList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados));
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promocion promocion) {
		try {
			String sql = "INSERT INTO promociones (nombre, descripcion, fk_promocion, fk_tipoatraccion, costo, descuento, atraccion_gratis) VALUES (?, ?, ?, ?, ?, ?, ?)";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			String tipoPromocion = promocion.getClass().getSimpleName();

			statement.setString(1, promocion.getNombre());
			statement.setString(2, promocion.getDescripcion());
			statement.setInt(4, promocion.getTipoAtraccion().getIdTipoAtraccion());

			switch (tipoPromocion) {
			case "PromocionAbsoluta":
				statement.setInt(3, 1);
				statement.setDouble(5, promocion.getCosto());
				break;
			case "PromocionAxB":
				PromocionAxB promocionAxB = (PromocionAxB) promocion; 
				statement.setInt(3, 2);
				// XXX hacer metodo en promocion axb que devuelva atraccion gratis
				statement.setInt(7,
						promocionAxB.getAtraccionGratis().getId_atraccion());
				break;
			case "PromocionPorcentual":
				PromocionPorcentual promocionPorcentual = (PromocionPorcentual) promocion;
				statement.setInt(3, 3);
				statement.setDouble(6, promocionPorcentual.getDescuento());
				break;
			}
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insertAtraccionIncluida(Promocion promocion, Integer idAtraccion) {
		try {
			String sql = "INSERT INTO promociones-atracciones VALUES (?, ?)";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, promocion.getId_promocion());

			statement.setInt(2, idAtraccion);

			int rows = statement.executeUpdate();
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Promocion promocion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion promocion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Atraccion> listarAtraccionesIncluidas(Integer idPromocion) {
		try {
			ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			String sql = "SELECT fk_atraccion FROM \"promocion-atraccion\" WHERE fk_promocion = ?;";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idPromocion);
			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				atraccionesIncluidas.add(atraccionDAO.find(resultados.getInt("fk_atraccion")));
			}
			return atraccionesIncluidas;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados) {
		try {

			Promocion unaPromocion = null;
			ArrayList<Atraccion> arrayDeAtracciones = listarAtraccionesIncluidas(resultados.getInt("id_promocion"));
			TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(resultados.getInt("fk_tipoatraccion"));
			String tipoPromocion = resultados.getString("tipo_promocion");

			switch (tipoPromocion) {
			case "ABSOLUTA":
				unaPromocion = new PromocionAbsoluta(resultados.getInt("id_promocion"), resultados.getString("nombre"),
						resultados.getString("descripcion"), tipoAtraccion, resultados.getInt("costo"),
						arrayDeAtracciones);
				break;
			case "PORCENTUAL":
				unaPromocion = new PromocionPorcentual(resultados.getInt("id_promocion"),
						resultados.getString("nombre"), resultados.getString("descripcion"), tipoAtraccion,
						resultados.getDouble("descuento"), arrayDeAtracciones);
				break;
			case "AxB":
				Atraccion atraccionGratis = DAOFactory.getAtraccionDAO().find(resultados.getInt("atraccion_gratis"));
				unaPromocion = new PromocionAxB(resultados.getInt("id_promocion"), resultados.getString("nombre"),
						resultados.getString("descripcion"), tipoAtraccion, arrayDeAtracciones, atraccionGratis);
				break;
			}
			return unaPromocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int softDelete(Promocion promocion) {

		try {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			String sql = "UPDATE promociones SET deleted_at = ? WHERE id_promocion = ?;";

			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, date.format(formatter));
			statement.setInt(2, promocion.getId_promocion());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
