package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.ReportPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ResponseCreateComment;
import sep3.project.protobuf.ResponseReportPost;

import java.sql.*;

@GRpcService

public class ReportDatabase implements ReportPersistence {


	@Override
	public ResponseReportPost reportPost(String violation, int postId, int userId) throws SQLException {
		Connection connection = DBConnection.getConnection();
		int id = 0;

		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO report (violation_desc, post_id, user_id ) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, violation);
			statement.setLong(2, postId);
			statement.setLong(3, userId);

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

		return ResponseReportPost.newBuilder().setReportId(id).build();
	}
}
