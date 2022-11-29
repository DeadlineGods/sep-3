package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateUser,
      sep3.project.protobuf.UserData> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = sep3.project.protobuf.RequestCreateUser.class,
      responseType = sep3.project.protobuf.UserData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateUser,
      sep3.project.protobuf.UserData> getCreateUserMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateUser, sep3.project.protobuf.UserData> getCreateUserMethod;
    if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateUserMethod = UserServiceGrpc.getCreateUserMethod) == null) {
          UserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCreateUser, sep3.project.protobuf.UserData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCreateUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.UserData.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestLikePost,
      sep3.project.protobuf.ResponseLikePost> getLikePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LikePost",
      requestType = sep3.project.protobuf.RequestLikePost.class,
      responseType = sep3.project.protobuf.ResponseLikePost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestLikePost,
      sep3.project.protobuf.ResponseLikePost> getLikePostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestLikePost, sep3.project.protobuf.ResponseLikePost> getLikePostMethod;
    if ((getLikePostMethod = UserServiceGrpc.getLikePostMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLikePostMethod = UserServiceGrpc.getLikePostMethod) == null) {
          UserServiceGrpc.getLikePostMethod = getLikePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestLikePost, sep3.project.protobuf.ResponseLikePost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LikePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestLikePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseLikePost.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("LikePost"))
              .build();
        }
      }
    }
    return getLikePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetUsers,
      sep3.project.protobuf.ResponseGetUsers> getGetUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUsers",
      requestType = sep3.project.protobuf.RequestGetUsers.class,
      responseType = sep3.project.protobuf.ResponseGetUsers.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetUsers,
      sep3.project.protobuf.ResponseGetUsers> getGetUsersMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetUsers, sep3.project.protobuf.ResponseGetUsers> getGetUsersMethod;
    if ((getGetUsersMethod = UserServiceGrpc.getGetUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUsersMethod = UserServiceGrpc.getGetUsersMethod) == null) {
          UserServiceGrpc.getGetUsersMethod = getGetUsersMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetUsers, sep3.project.protobuf.ResponseGetUsers>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetUsers.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetUsers.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUsers"))
              .build();
        }
      }
    }
    return getGetUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetLikes,
      sep3.project.protobuf.ResponseGetLikes> getGetLikesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLikes",
      requestType = sep3.project.protobuf.RequestGetLikes.class,
      responseType = sep3.project.protobuf.ResponseGetLikes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetLikes,
      sep3.project.protobuf.ResponseGetLikes> getGetLikesMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetLikes, sep3.project.protobuf.ResponseGetLikes> getGetLikesMethod;
    if ((getGetLikesMethod = UserServiceGrpc.getGetLikesMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetLikesMethod = UserServiceGrpc.getGetLikesMethod) == null) {
          UserServiceGrpc.getGetLikesMethod = getGetLikesMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetLikes, sep3.project.protobuf.ResponseGetLikes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLikes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetLikes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetLikes.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetLikes"))
              .build();
        }
      }
    }
    return getGetLikesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(sep3.project.protobuf.RequestCreateUser request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.UserData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void likePost(sep3.project.protobuf.RequestLikePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseLikePost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLikePostMethod(), responseObserver);
    }

    /**
     */
    public void getUsers(sep3.project.protobuf.RequestGetUsers request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetUsers> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsersMethod(), responseObserver);
    }

    /**
     */
    public void getLikes(sep3.project.protobuf.RequestGetLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetLikes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLikesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestCreateUser,
                sep3.project.protobuf.UserData>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getLikePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestLikePost,
                sep3.project.protobuf.ResponseLikePost>(
                  this, METHODID_LIKE_POST)))
          .addMethod(
            getGetUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetUsers,
                sep3.project.protobuf.ResponseGetUsers>(
                  this, METHODID_GET_USERS)))
          .addMethod(
            getGetLikesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetLikes,
                sep3.project.protobuf.ResponseGetLikes>(
                  this, METHODID_GET_LIKES)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(sep3.project.protobuf.RequestCreateUser request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.UserData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void likePost(sep3.project.protobuf.RequestLikePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseLikePost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLikePostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsers(sep3.project.protobuf.RequestGetUsers request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetUsers> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLikes(sep3.project.protobuf.RequestGetLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetLikes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLikesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.UserData createUser(sep3.project.protobuf.RequestCreateUser request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseLikePost likePost(sep3.project.protobuf.RequestLikePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLikePostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetUsers getUsers(sep3.project.protobuf.RequestGetUsers request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetLikes getLikes(sep3.project.protobuf.RequestGetLikes request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLikesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.UserData> createUser(
        sep3.project.protobuf.RequestCreateUser request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseLikePost> likePost(
        sep3.project.protobuf.RequestLikePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLikePostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetUsers> getUsers(
        sep3.project.protobuf.RequestGetUsers request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetLikes> getLikes(
        sep3.project.protobuf.RequestGetLikes request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLikesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_LIKE_POST = 1;
  private static final int METHODID_GET_USERS = 2;
  private static final int METHODID_GET_LIKES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((sep3.project.protobuf.RequestCreateUser) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.UserData>) responseObserver);
          break;
        case METHODID_LIKE_POST:
          serviceImpl.likePost((sep3.project.protobuf.RequestLikePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseLikePost>) responseObserver);
          break;
        case METHODID_GET_USERS:
          serviceImpl.getUsers((sep3.project.protobuf.RequestGetUsers) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetUsers>) responseObserver);
          break;
        case METHODID_GET_LIKES:
          serviceImpl.getLikes((sep3.project.protobuf.RequestGetLikes) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetLikes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getLikePostMethod())
              .addMethod(getGetUsersMethod())
              .addMethod(getGetLikesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
