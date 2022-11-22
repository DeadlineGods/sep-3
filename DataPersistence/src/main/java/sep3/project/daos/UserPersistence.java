package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.UserData;

import java.sql.SQLException;

@Component
public interface UserPersistence {
    UserData Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber) throws SQLException;
}
