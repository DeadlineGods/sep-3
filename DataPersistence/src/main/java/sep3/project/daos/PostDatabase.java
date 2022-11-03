package sep3.project.daos;

import sep3.project.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDatabase implements PostPersistence {

	public PostDatabase()
	{
	}

	@Override
	public void createPost(String title, String description) throws SQLException {
		Connection connection = DBConnection.getConnection();
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
}
