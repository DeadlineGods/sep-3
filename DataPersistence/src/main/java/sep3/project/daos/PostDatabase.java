package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.PostData;

import java.sql.*;
import java.util.ArrayList;

@GRpcService
public class PostDatabase implements PostPersistence {
	public PostDatabase()
	{

	}

	@Override
	public int createPost(String title, long userId, String description, String[] tags, String imageUrl) throws SQLException {
		Connection connection = DBConnection.getConnection();
		int id = 0;

		try {
			PreparedStatement statement = connection.prepareStatement("" +
					"INSERT INTO post(title, user_id, description, image_url) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, title);
			statement.setLong(2, userId);
			statement.setString(3, description);
			statement.setString(4, imageUrl);

			statement.execute();

			// Getting newly created post ID
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			addTags(connection, tags, id);

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
	public ArrayList<PostData> getPost(int id, long userId, String titleContains) throws SQLException {
		Connection connection = DBConnection.getConnection();

		ArrayList<PostData> posts = new ArrayList<>();

		try {
			// get posts with id
			if (id != 0) {
				ResultSet resultSet = getById(connection, id);
				while (resultSet.next()) {
					posts.add(createPostFromQuery(resultSet));
				}
			}
			// get posts which title contains @titleContains
			if (! titleContains.equals("")) {
				ResultSet resultSet = getByTitle(connection, titleContains);
				while (resultSet.next()) {
					posts.add(createPostFromQuery(resultSet));
				}
			}

			if (id == 0 && userId == 0 && titleContains.equals("")) {
				ResultSet resultSet = getAll(connection);
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

	private void addTags(Connection connection, String[] tags, int id) throws SQLException {
		PreparedStatement statement = null;
		for (String tag : tags) {

			// first insert into TAG table
			if (! containsTag(connection, tag)) {
				statement = connection.prepareStatement("" +
						"INSERT INTO tag(name) VALUES(?)");

				statement.setString(1, tag);

				statement.execute();
			}

			// then insert also into join table, because tag_name is foreign key
			statement = connection.prepareStatement("" +
					"INSERT INTO posttag(post_id, tag_name) VALUES(?, ?)");

			statement.setInt(1, id);
			statement.setString(2, tag);

			statement.execute();

		}
	}

	private boolean containsTag(Connection connection, String tag) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT name from tag where name = ?");

		statement.setString(1, tag);
		ResultSet resultSet = statement.executeQuery();

		return resultSet.next();
	}

	private ResultSet getAll(Connection connection) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM post");

			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private ResultSet getByTitle(Connection connection, String titleContains) {
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

	private ResultSet getById(Connection connection, int id) {
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

	private PostData createPostFromQuery(ResultSet resultSet) throws SQLException {
		return PostData.newBuilder()
				.setId(resultSet.getInt("id"))
				.setUserId(resultSet.getLong("user_id"))
				.setDescription(resultSet.getString("description"))
				.setTitle(resultSet.getString("title"))
				.setImgUrl(resultSet.getString("image_url"))
				.setPostedOnMilliseconds(resultSet.getTimestamp("posted_on").getTime())
				.build();
	}
}
