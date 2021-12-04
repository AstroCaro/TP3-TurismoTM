package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import persistence.commons.ConnectionProvider;

import model.Cliente;
import persistence.ClienteDAO;
import persistence.commons.MissingDataException;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public ArrayList<Cliente> findAll() {
		try {
			String sql = "SELECT id_cliente, nombre, tipo_atraccion, presupuesto, tiempo_disponible " + "FROM clientes "
					+ "JOIN \"tipo atraccion\" ON \"tipo atraccion\".id_tipoatraccion = clientes.fk_tipoatraccion ;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			while (resultados.next()) {
				clientes.add(toCliente(resultados));
			}

			return clientes;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int update(Cliente cliente) {
		try {
			String sql = "UPDATE CLIENTES SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_CLIENTE = ?;";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cliente.getPresupuesto());
			statement.setDouble(2, cliente.getTiempo_disponible());
			statement.setInt(3, cliente.getId_cliente());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	public Cliente findClientePorID(int id_cliente) {
		try {
			String sql ="SELECT id_cliente, nombre, tipo_atraccion, presupuesto, tiempo_disponible " + "FROM clientes "
					+ "JOIN \"tipo atraccion\" ON \"tipo atraccion\".id_tipoatraccion = clientes.fk_tipoatraccion "
					+ "WHERE id_cliente = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id_cliente);
			ResultSet resultado = statement.executeQuery();
			
			Cliente cliente = null;
			if (resultado.next()) {
				cliente = toCliente(resultado);
			}

			return cliente;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Cliente toCliente(ResultSet resultados) {
		try {
			return new Cliente(resultados.getInt("id_cliente"), resultados.getString("nombre"), resultados.getString("tipo_atraccion"),
					resultados.getInt("presupuesto"), resultados.getDouble("tiempo_disponible"));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
