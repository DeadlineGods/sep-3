package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.PostDatabase;
import sep3.project.daos.interfaces.PostPersistence;
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
			id = database.createPost(request.getTitle(), request.getUserId(), request.getDescription(), request.getTagsList().toArray(new String[0]), request.getImgUrl(), request.getLocationId());
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

	@Override
	public void updatePost(RequestUpdatePost request, StreamObserver<ResponseUpdatePost> responseObserver) {
		System.out.println("Received Request to update=>\n" + request.toString());
		ArrayList list;

		try {
			// get posts from database
			list = database.getPost(request.getId(), 0, "");
			PostData post = (PostData) list.get(0);
			if(post == null)
			{
				System.out.println("No posts with id => " + request.getId());
				responseObserver.onNext(null);
				responseObserver.onCompleted();
				return;
			}
			else {
				System.out.println("Post with id was updated" + request.getId() + " =>" + request);

			}
			database.updatePost(request.getId(), request.getTitle(), request.getDescription(), request.getTagsList().toArray(new String[0]));
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}

		ResponseUpdatePost response = ResponseUpdatePost.newBuilder()
						.setId(request.getId()).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();


	}


}
