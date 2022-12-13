package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.ReportPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ReportData;
import sep3.project.protobuf.ResponseCreateComment;
import sep3.project.protobuf.ResponseGetReports;
import sep3.project.protobuf.ResponseReportPost;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@GRpcService

public class ReportDatabase implements ReportPersistence {
	@Override
	public ResponseReportPost reportPost(String violation, long postId, long userId) throws SQLException {
		DBConnection db = DBConnection.getInstance();
Connection connection = db.getConnection();
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

	@Override
	public ReportData getById(long id) throws SQLException {
		DBConnection db = DBConnection.getInstance();
Connection connection = db.getConnection();
		ReportData reportData = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE id = ?");

			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next())
			{
				reportData = ReportData.newBuilder()
						.setReportId(resultSet.getLong("id"))
						.setViolationDesc(resultSet.getString("violation_desc"))
						.setPostId(resultSet.getLong("post_id"))
						.setUserId(resultSet.getLong("user_id"))
						.build();
			}
		}
		finally {
			connection.close();
		}

		return reportData;
	}

	@Override
	public ResponseGetReports get() throws SQLException {
		DBConnection db = DBConnection.getInstance();
Connection connection = db.getConnection();
		ResponseGetReports reports = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM report");

			ResultSet resultSet = statement.executeQuery();

			List<ReportData> reportDataList = new ArrayList<>();
			while (resultSet.next())
			{
				ReportData reportData = ReportData.newBuilder()
						.setReportId(resultSet.getLong("id"))
						.setViolationDesc(resultSet.getString("violation_desc"))
						.setPostId(resultSet.getLong("post_id"))
						.setUserId(resultSet.getLong("user_id"))
						.build();
				reportDataList.add(reportData);
			}
			reports = ResponseGetReports.newBuilder().addAllReports(reportDataList).build();
		}
		finally {
			connection.close();
		}

		return reports;
	}
}
