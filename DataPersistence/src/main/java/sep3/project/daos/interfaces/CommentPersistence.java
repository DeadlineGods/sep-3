package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.CommentData;
import sep3.project.protobuf.ResponseCreateComment;

import java.sql.SQLException;

@Component
public interface CommentPersistence {
    ResponseCreateComment create(String body, long ownerId, long postId) throws SQLException;
    void assignParentCommentTo(long id, long parentId) throws SQLException;

    CommentData get(long id) throws SQLException;
}
