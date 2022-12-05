package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.LocationPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;

@GRpcService
public class LocationService extends LocationServiceGrpc.LocationServiceImplBase {

	private final LocationPersistence database;

	public LocationService(@Qualifier("locationDatabase") LocationPersistence database) {
		this.database = database;
	}

	@Override
	public void get(LocationId request, StreamObserver<LocationData> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());

		try {
			responseObserver.onNext(database.get(request.getId()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onCompleted();
	}

	@Override
	public void getCoordinates(LocationId request, StreamObserver<CoordinatesData> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());

		try {
			responseObserver.onNext(database.getCoordinates(request.getId()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onCompleted();
	}

	@Override
	public void create(LocationData request, StreamObserver<LocationId> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());

		LocationId id = null;
		try {
			id = database.create(request);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onNext(id);

		responseObserver.onCompleted();
	}
}
