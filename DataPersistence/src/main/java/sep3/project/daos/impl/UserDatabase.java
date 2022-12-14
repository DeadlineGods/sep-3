package sep3.project.daos.impl;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.daos.interfaces.UserPersistence;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ResponseGetLikes;
import sep3.project.protobuf.ResponseGetUsers;
import sep3.project.protobuf.UserData;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@GRpcService
public class UserDatabase implements UserPersistence {

    public UserDatabase() {
    }

    @Override
    public UserData Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber, long locationId) throws SQLException {
		DBConnection db = DBConnection.getInstance();
		Connection connection = db.getConnection();

        UserData userData = null;
        try {
            long userId = 0;
            String sql = "INSERT INTO \"User\" (user_name, first_name, last_name, email, password, phone_number, location_id)  VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, userName);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, phoneNumber);
			ps.setLong(7, locationId);

            ps.execute();

            // Getting newly created users ID
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                userId = rs.getLong(1);
            }

            // Building a response
             userData = UserData.newBuilder()
                    .setId(userId)
                    .setUsername(userName)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPassword(password)
                    .setPhoneNumber(phoneNumber)
                    .build();

        } finally {
            connection.close();
        }

        return userData;
    }


    @Override
    public ResponseGetLikes GetLikes(int postId) throws SQLException {
		DBConnection db = DBConnection.getInstance();
		Connection connection = db.getConnection();

        List<UserData> usersList = new ArrayList<>();
        ResponseGetLikes response = null;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement( "SELECT * FROM \"User\" WHERE id IN (SELECT user_id FROM likepost WHERE post_id = ?)");
            statement.setInt(1, postId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                UserData userData = null;
                userData = UserData.newBuilder()
                        .setId(resultSet.getInt("id"))
                        .setUsername(resultSet.getString("user_name"))
                        .setFirstName(resultSet.getString("first_name"))
                        .setLastName(resultSet.getString("last_name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("password"))
                        .setPhoneNumber(resultSet.getString("phone_number"))
                        .build();

                usersList.add(userData);
            }
            response = ResponseGetLikes.newBuilder().addAllUser(usersList).build();
        }
        finally {
            connection.close();
        }
        return response;
    }

    public ResponseGetUsers Get(String username, long userId) throws SQLException {
        DBConnection db = DBConnection.getInstance();
		Connection connection = db.getConnection();
        List<UserData> usersList = new ArrayList<>();
        ResponseGetUsers response = null;
        try
        {
            // get users by id only
            if (userId!=0 && username.equals("")) {
                ResultSet resultSet = getById(connection, userId);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            // get users by username only
            else if (userId==0 && !username.equals("")) {
                ResultSet resultSet = getByUsername(connection, username);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            // get all users
            else if(userId==0 && username.equals(""))
            {
                ResultSet resultSet = getAll(connection);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            // get users by both id and username
            else {
                ResultSet resultSet = getByUsernameAndId(connection, userId, username);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            response = ResponseGetUsers.newBuilder().addAllUserData(usersList).build();
        }
        catch (Exception e){
            throw new SQLException(e);
        }
        finally {
            connection.close();
        }
        return response;

    }
    private ResultSet getAll(Connection connection) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM \"User\"");

            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet getByUsername(Connection connection, String username) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM \"User\" WHERE user_name LIKE '%' || ? || '%'");

            statement.setString(1,username);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet getById(Connection connection, long id) {
        PreparedStatement statement = null;

        try {
            int i = (int) id;
            statement = connection.prepareStatement(
                    "SELECT * FROM \"User\" WHERE id = ?");
            statement.setLong(1, i);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet getByUsernameAndId(Connection connection, long id,String username) {
        PreparedStatement statement = null;

        try {
            int i = (int) id;
            statement = connection.prepareStatement(
                    "SELECT * FROM \"User\" WHERE id = ? AND user_name LIKE '%' || ? || '%'");
            statement.setLong(1, i);
            statement.setString(2, username);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private UserData getUserFromQuery(ResultSet resultSet) throws SQLException {
        return UserData.newBuilder()
                .setId(resultSet.getLong("id"))
                .setUsername(resultSet.getString("user_name"))
                .setFirstName(resultSet.getString("first_name"))
                .setLastName(resultSet.getString("last_name"))
                .setEmail(resultSet.getString("email"))
                .setPassword(resultSet.getString("password"))
                .setPhoneNumber(resultSet.getString("phone_number"))
				.setLocationId(resultSet.getLong("location_id"))
                .build();
    }
}
