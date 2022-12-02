package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.checkerframework.checker.fenum.qual.SwingElementOrientation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sep3.project.daos.LocationPersistence;
import sep3.project.daos.PostPersistence;
import sep3.project.protobuf.Coordinates;
import sep3.project.protobuf.LocationId;
import sep3.project.protobuf.LocationServiceGrpc;

@Service
public class LocationService extends LocationServiceGrpc.LocationServiceImplBase {

	private final LocationPersistence database;

	public LocationService(@Qualifier("locationDB") LocationPersistence database) {
		this.database = database;
	}
	@Override
	public void getCoordinates(LocationId request, StreamObserver<Coordinates> responseObserver) {
		super.getCoordinates(request, responseObserver);
	}
}
