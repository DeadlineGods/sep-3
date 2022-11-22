package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ResponseCreateUser;
import sep3.project.protobuf.ResponseGetUsers;
import sep3.project.protobuf.UserData;

import java.sql.SQLException;

@Component
public interface UserPersistence {
    ResponseGetUsers Get(String username) throws SQLException;
    UserData Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber) throws SQLException;
}
