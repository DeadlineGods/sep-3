package sep3.project.daos.interfaces;

import org.springframework.stereotype.Component;
import sep3.project.protobuf.ReportData;
import sep3.project.protobuf.ResponseGetReports;
import sep3.project.protobuf.ResponseReportPost;

import java.sql.SQLException;

@Component
public interface ReportPersistence {
	ResponseReportPost reportPost(String violation, long postId, long userId) throws SQLException;
	ReportData getById(long id) throws SQLException;
	ResponseGetReports get() throws SQLException;
}
