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

    @Override
    public UserData GetById(long userId) throws SQLException  {
        Connection connection = DBConnection.getConnection();
        UserData userData = null;
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE id = ?");
            statement.setLong(1, userId);

            statement.execute();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userData = UserData.newBuilder()
                        .setId(resultSet.getLong("id"))
                        .setUsername(resultSet.getString("user_name"))
                        .setFirstName(resultSet.getString("first_name"))
                        .setLastName(resultSet.getString("last_name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("password"))
                        .setPhoneNumber(resultSet.getString("phone_number"))
                        .build();

            }
        }
        finally {
            connection.close();
        }
        return userData;
    }

    public ResponseGetUsers Get(String username) throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<UserData> usersList = new ArrayList<>();
        ResponseGetUsers response = null;
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE username = ?");
            statement.setString(1,username);

            statement.execute();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserData userData = null;
                userData = UserData.newBuilder()
                        .setId(resultSet.getLong("id"))
                        .setUsername(resultSet.getString("user_name"))
                        .setFirstName(resultSet.getString("first_name"))
                        .setLastName(resultSet.getString("last_name"))
                        .setEmail(resultSet.getString("email"))
                        .setPassword(resultSet.getString("password"))
                        .setPhoneNumber(resultSet.getString("phone_number"))
                        .build();

            usersList.add(userData);
            }
            response = ResponseGetUsers.newBuilder().addAllUserData(usersList).build();
        }
        finally {
            connection.close();
        }
        return response;
    }
}
