package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public ArrayList<Promocion> findAll(ArrayList<Atraccion> atracciones) {
		try {
			String sql = "SELECT id_promocion, nombre, descripcion, tipo_promocion, \"fk_tipoatraccion\", costo, descuento, atraccion_gratis "
					+ "FROM promociones "
					+ "JOIN \"tipo promocion\" ON \"tipo promocion\".id_tipopromocion = promociones.fk_tipopromocion;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Promocion> promociones = new ArrayList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados, atracciones));
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
				statement.setInt(3, 2);
				// XXX hacer metodo en promocion axb que devuelva la atraccion gratis
				statement.setInt(7,
						promocion.getAtracciones().get(promocion.getAtracciones().size() - 1).getId_atraccion());
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
	public int update(Promocion promocion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion promocion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Promocion findPorNombre(Integer idPromocion, ArrayList<Atraccion> atracciones) {

		try {
			String sql = "SELECT id_promocion, nombre, descripcion, tipo_promocion, fk_tipoatraccion, costo, descuento, atraccion_gratis "
					+ "FROM promociones "
					+ "JOIN \"tipo promocion\" ON \"tipo promocion\".id_tipopromocion = promociones.fk_tipopromocion "
					+ "WHERE id_promocion;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idPromocion);
			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion(resultados, atracciones);
			}
			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ArrayList<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atraccion> listarAtraccionesIncluidas(Integer idPromocion, ArrayList<Atraccion> atracciones) {
		try {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			String sql = "SELECT fk_atraccion FROM \"promocion-atraccion\" WHERE fk_promocion = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idPromocion);
			ResultSet resultados = statement.executeQuery();
			ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
			while (resultados.next()) {
				if (atracciones.contains(atraccionDAO.find(resultados.getInt("fk_atraccion")))) {
					int indice = atracciones.indexOf(atraccionDAO.find(resultados.getInt("fk_atraccion")));
					atraccionesIncluidas.add(atracciones.get(indice));
				}

			}
			return atraccionesIncluidas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados, ArrayList<Atraccion> atracciones) {
		try {

			Promocion unaPromocion = null;
			ArrayList<Atraccion> arrayDeAtracciones = listarAtraccionesIncluidas(resultados.getInt("id_promocion"),
					atracciones);
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
						resultados.getString("nombre"), resultados.getString("descripcion"), tipoAtraccion, resultados.getDouble("descuento"),
						arrayDeAtracciones);
				break;
			case "AxB":
				unaPromocion = new PromocionAxB(resultados.getInt("id_promocion"), resultados.getString("nombre"),
						resultados.getString("descripcion"), tipoAtraccion, arrayDeAtracciones);
				break;
			}
			return unaPromocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
