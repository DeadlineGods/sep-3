package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.TagPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;
import java.util.ArrayList;

@GRpcService
public class TagImpl extends TagServiceGrpc.TagServiceImplBase {
    private final TagPersistence database;

    public TagImpl(@Qualifier("tagDatabase")TagPersistence database) {
        this.database = database;
    }
    @Override
    public void getPostTag(RequestGetPostTag request, StreamObserver<ResponseGetPostTag> responseObserver) {
        System.out.println("Received Request =>\n" + request.toString());
        ArrayList list;

        try {
            // get tags from database
            list = database.GetPostTag(
                    request.getTagContains(),
                    request.getPostId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResponseGetPostTag tags = ResponseGetPostTag.newBuilder()
                .addAllTags(list).build();

        responseObserver.onNext(tags);
        responseObserver.onCompleted();
    }

    @Override
    public void getTagList(RequestGetTagList request, StreamObserver<ResponseGetTagList> responseObserver) {
        System.out.println("Received Request =>\n" + request.toString());
        ArrayList list;

        try {
            // get tags from database
            list = database.GetTagList(
                    request.getTagContains());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResponseGetTagList tags = ResponseGetTagList.newBuilder()
                .addAllTags(list).build();

        responseObserver.onNext(tags);
        responseObserver.onCompleted();
    }
}
