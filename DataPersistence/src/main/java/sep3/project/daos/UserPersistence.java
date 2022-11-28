package sep3.project.daos;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public interface UserPersistence {
    ResponseGetUsers Get(String username, long userId) throws SQLException;
    UserData Create(String userName, String firstName, String lastName, String email, String password, String phoneNumber) throws SQLException;
}
