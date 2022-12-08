package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.BanPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.PostId;

import java.sql.*;

@GRpcService
public class BanDatabase implements BanPersistence {
	@Override
	public PostId create(String admin, String reason, long postId) throws SQLException {
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO ban_post (admin, reason, post_id) VALUES (?, ?, ?)");

			statement.setString(1, admin);
			statement.setString(2, reason);
			statement.setLong(3, postId);

			statement.execute();
		}
		finally {
			connection.close();
		}

		return PostId.newBuilder().setId(postId).build();
	}
}
