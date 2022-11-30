package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.LikePersistence;
import sep3.project.daos.UserPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;

@GRpcService
public class LikeImpl extends LikeServiceGrpc.LikeServiceImplBase {

    private final LikePersistence database;

    public LikeImpl(@Qualifier("likeDatabase") LikePersistence database) {
        this.database = database;
    }


    @Override
    public void likePost(RequestLikePost request, StreamObserver<ResponseLikePost> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseLikePost response = null;
        try {
            response = database.LikePost(
                    request.getPostId(),
                    request.getUserId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("User Created =v \n" + response.toString());
    }

    @Override
    public void unLikePost(RequestUnLikePost request, StreamObserver<LikeEmpty> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        try
        {
            database.UnLikePost(
                    request.getPostId(),
                    request.getUserId()
            );
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        LikeEmpty response = LikeEmpty.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Unliked posts: "+  request.toString() + " =v \n "+ response.toString());
    }

    @Override
    public void isPostLiked(RequestIsPostLiked request, StreamObserver<ResponseIsPostLiked> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseIsPostLiked response = null;
        try
        {
            response = database.IsPostLiked(
                    request.getPostId(),
                    request.getUserId()
            );
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Is post liked: "+  request.toString() + " =v \n "+ response.toString());
    }


    @Override
    public void countLikes(RequestCountLikes request, StreamObserver<ResponseCountLikes> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseCountLikes response = null;
        try
        {
            response = database.CountLikes(request.getPostId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Post with id" + request.getPostId() +  " has => \n" + response.toString() + " likes");
    }
}
