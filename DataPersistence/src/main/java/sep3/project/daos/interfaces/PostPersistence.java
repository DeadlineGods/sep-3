package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.PostData;
import sep3.project.protobuf.ResponseGetPostById;
import sep3.project.protobuf.ResponseUpdatePost;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public interface PostPersistence {
	int createPost(String title, long userId, String description, String[] tags, String imageUrl, int locationId) throws SQLException;
	void deletePost(int id) throws SQLException;
	ArrayList<PostData> getPost(int id, long userId, String titleContains) throws SQLException;
	ResponseUpdatePost updatePost(int id, String title, String description, String[] tags) throws SQLException;
	ResponseGetPostById getPostById(int id) throws SQLException;
}
