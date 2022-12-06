package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ResponseCountLikes;
import sep3.project.protobuf.ResponseIsPostLiked;
import sep3.project.protobuf.ResponseLikePost;

import java.sql.SQLException;

@Component
public interface LikePersistence {

    ResponseLikePost LikePost(long postId, long userId) throws SQLException;
    void UnLikePost(long postId, long userId) throws SQLException;
    ResponseIsPostLiked IsPostLiked(long postId, long userId) throws SQLException;
    ResponseCountLikes CountLikes(long postId) throws SQLException;
}
