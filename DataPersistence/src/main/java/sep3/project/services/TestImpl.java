package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import sep3.project.persistance.DBConnection;
import sep3.project.protobuf.EmptyTest;
import sep3.project.protobuf.TestServiceGrpc;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@GRpcService
public class TestImpl extends TestServiceGrpc.TestServiceImplBase {
    @Override
    public void restartDatabase(EmptyTest request, StreamObserver<EmptyTest> responseObserver) {
        System.out.println("Restarting test database");

        try {
            DBConnection.restartTestDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        EmptyTest response = EmptyTest.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Restarted test database");
    }

    @Override
    public void switchToTestDatabase(EmptyTest request, StreamObserver<EmptyTest> responseObserver) {
        System.out.println("Setting to test database");
        DBConnection.setToTest();

        EmptyTest response = EmptyTest.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Set to test database");
    }

    @Override
    public void switchToProductionDatabase(EmptyTest request, StreamObserver<EmptyTest> responseObserver) {
        System.out.println("Setting to production database");
        DBConnection.setToProduction();

        EmptyTest response = EmptyTest.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Set to test production");
    }
}
