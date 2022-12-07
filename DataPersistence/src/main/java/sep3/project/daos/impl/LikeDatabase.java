package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.LikePersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ResponseCountLikes;
import sep3.project.protobuf.ResponseIsPostLiked;
import sep3.project.protobuf.ResponseLikePost;

import java.sql.*;

@GRpcService
public class LikeDatabase implements LikePersistence {

    private LikeDatabase() {

    }

    @Override
    public ResponseLikePost LikePost(long postId, long userId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        ResponseLikePost responseLikePost = null;
        try {
            String sql = "INSERT INTO \"likepost\" (user_id, post_id)  VALUES (?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, userId);
            ps.setLong(2, postId);

            ps.execute();

            // Getting newly created like

            // Building a response
            responseLikePost = responseLikePost.newBuilder()
                    .setPostId(postId)
                    .setUserId(userId)
                    .build();

        } finally {
            connection.close();
        }

        return responseLikePost;
    }

    @Override
    public void UnLikePost(long postId, long userId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            String sql = "DELETE FROM likepost WHERE post_id = ? AND user_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, postId);
            ps.setLong(2, userId);

            ps.execute();
        } finally {
            connection.close();
        }
    }

    @Override
    public ResponseIsPostLiked IsPostLiked(long postId, long userId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        ResponseIsPostLiked response = null;
        try {
            String sql = "SELECT count(*) FROM likepost WHERE user_id = ? and post_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, userId);
            ps.setLong(2, postId);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                boolean isLiked = resultSet.getInt("count") != 0;
                response = ResponseIsPostLiked
                        .newBuilder()
                        .setIsLiked(isLiked)
                        .build();
            }
        } finally {
            connection.close();
        }
        return response;
    }

    @Override
    public ResponseCountLikes CountLikes(long postId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        ResponseCountLikes response = null;
        PreparedStatement statement = null;
        try
        {
            statement = connection.prepareStatement("SELECT COUNT(post_id) FROM likepost WHERE post_id = ?");
            statement.setLong(1, postId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                response = ResponseCountLikes.newBuilder()
                        .setLikesNo(resultSet.getInt("count")).build();
            }
            return response;
        }
        finally {
            connection.close();
        }
    }

    @Override
    public void DeleteLike(long postId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try
        {
            PreparedStatement statement_likes = connection.prepareStatement(
                    "DELETE FROM likepost WHERE post_id IN " +
                            "(SELECT id FROM post WHERE id = ?)"
            );
            statement_likes.setLong(1, postId);
            statement_likes.execute();
        }
        finally {
            connection.close();
        }
    }
}
