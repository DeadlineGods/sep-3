package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.PostData;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public interface PostPersistence {
	int createPost(String title, long userId, String description, String imageUrl, int locationId) throws SQLException;
	void deletePost(long id) throws SQLException;
	ArrayList<PostData> getPost(long id, long userId, String titleContains) throws SQLException;
}
