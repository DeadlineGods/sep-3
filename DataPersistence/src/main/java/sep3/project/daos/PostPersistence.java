package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.Post;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public interface PostPersistence {
	void createPost(String title, String description) throws SQLException;
	void deletePost(int id) throws SQLException;
	ArrayList<Post> getPost(int id, int userId, String titleContains) throws SQLException;
}
