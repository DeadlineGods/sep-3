package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.BanPersistence;
import sep3.project.protobuf.BanData;
import sep3.project.protobuf.BanServiceGrpc;
import sep3.project.protobuf.PostId;

import java.sql.SQLException;

@GRpcService
public class BanService extends BanServiceGrpc.BanServiceImplBase {

	private final BanPersistence database;


	public BanService(@Qualifier("banDatabase") BanPersistence database) {
		this.database = database;
	}

	@Override
	public void banPost(BanData request, StreamObserver<PostId> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());

		PostId response = null;

		try {
			response = database.create(
					request.getAdmin(),
					request.getReason(),
					request.getPostId()
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void get(PostId request, StreamObserver<PostId> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());

		PostId response = null;

		try {
			response = database.get(request.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
