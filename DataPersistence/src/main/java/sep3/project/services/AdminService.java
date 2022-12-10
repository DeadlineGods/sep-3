package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.AdminPersistence;
import sep3.project.protobuf.AdminServiceGrpc;
import sep3.project.protobuf.AdminUsername;
import sep3.project.protobuf.ResponseGetAdmins;

import java.sql.SQLException;

@GRpcService
public class AdminService extends AdminServiceGrpc.AdminServiceImplBase {
	private final AdminPersistence db;

	public AdminService(@Qualifier("adminDatabase") AdminPersistence db) {
		this.db = db;
	}

	@Override
	public void getAdmin(AdminUsername request, StreamObserver<ResponseGetAdmins> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());
		ResponseGetAdmins response;

		try {
			response = db.Get(request.getUsername());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
