package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.CoordinatesData;
import sep3.project.protobuf.Location;
import sep3.project.protobuf.LocationData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
						.setLatitude(result.getFloat("latitude"))
						.setLongitude(result.getFloat("longitude"))
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
						.setLatitude(result.getFloat("latitude"))
						.setLongitude(result.getFloat("longitude"))
						.build();
			}
		}
		finally {
			connection.close();
		}

		return data;
	}
}
