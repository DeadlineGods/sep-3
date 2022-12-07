package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ResponseReportPost;

import java.sql.SQLException;

@Component
public interface ReportPersistence {
	ResponseReportPost reportPost(String violation, int postId, int userId) throws SQLException;
}
