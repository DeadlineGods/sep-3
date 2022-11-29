package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.UserPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;

@GRpcService
public class UserImpl extends UserServiceGrpc.UserServiceImplBase {
    private final UserPersistence database;

    public UserImpl(@Qualifier("userDatabase") UserPersistence database) {
        this.database = database;
    }

    @Override
    public void createUser(RequestCreateUser request, StreamObserver<UserData> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        UserData response = null;
        try {
            response = database.Create(
                    request.getUsername(),
                    request.getFirstName(),
                    request.getLastName(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getPhoneNumber());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("User Created =v \n" + response.toString());
    }

    @Override
    public void getLikes(RequestGetLikes request, StreamObserver<ResponseGetLikes> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseGetLikes response = null;
        try
        {
            response = database.GetLikes(request.getPostId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Users which liked post with id" + request.getPostId() +  "=> \n" + response.toString());

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
    public void getUsers(RequestGetUsers request, StreamObserver<ResponseGetUsers> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseGetUsers response = null;
        try
        {
            response = database.Get(
                    request.getUsername(),
                    request.getUserid()
            );
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("User with username: "+  request.toString() + " =v \n "+ response.toString());

    }
}
