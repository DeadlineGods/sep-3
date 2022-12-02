package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ResponseCountLikes;
import sep3.project.protobuf.ResponseIsPostLiked;
import sep3.project.protobuf.ResponseLikePost;

import java.sql.SQLException;

@Component
public interface LikePersistence {

    ResponseLikePost LikePost(int postId, long userId) throws SQLException;
    void UnLikePost(int postId, long userId) throws SQLException;
    ResponseIsPostLiked IsPostLiked(int postId, long userId) throws SQLException;
    ResponseCountLikes CountLikes(int postId) throws SQLException;
}
