package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.TagPersistence;
import sep3.project.protobuf.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@GRpcService
public class TagImpl extends TagServiceGrpc.TagServiceImplBase {
    private final TagPersistence database;

    public TagImpl(@Qualifier("tagDatabase")TagPersistence database) {
        this.database = database;
    }
    @Override
    public void createTags(RequestCreateTags request, StreamObserver<ResponseCreateTag> responseObserver)
    {
        System.out.println("Received Request =>\n" + request.toString());
        String[] tags = new String[]{};

        try {
            //create tags in database and return created tags
            //not all tags written when creating a post are created in database
            //some could arleady exist
            tags = database.CreateTags(request.getPostId(), request.getTagsList().toArray(new String[0]));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ResponseCreateTag response = ResponseCreateTag.newBuilder()
                .addAllTags(Arrays.asList(tags))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
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
