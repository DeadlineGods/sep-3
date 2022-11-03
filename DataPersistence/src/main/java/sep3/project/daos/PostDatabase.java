package sep3.project.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class PostDatabase implements PostPersistence {

	public PostDatabase() throws SQLException
	{
		DriverManager.registerDriver(new org.postgresql.Driver());
	}
	@Override
	public void savePost(String title, String description) throws SQLException {
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(" " +
					"INSERT INTO product(title, description) VALUES(?, ?)");

			statement.setString(1, title);
			statement.setString(2, description);

			statement.execute();
		}
		finally {
			connection.close();
		}
	}

	private Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://";

		//Remember guys you have to have the same user and password in your postgres for this to work
		String user = "postgres";
		String pw = "admin";

		Connection connection = null;
		connection = DriverManager.getConnection(url, user, pw);

		return connection;
	}
}
