package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import model.TipoAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public ArrayList<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM usuarios ";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int insert(Usuario usuario) {
		try {
			String sql = "INSERT INTO usuarios (nombre, fk_tipoatraccion, presupuesto, tiempo_disponible, admin) VALUES (?, ?, ?, ?, ?)";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getPreferencia().getId_tipoatraccion());
			statement.setInt(3, usuario.getPresupuesto());
			statement.setDouble(4, usuario.getTiempo_disponible());
			statement.setBoolean(5, usuario.getAdmin());
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET nombre = ?, fk_tipoatraccion = ?, presupuesto = ?, tiempo_disponible = ?, admin = ? WHERE id_usuario = ?;";
						
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getPreferencia().getId_tipoatraccion());
			statement.setInt(3, usuario.getPresupuesto());
			statement.setDouble(4, usuario.getTiempo_disponible());
			statement.setBoolean(5, usuario.getAdmin());
			statement.setInt(6, usuario.getId_usuario());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Usuario usuario) {
		try {
			String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, usuario.getId_usuario());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	public Usuario find(int id_usuario) {
		try {
			String sql ="SELECT * FROM usuarios WHERE id_usuario = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id_usuario);
			ResultSet resultado = statement.executeQuery();
			
			Usuario usuario = null;
			if (resultado.next()) {
				usuario = toUsuario(resultado);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Usuario findPorNombre(String nombre) {
		try {
			String sql ="SELECT * FROM usuarios WHERE nombre = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, nombre);
			ResultSet resultado = statement.executeQuery();
			
			Usuario usuario = null;
			if (resultado.next()) {
				usuario = toUsuario(resultado);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) {
		try {
			TipoAtraccion tipoAtraccion = DAOFactory.getTipoAtraccionDAO().find(resultados.getInt("fk_tipoatraccion"));
			return new Usuario(resultados.getInt("id_usuario"), resultados.getString("nombre"), resultados.getString("password"),tipoAtraccion ,
					resultados.getInt("presupuesto"), resultados.getDouble("tiempo_disponible"), resultados.getBoolean("admin"));

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
