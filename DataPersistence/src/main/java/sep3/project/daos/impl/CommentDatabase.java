package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.CommentPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.CommentData;
import sep3.project.protobuf.CommentsList;
import sep3.project.protobuf.ResponseCreateComment;

import java.sql.*;
import java.util.ArrayList;

@GRpcService
public class CommentDatabase implements CommentPersistence {

    @Override
    public ResponseCreateComment create(String body, long ownerId, long postId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        long id = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO comment (body, user_id, post_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, body);
            statement.setLong(2, ownerId);
            statement.setLong(3, postId);

            statement.execute();

            // Getting newly created post ID
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong("id");
            }
        }
        finally {
            connection.close();
        }

        return ResponseCreateComment.newBuilder().setId(id).build();
    }

    @Override
    public void assignParentCommentTo(long id, long parentId) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO CommentParentComment (comment_id, parent_comment_id) VALUES (?, ?)");

            statement.setLong(1, id);
            statement.setLong(2, parentId);

            statement.execute();
        }
        finally {
            connection.close();
        }
    }

    @Override
    public CommentData getById(long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CommentData commentData = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Comment WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                commentData = CommentData.newBuilder()
                        .setId(resultSet.getLong("id"))
                        .setBody(resultSet.getString("body"))
                        .setPostId(resultSet.getLong("post_id"))
                        .setOwnerId(resultSet.getLong("user_id"))
                        .setCreatedOnMilliseconds(resultSet.getTimestamp("created_on").getTime())
                        .build();
            }
        }
        finally {
            connection.close();
        }

        return commentData;
    }

    @Override
    public CommentsList getByPost(long postId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CommentsList commentsList = null;
        ArrayList<CommentData> commentDataArrayList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM comment WHERE id NOT IN (SELECT comment_id FROM commentparentcomment) and post_id = ?");

            statement.setLong(1, postId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentData commentData = CommentData.newBuilder()
                        .setId(resultSet.getLong("id"))
                        .setBody(resultSet.getString("body"))
                        .setPostId(resultSet.getLong("post_id"))
                        .setOwnerId(resultSet.getLong("user_id"))
                        .setCreatedOnMilliseconds(resultSet.getTimestamp("created_on").getTime())
                        .build();

                commentDataArrayList.add(commentData);
            }
        } finally {
            connection.close();
        }

        return CommentsList.newBuilder().addAllComments(commentDataArrayList).build();
    }

    @Override
    public CommentsList getSubComments(long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CommentsList commentsList = null;
        ArrayList<CommentData> commentDataArrayList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM comment WHERE id IN (SELECT comment_id FROM commentparentcomment WHERE parent_comment_id = ?)");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentData commentData = CommentData.newBuilder()
                        .setId(resultSet.getLong("id"))
                        .setBody(resultSet.getString("body"))
                        .setPostId(resultSet.getLong("post_id"))
                        .setOwnerId(resultSet.getLong("user_id"))
                        .setCreatedOnMilliseconds(resultSet.getTimestamp("created_on").getTime())
                        .build();

                commentDataArrayList.add(commentData);
            }
        } finally {
            connection.close();
        }

        return CommentsList.newBuilder().addAllComments(commentDataArrayList).build();
    }

    @Override
    public void deleteComment(long post_id) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try
        {
            //deleting sub_comments
            PreparedStatement statement_sub_comments = connection.prepareStatement(
                    "DELETE FROM commentparentcomment WHERE parent_comment_id IN " +
                            "(SELECT id FROM comment WHERE post_id IN " +
                            "(SELECT id FROM post WHERE id = ?))"
            );
            statement_sub_comments.setLong(1, post_id);
            statement_sub_comments.execute();
            //deleting comments
            PreparedStatement statement_comments = connection.prepareStatement(
                    "DELETE FROM comment WHERE post_id IN " +
                            "(SELECT id FROM post WHERE id = ?)"
            );
            statement_comments.setLong(1, post_id);
            statement_comments.execute();

        }
        finally {
            connection.close();
        }
    }
}
