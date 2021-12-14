package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import model.Atraccion;

import model.Itinerario;
import model.Oferta;
import persistence.ItinerarioDAO;
import persistence.commons.MissingDataException;
import model.Promocion;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	@Override
	public ArrayList<Oferta> findItinerarioPorUsuario(int id_usuario) {

		try {
			String sql = "SELECT fk_promocion, fk_atraccion " + "FROM itinerarios " + "WHERE fk_usuario = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id_usuario);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Oferta> compras = new ArrayList<>();
			while (resultados.next()) {
				if (resultados.getString("fk_promocion") != null) {
					Promocion oferta = DAOFactory.getPromocionDAO().find(resultados.getInt("fk_promocion"));
					compras.add(oferta);
				} else if (resultados.getString("fk_atraccion") != null) {
					Atraccion atraccion = DAOFactory.getAtraccionDAO().find(resultados.getInt("fk_atraccion"));
					compras.add(atraccion);
				}
			}
			return compras;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insertAtraccion(int id_usuario, Atraccion unaAtraccion) {
		try {
			String sql = "INSERT INTO itinerarios (fk_usuario, fk_atraccion, costo, tiempo) VALUES (?, ?, ?, ?);";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id_usuario);
			statement.setInt(2, unaAtraccion.getId_atraccion());
			statement.setInt(3, unaAtraccion.getCosto());
			statement.setDouble(4, unaAtraccion.getTiempo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insertPromocion(int id_usuario, Promocion unaPromocion) {
		try {
			String sql = "INSERT INTO itinerarios (fk_usuario, fk_promocion, costo, tiempo) VALUES (?, ?, ?, ?);";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id_usuario);
			statement.setInt(2, unaPromocion.getId_promocion());
			statement.setInt(3, unaPromocion.getCosto());
			statement.setDouble(4, unaPromocion.getTiempo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ArrayList<Itinerario> findAll() {
		return null;
	}

}