package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@GRpcService
public class PostDatabase implements PostPersistence {

	public PostDatabase()
	{
	}

	@Override
	public void createPost(String title, String description) throws SQLException {
		Connection connection = DBConnection.getConnection();
		System.out.println(description);

		try {
			PreparedStatement statement = connection.prepareStatement("" +
					"INSERT INTO post(title, description) VALUES(?, ?)");

			statement.setString(1, title);
			statement.setString(2, description);

			statement.execute();
		}
		finally {
			connection.close();
		}
	}

	@Override
	public void deletePost(int id) throws SQLException {
		Connection connection = DBConnection.getConnection();

		try
		{
			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM post " +
							"WHERE id = ?"
			);
			statement.setInt(1, id);
			statement.execute();
		}
		finally {
			connection.close();
		}
	}
}
