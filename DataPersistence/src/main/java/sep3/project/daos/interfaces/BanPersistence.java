package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.PostId;

import java.sql.SQLException;

@Component
public interface BanPersistence {
	PostId create(String admin, String reason, long postId) throws SQLException;
}
