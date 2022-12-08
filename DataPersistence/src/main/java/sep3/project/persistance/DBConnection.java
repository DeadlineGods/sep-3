package sep3.project.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public DBConnection() throws SQLException {
		DriverManager.registerDriver(new org.postgresql.Driver());
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=photoguard";

		//Remember guys you have to have the same user and password in your postgres for this to work
		String user = "postgres";
		String pw = "admin";

		Connection connection = null;
		connection = DriverManager.getConnection(url, user, pw);

		return connection;
	}
}
