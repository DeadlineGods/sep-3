package sep3.project.daos;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public interface PostPersistence {
	void createPost(String title, String description) throws SQLException;
	void deletePost(int id) throws SQLException;
}
