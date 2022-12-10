package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.AdminPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.AdminData;
import sep3.project.protobuf.ResponseGetAdmins;
import sep3.project.protobuf.ResponseGetUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@GRpcService
public class AdminDatabase implements AdminPersistence {
	@Override
	public ResponseGetAdmins Get(String username) throws SQLException {
		Connection connection = DBConnection.getConnection();
		List<AdminData> adminList = new ArrayList<>();
		ResponseGetAdmins response = null;

		try {
			ResultSet result;
			if (username.isEmpty()) {
				result = getAll(connection);
			}
			else {
				result = getByUsername(connection, username);
			}
			while (result.next()) {
				adminList.add(constructAdmin(result));
			}
			response = ResponseGetAdmins.newBuilder().addAllAdmins(adminList).build();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			connection.close();
		}

		return response;
	}

	private AdminData constructAdmin(ResultSet result) throws SQLException {
		return AdminData.newBuilder()
				.setUsername(result.getString("user_name"))
				.setPassword(result.getString("password"))
				.setEmail(result.getString("email"))
				.build();
	}

	private ResultSet getAll(Connection connection) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM admin");

			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private ResultSet getByUsername(Connection connection, String username) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM admin WHERE user_name = ?");
			statement.setString(1, username);

			return statement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
