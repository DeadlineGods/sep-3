package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.CommentData;
import sep3.project.protobuf.CommentsList;
import sep3.project.protobuf.ResponseCreateComment;

import java.sql.SQLException;

@Component
public interface CommentPersistence {
    ResponseCreateComment create(String body, long ownerId, long postId) throws SQLException;
    void assignParentCommentTo(long id, long parentId) throws SQLException;

    CommentData getById(long id) throws SQLException;

    CommentsList getByPost(long postId) throws SQLException;

    CommentsList getSubComments(long id) throws SQLException;
    void deleteComment(long post_id) throws SQLException;

}
