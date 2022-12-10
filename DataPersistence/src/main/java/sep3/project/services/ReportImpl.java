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
	public void getByIdReport(RequestGetByIdReport request, StreamObserver<ReportData> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());
		ReportData response = null;
		try {
			response = database.getById(request.getReportId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();

		System.out.println("Report =v \n" + response.toString());
	}

	@Override
	public void getReports(ReportEmpty request, StreamObserver<ResponseGetReports> responseObserver) {
		System.out.println("Received Request =v \n" + request.toString());
		ResponseGetReports response = null;
		try {
			response = database.get();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();

		System.out.println("Reports =v \n" + response.toString());
	}
}
