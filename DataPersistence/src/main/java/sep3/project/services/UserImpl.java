package sep3.project.services;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Qualifier;
import sep3.project.daos.UserPersistence;

import java.sql.SQLException;

@GRpcService
public class UserImpl extends UserGrpc.UserImplBase {
    private final UserPersistence database;

    public UserImpl(@Qualifier("userDatabase") UserPersistence database) {
        this.database = database;
    }

    @Override
    public void createUser(RequestCreateUser request, StreamObserver<ResponseCreateUser> responseObserver) {
        System.out.println("Received Request =v \n" + request.toString());
        ResponseCreateUser response = null;
        try {
            response = database.Create(
                    request.getUsername(),
                    request.getFirstName(),
                    request.getLastName(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getPhoneNumber());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("User Created =v \n" + response.toString());
    }
}
