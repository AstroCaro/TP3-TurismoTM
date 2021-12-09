package persistence.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static String url = "jdbc:sqlite:TurismoTM.db";
	private static Connection connection;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
}
