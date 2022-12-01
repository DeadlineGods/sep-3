package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.PostPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;
import java.util.ArrayList;

@GRpcService
public class PostImpl extends PostServiceGrpc.PostServiceImplBase {
	private final PostPersistence database;

	public PostImpl(@Qualifier("postDatabase") PostPersistence database) {
		this.database = database;
	}

	@Override
	public void createPost(RequestCreatePost request, StreamObserver<ResponseCreatePost> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());
		int id = 0;

		try {
			// create post in database and return id of new created post
			id = database.createPost(request.getTitle(), request.getUserId(), request.getDescription(), request.getTagsList().toArray(new String[0]));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		ResponseCreatePost response = ResponseCreatePost.newBuilder()
				.setId(id)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}

	@Override
	public void getPost(RequestGetPost request, StreamObserver<ResponseGetPost> responseObserver) {
		System.out.println("Received Request =>\n" + request.toString());
		ArrayList list;

		try {
			// get posts from database
			list = database.getPost(request.getId(), request.getUserId(), request.getTitle());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		ResponseGetPost posts = ResponseGetPost.newBuilder()
				.addAllPosts(list).build();

		responseObserver.onNext(posts);
		responseObserver.onCompleted();
	}
	@Override
	public void deletePost(RequestDeletePost request, StreamObserver<EmptyPost> responseObserver) {
		System.out.println("Received Request to delete=>\n" + request.toString());
		try
		{
			database.deletePost(request.getId());
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		EmptyPost response = EmptyPost.newBuilder().build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
