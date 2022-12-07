package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.interfaces.ReportPersistence;
import sep3.project.protobuf.*;


import java.sql.SQLException;

@GRpcService
public class ReportImpl extends ReportServiceGrpc.ReportServiceImplBase{

	private final ReportPersistence database;

	public ReportImpl(@Qualifier("reportDatabase") ReportPersistence database) {
		this.database = database;
	}
	@Override
	public void reportPost(RequestReportPost request, StreamObserver<ResponseReportPost> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());
		ResponseReportPost response = null;
		try {
			response = database.reportPost(
					request.getViolationDesc(),
					request.getPostId(),
					request.getUserId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();

		System.out.println("Report Created =v \n" + response.toString());
	}

	@Override
	public void getByIdReport(RequestGetByIdReport request, StreamObserver<ResponseGetReport> responseObserver) {
		super.getByIdReport(request, responseObserver);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
