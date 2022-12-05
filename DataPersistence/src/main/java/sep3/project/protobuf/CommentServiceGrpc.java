package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: comment.proto")
public final class CommentServiceGrpc {

  private CommentServiceGrpc() {}

  public static final String SERVICE_NAME = "CommentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateComment,
      sep3.project.protobuf.ResponseCreateComment> getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComment",
      requestType = sep3.project.protobuf.RequestCreateComment.class,
      responseType = sep3.project.protobuf.ResponseCreateComment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateComment,
      sep3.project.protobuf.ResponseCreateComment> getCreateCommentMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateComment, sep3.project.protobuf.ResponseCreateComment> getCreateCommentMethod;
    if ((getCreateCommentMethod = CommentServiceGrpc.getCreateCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getCreateCommentMethod = CommentServiceGrpc.getCreateCommentMethod) == null) {
          CommentServiceGrpc.getCreateCommentMethod = getCreateCommentMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCreateComment, sep3.project.protobuf.ResponseCreateComment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCreateComment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseCreateComment.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("CreateComment"))
              .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestAssignCommentToParent,
      sep3.project.protobuf.EmptyComment> getAssignCommentToParentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignCommentToParent",
      requestType = sep3.project.protobuf.RequestAssignCommentToParent.class,
      responseType = sep3.project.protobuf.EmptyComment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestAssignCommentToParent,
      sep3.project.protobuf.EmptyComment> getAssignCommentToParentMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestAssignCommentToParent, sep3.project.protobuf.EmptyComment> getAssignCommentToParentMethod;
    if ((getAssignCommentToParentMethod = CommentServiceGrpc.getAssignCommentToParentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getAssignCommentToParentMethod = CommentServiceGrpc.getAssignCommentToParentMethod) == null) {
          CommentServiceGrpc.getAssignCommentToParentMethod = getAssignCommentToParentMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestAssignCommentToParent, sep3.project.protobuf.EmptyComment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignCommentToParent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestAssignCommentToParent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyComment.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("AssignCommentToParent"))
              .build();
        }
      }
    }
    return getAssignCommentToParentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetGetByIdComment,
      sep3.project.protobuf.CommentData> getGetByIdCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetByIdComment",
      requestType = sep3.project.protobuf.RequestGetGetByIdComment.class,
      responseType = sep3.project.protobuf.CommentData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetGetByIdComment,
      sep3.project.protobuf.CommentData> getGetByIdCommentMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetGetByIdComment, sep3.project.protobuf.CommentData> getGetByIdCommentMethod;
    if ((getGetByIdCommentMethod = CommentServiceGrpc.getGetByIdCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetByIdCommentMethod = CommentServiceGrpc.getGetByIdCommentMethod) == null) {
          CommentServiceGrpc.getGetByIdCommentMethod = getGetByIdCommentMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetGetByIdComment, sep3.project.protobuf.CommentData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByIdComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetGetByIdComment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.CommentData.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("GetByIdComment"))
              .build();
        }
      }
    }
    return getGetByIdCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByPostComments,
      sep3.project.protobuf.CommentsList> getGetByPostCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetByPostComments",
      requestType = sep3.project.protobuf.RequestGetByPostComments.class,
      responseType = sep3.project.protobuf.CommentsList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByPostComments,
      sep3.project.protobuf.CommentsList> getGetByPostCommentsMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByPostComments, sep3.project.protobuf.CommentsList> getGetByPostCommentsMethod;
    if ((getGetByPostCommentsMethod = CommentServiceGrpc.getGetByPostCommentsMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetByPostCommentsMethod = CommentServiceGrpc.getGetByPostCommentsMethod) == null) {
          CommentServiceGrpc.getGetByPostCommentsMethod = getGetByPostCommentsMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetByPostComments, sep3.project.protobuf.CommentsList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByPostComments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetByPostComments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.CommentsList.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("GetByPostComments"))
              .build();
        }
      }
    }
    return getGetByPostCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetSubComments,
      sep3.project.protobuf.CommentsList> getGetSubCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubComments",
      requestType = sep3.project.protobuf.RequestGetSubComments.class,
      responseType = sep3.project.protobuf.CommentsList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetSubComments,
      sep3.project.protobuf.CommentsList> getGetSubCommentsMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetSubComments, sep3.project.protobuf.CommentsList> getGetSubCommentsMethod;
    if ((getGetSubCommentsMethod = CommentServiceGrpc.getGetSubCommentsMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetSubCommentsMethod = CommentServiceGrpc.getGetSubCommentsMethod) == null) {
          CommentServiceGrpc.getGetSubCommentsMethod = getGetSubCommentsMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetSubComments, sep3.project.protobuf.CommentsList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubComments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetSubComments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.CommentsList.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("GetSubComments"))
              .build();
        }
      }
    }
    return getGetSubCommentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub>() {
        @java.lang.Override
        public CommentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceStub(channel, callOptions);
        }
      };
    return CommentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub>() {
        @java.lang.Override
        public CommentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceBlockingStub(channel, callOptions);
        }
      };
    return CommentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub>() {
        @java.lang.Override
        public CommentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceFutureStub(channel, callOptions);
        }
      };
    return CommentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createComment(sep3.project.protobuf.RequestCreateComment request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateComment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCommentMethod(), responseObserver);
    }

    /**
     */
    public void assignCommentToParent(sep3.project.protobuf.RequestAssignCommentToParent request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyComment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignCommentToParentMethod(), responseObserver);
    }

    /**
     */
    public void getByIdComment(sep3.project.protobuf.RequestGetGetByIdComment request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdCommentMethod(), responseObserver);
    }

    /**
     */
    public void getByPostComments(sep3.project.protobuf.RequestGetByPostComments request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByPostCommentsMethod(), responseObserver);
    }

    /**
     */
    public void getSubComments(sep3.project.protobuf.RequestGetSubComments request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubCommentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestCreateComment,
                sep3.project.protobuf.ResponseCreateComment>(
                  this, METHODID_CREATE_COMMENT)))
          .addMethod(
            getAssignCommentToParentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestAssignCommentToParent,
                sep3.project.protobuf.EmptyComment>(
                  this, METHODID_ASSIGN_COMMENT_TO_PARENT)))
          .addMethod(
            getGetByIdCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetGetByIdComment,
                sep3.project.protobuf.CommentData>(
                  this, METHODID_GET_BY_ID_COMMENT)))
          .addMethod(
            getGetByPostCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetByPostComments,
                sep3.project.protobuf.CommentsList>(
                  this, METHODID_GET_BY_POST_COMMENTS)))
          .addMethod(
            getGetSubCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetSubComments,
                sep3.project.protobuf.CommentsList>(
                  this, METHODID_GET_SUB_COMMENTS)))
          .build();
    }
  }

  /**
   */
  public static final class CommentServiceStub extends io.grpc.stub.AbstractAsyncStub<CommentServiceStub> {
    private CommentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceStub(channel, callOptions);
    }

    /**
     */
    public void createComment(sep3.project.protobuf.RequestCreateComment request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateComment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignCommentToParent(sep3.project.protobuf.RequestAssignCommentToParent request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyComment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignCommentToParentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByIdComment(sep3.project.protobuf.RequestGetGetByIdComment request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByPostComments(sep3.project.protobuf.RequestGetByPostComments request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByPostCommentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSubComments(sep3.project.protobuf.RequestGetSubComments request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubCommentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommentServiceBlockingStub> {
    private CommentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseCreateComment createComment(sep3.project.protobuf.RequestCreateComment request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.EmptyComment assignCommentToParent(sep3.project.protobuf.RequestAssignCommentToParent request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignCommentToParentMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.CommentData getByIdComment(sep3.project.protobuf.RequestGetGetByIdComment request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.CommentsList getByPostComments(sep3.project.protobuf.RequestGetByPostComments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByPostCommentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.CommentsList getSubComments(sep3.project.protobuf.RequestGetSubComments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubCommentsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommentServiceFutureStub> {
    private CommentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseCreateComment> createComment(
        sep3.project.protobuf.RequestCreateComment request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyComment> assignCommentToParent(
        sep3.project.protobuf.RequestAssignCommentToParent request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignCommentToParentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.CommentData> getByIdComment(
        sep3.project.protobuf.RequestGetGetByIdComment request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.CommentsList> getByPostComments(
        sep3.project.protobuf.RequestGetByPostComments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByPostCommentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.CommentsList> getSubComments(
        sep3.project.protobuf.RequestGetSubComments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubCommentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COMMENT = 0;
  private static final int METHODID_ASSIGN_COMMENT_TO_PARENT = 1;
  private static final int METHODID_GET_BY_ID_COMMENT = 2;
  private static final int METHODID_GET_BY_POST_COMMENTS = 3;
  private static final int METHODID_GET_SUB_COMMENTS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment((sep3.project.protobuf.RequestCreateComment) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateComment>) responseObserver);
          break;
        case METHODID_ASSIGN_COMMENT_TO_PARENT:
          serviceImpl.assignCommentToParent((sep3.project.protobuf.RequestAssignCommentToParent) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyComment>) responseObserver);
          break;
        case METHODID_GET_BY_ID_COMMENT:
          serviceImpl.getByIdComment((sep3.project.protobuf.RequestGetGetByIdComment) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentData>) responseObserver);
          break;
        case METHODID_GET_BY_POST_COMMENTS:
          serviceImpl.getByPostComments((sep3.project.protobuf.RequestGetByPostComments) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList>) responseObserver);
          break;
        case METHODID_GET_SUB_COMMENTS:
          serviceImpl.getSubComments((sep3.project.protobuf.RequestGetSubComments) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.CommentsList>) responseObserver);
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

  private static abstract class CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Comment.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommentService");
    }
  }

  private static final class CommentServiceFileDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier {
    CommentServiceFileDescriptorSupplier() {}
  }

  private static final class CommentServiceMethodDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommentServiceFileDescriptorSupplier())
              .addMethod(getCreateCommentMethod())
              .addMethod(getAssignCommentToParentMethod())
              .addMethod(getGetByIdCommentMethod())
              .addMethod(getGetByPostCommentsMethod())
              .addMethod(getGetSubCommentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
