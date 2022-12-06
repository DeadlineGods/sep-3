package sep3.project.daos;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.PostTagData;
import sep3.project.protobuf.TagListData;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public interface TagPersistence {
    ArrayList<PostTagData> GetPostTag(String tagContains, int postId) throws SQLException;
    ArrayList<TagListData> GetTagList(String tagContains) throws SQLException;
    String[] CreateTags(int postId, String[] tags) throws SQLException;
    void deleteTag(int postId) throws SQLException;
}
