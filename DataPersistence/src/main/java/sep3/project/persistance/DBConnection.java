package sep3.project.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=photoguard";

			String user = "postgres";
			String pw = "admin";

			connection = DriverManager.getConnection(url, user, pw);
		}

		return connection;
	}
}
