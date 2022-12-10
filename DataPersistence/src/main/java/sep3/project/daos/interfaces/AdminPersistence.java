package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ResponseGetAdmins;

import java.sql.SQLException;

@Component
public interface AdminPersistence {
	ResponseGetAdmins Get(String username) throws SQLException;
}
