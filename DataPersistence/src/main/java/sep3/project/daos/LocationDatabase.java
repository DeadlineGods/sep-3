package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.CoordinatesData;
import sep3.project.protobuf.Location;
import sep3.project.protobuf.LocationData;
import sep3.project.protobuf.LocationId;

import java.sql.*;

@GRpcService
public class LocationDatabase implements LocationPersistence {

	public LocationDatabase() {
	}

	@Override
	public LocationData get(int id) throws SQLException {
		Connection connection = DBConnection.getConnection();
		LocationData data = null;

		try {

			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM location WHERE id = ?");

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				data = LocationData.newBuilder()
						.setAddress(result.getString("address"))
						.setPostCode(result.getString("postCode"))
						.setTown(result.getString("town"))
						.setCountry(result.getString("country"))
						.setLatitude(result.getDouble("latitude"))
						.setLongitude(result.getDouble("longitude"))
						.build();

			}
		}
		finally {
			connection.close();
		}

		return data;
	}

	@Override
	public CoordinatesData getCoordinates(int id) throws SQLException {
		Connection connection = DBConnection.getConnection();
		CoordinatesData data = null;

		try {

			PreparedStatement statement = connection.prepareStatement(
					"SELECT latitude, longitude FROM location WHERE id = ?");

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				data = CoordinatesData.newBuilder()
						.setLatitude(result.getDouble("latitude"))
						.setLongitude(result.getDouble("longitude"))
						.build();
			}
		}
		finally {
			connection.close();
		}

		return data;
	}

	@Override
	public LocationId create(LocationData data) throws SQLException {
		Connection connection = DBConnection.getConnection();
		LocationId id = null;

		try {

			PreparedStatement statement = connection.prepareStatement(
					"INSERT into location(address, postCode, town, country, latitude, longitude) Values(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, data.getAddress());
			statement.setString(2, data.getPostCode());
			statement.setString(3, data.getTown());
			statement.setString(4, data.getCountry());
			statement.setDouble(5, data.getLatitude());
			statement.setDouble(6, data.getLongitude());

			statement.execute();

			ResultSet result = statement.getGeneratedKeys();

			if (result.next()) {
				id = LocationId.newBuilder()
						.setId(result.getInt("id"))
						.build();
			}
		}
		finally {
			connection.close();
		}

		return id;
	}
}
