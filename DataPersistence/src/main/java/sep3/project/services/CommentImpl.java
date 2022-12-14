package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.CommentPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;

@GRpcService
public class CommentImpl extends CommentServiceGrpc.CommentServiceImplBase {
    private final CommentPersistence database;

    public CommentImpl(@Qualifier("commentDatabase") CommentPersistence database) {
        this.database = database;
    }

    @Override
    public void createComment(RequestCreateComment request, StreamObserver<ResponseCreateComment> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseCreateComment response = null;
        try {
            response = database.create(
                    request.getBody(),
                    request.getOwnerId(),
                    request.getPostId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Comment Created =v \n" + response.toString());
    }

    @Override
    public void assignCommentToParent(RequestAssignCommentToParent request, StreamObserver<EmptyComment> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        try {
            database.assignParentCommentTo(
                    request.getId(),
                    request.getParentId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EmptyComment response = EmptyComment.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Comment assigned =v \n" + response.toString());
    }

    @Override
    public void getByIdComment(RequestGetGetByIdComment request, StreamObserver<CommentData> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        CommentData response = null;
        try {
            response = database.getById(
                    request.getId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Comment =v \n" + response.toString());
    }

    @Override
    public void getByPostComments(RequestGetByPostComments request, StreamObserver<CommentsList> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        CommentsList response = null;
        try {
            response = database.getByPost(
                    request.getPostId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Comments =v \n" + response.toString());
    }

    @Override
    public void getSubComments(RequestGetSubComments request, StreamObserver<CommentsList> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        CommentsList response = null;
        try {
            response = database.getSubComments(
                request.getId()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Sub comments =v \n" + response.toString());
    }

    @Override
    public void deleteComment(RequestDeleteComment request, StreamObserver<EmptyComment> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        try
        {
            database.deleteComment(request.getPostId());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        EmptyComment response = EmptyComment.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
