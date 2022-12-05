package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.Coordinates;
import sep3.project.protobuf.CoordinatesData;
import sep3.project.protobuf.LocationData;
import sep3.project.protobuf.LocationId;

import java.sql.SQLException;

@Component
public interface LocationPersistence {
	LocationData get(int id) throws SQLException;
	CoordinatesData getCoordinates(int id) throws SQLException;
	LocationId create(LocationData data) throws SQLException;
}
