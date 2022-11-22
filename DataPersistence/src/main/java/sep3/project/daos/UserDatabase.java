package sep3.project.daos;

import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.ResponseCreateUser;
import sep3.project.protobuf.UserData;

import java.sql.*;

@GRpcService
public class UserDatabase implements UserPersistence {
    @Override
    public ResponseCreateUser Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber) throws SQLException {
        Connection connection = DBConnection.getConnection();
        ResponseCreateUser responseCreateUser = null;
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
            UserData userData = UserData.newBuilder()
                    .setId(userId)
                    .setUsername(userName)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPassword(password)
                    .setPhoneNumber(phoneNumber)
                    .build();
            responseCreateUser = ResponseCreateUser.newBuilder()
                    .setUserData(userData)
                    .build();

        } finally {
            connection.close();
        }

        return responseCreateUser;
    }
}
