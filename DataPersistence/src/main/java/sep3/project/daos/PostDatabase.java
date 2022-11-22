package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.Post;

import java.sql.*;
import java.util.ArrayList;

@GRpcService
public class PostDatabase implements PostPersistence {

	private Connection connection;
	public PostDatabase()
	{
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int createPost(String title, String description) throws SQLException {
		int id = 0;

		try {
			PreparedStatement statement = connection.prepareStatement("" +
					"INSERT INTO post(title, description) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, title);
			statement.setString(2, description);

			statement.execute();

			// Getting newly created post ID
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt("id");
			}
		}
		finally {
			connection.close();
		}

		return id;
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

	@Override
	public ArrayList<Post> getPost(int id, int userId, String titleContains) throws SQLException {
		Connection connection = DBConnection.getConnection();
		ArrayList<Post> posts = new ArrayList<>();

		try {
			// get posts with id
			if (id != 0) {
				ResultSet resultSet = getById(id);
				while (resultSet.next()) {
					posts.add(createPostFromQuery(resultSet));
				}
			}
			// get posts which title contains @titleContains
			if (! titleContains.equals("")) {
				ResultSet resultSet = getByTitle(titleContains);
				while (resultSet.next()) {
					posts.add(createPostFromQuery(resultSet));
				}
			}

			if (id == 0 && userId == 0 && titleContains.equals("")) {
				ResultSet resultSet = getAll();
				while (resultSet.next()) {
					posts.add(createPostFromQuery(resultSet));
				}
			}

		}
		catch (Exception e) {
			throw new SQLException(e);
		}
		finally {
			connection.close();
		}

		return posts;
	}

	private ResultSet getAll() {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM post");

			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private ResultSet getByTitle(String titleContains) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"SELECT * FROM post WHERE title LIKE '%' || ? || '%'");

			statement.setString(1, titleContains);
			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private ResultSet getById(int id) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"SELECT * FROM post WHERE id = ?");

			statement.setInt(1, id);
			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private Post createPostFromQuery(ResultSet resultSet) throws SQLException {
		return Post.newBuilder()
				.setId(resultSet.getInt("id"))
				.setDescription(resultSet.getString("description"))
				.setTitle(resultSet.getString("title"))
				.setLikes(resultSet.getInt("likes"))
				.setPostedOnMilliseconds(resultSet.getTimestamp("postedOn").getTime())
				.build();
	}
}
