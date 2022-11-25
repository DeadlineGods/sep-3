package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ResponseGetUsers;
import sep3.project.protobuf.UserData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@GRpcService
public class UserDatabase implements UserPersistence {
    @Override
    public UserData Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber) throws SQLException {
        Connection connection = DBConnection.getConnection();
        UserData userData = null;
        try {
            long userId = 0;
            String sql = "INSERT INTO \"User\" (user_name, first_name, last_name, email, password, phone_number)  VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, userName);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, phoneNumber);

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

    public ResponseGetUsers Get(String username, long userId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<UserData> usersList = new ArrayList<>();
        ResponseGetUsers response = null;
        try
        {
            // get user with id
            if (userId != 0) {
                ResultSet resultSet = getById(connection, userId);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            // get user with username
            if (!username.equals("")) {
                ResultSet resultSet = getByUsername(connection, username);
                while (resultSet.next()) {
                    usersList.add(getUserFromQuery(resultSet));
                }
            }
            // get user with id
            if (userId == 0 && username.equals("")) {
                ResultSet resultSet = getAll(connection);
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
            statement = connection.prepareStatement("SELECT * FROM user");

            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet getByUsername(Connection connection, String username) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ?");

            statement.setString(1,username);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet getById(Connection connection, long id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE userid = ?");

            statement.setLong(1, id);
            return statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private UserData getUserFromQuery(ResultSet resultSet) throws SQLException {
        return UserData.newBuilder()
                .setId(resultSet.getLong("userid"))
                .setUsername(resultSet.getString("username"))
                .setFirstName(resultSet.getString("firstname"))
                .setLastName(resultSet.getString("lastname"))
                .setEmail(resultSet.getString("email"))
                .setPassword(resultSet.getString("password"))
                .setPhoneNumber(resultSet.getString("phonenumber"))
                .build();
    }
}
