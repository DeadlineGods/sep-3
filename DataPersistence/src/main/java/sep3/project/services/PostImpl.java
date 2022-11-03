package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.PostPersistence;
import sep3.project.protobuf.PostGrpc;
import sep3.project.protobuf.RequestCreatePost;
import sep3.project.protobuf.ResponseCreatePost;

import java.sql.SQLException;
@GRpcService
public class PostImpl extends PostGrpc.PostImplBase {
	private final PostPersistence database;

	public PostImpl(@Qualifier("postDatabase") PostPersistence database) {
		this.database = database;
	}

	@Override
	public void createPost(RequestCreatePost request, StreamObserver<ResponseCreatePost> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());

		try {
			database.createPost(request.getTitle(), request.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		ResponseCreatePost response = ResponseCreatePost.newBuilder()
				.setTitle(request.getTitle())
				.setDescription(request.getDescription())
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();

		System.out.println("Post created =>\n" + request.toString());
	}

}
