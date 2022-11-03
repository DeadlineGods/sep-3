package sep3.project.daos;

import java.sql.SQLException;

public interface PostPersistence {
	void savePost(String title, String description) throws SQLException;
}
