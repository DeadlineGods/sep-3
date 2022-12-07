package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Like.proto")
public final class LikeServiceGrpc {

  private LikeServiceGrpc() {}

  public static final String SERVICE_NAME = "LikeService";

  // Static method descriptors that strictly reflect the proto.
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
    if ((getLikePostMethod = LikeServiceGrpc.getLikePostMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getLikePostMethod = LikeServiceGrpc.getLikePostMethod) == null) {
          LikeServiceGrpc.getLikePostMethod = getLikePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestLikePost, sep3.project.protobuf.ResponseLikePost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LikePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestLikePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseLikePost.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("LikePost"))
              .build();
        }
      }
    }
    return getLikePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUnLikePost,
      sep3.project.protobuf.LikeEmpty> getUnLikePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnLikePost",
      requestType = sep3.project.protobuf.RequestUnLikePost.class,
      responseType = sep3.project.protobuf.LikeEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUnLikePost,
      sep3.project.protobuf.LikeEmpty> getUnLikePostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUnLikePost, sep3.project.protobuf.LikeEmpty> getUnLikePostMethod;
    if ((getUnLikePostMethod = LikeServiceGrpc.getUnLikePostMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getUnLikePostMethod = LikeServiceGrpc.getUnLikePostMethod) == null) {
          LikeServiceGrpc.getUnLikePostMethod = getUnLikePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestUnLikePost, sep3.project.protobuf.LikeEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnLikePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestUnLikePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LikeEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("UnLikePost"))
              .build();
        }
      }
    }
    return getUnLikePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestIsPostLiked,
      sep3.project.protobuf.ResponseIsPostLiked> getIsPostLikedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsPostLiked",
      requestType = sep3.project.protobuf.RequestIsPostLiked.class,
      responseType = sep3.project.protobuf.ResponseIsPostLiked.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestIsPostLiked,
      sep3.project.protobuf.ResponseIsPostLiked> getIsPostLikedMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestIsPostLiked, sep3.project.protobuf.ResponseIsPostLiked> getIsPostLikedMethod;
    if ((getIsPostLikedMethod = LikeServiceGrpc.getIsPostLikedMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getIsPostLikedMethod = LikeServiceGrpc.getIsPostLikedMethod) == null) {
          LikeServiceGrpc.getIsPostLikedMethod = getIsPostLikedMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestIsPostLiked, sep3.project.protobuf.ResponseIsPostLiked>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IsPostLiked"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestIsPostLiked.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseIsPostLiked.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("IsPostLiked"))
              .build();
        }
      }
    }
    return getIsPostLikedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCountLikes,
      sep3.project.protobuf.ResponseCountLikes> getCountLikesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CountLikes",
      requestType = sep3.project.protobuf.RequestCountLikes.class,
      responseType = sep3.project.protobuf.ResponseCountLikes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCountLikes,
      sep3.project.protobuf.ResponseCountLikes> getCountLikesMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCountLikes, sep3.project.protobuf.ResponseCountLikes> getCountLikesMethod;
    if ((getCountLikesMethod = LikeServiceGrpc.getCountLikesMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getCountLikesMethod = LikeServiceGrpc.getCountLikesMethod) == null) {
          LikeServiceGrpc.getCountLikesMethod = getCountLikesMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCountLikes, sep3.project.protobuf.ResponseCountLikes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CountLikes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCountLikes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseCountLikes.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("CountLikes"))
              .build();
        }
      }
    }
    return getCountLikesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteLikes,
      sep3.project.protobuf.LikeEmpty> getDeleteLikesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLikes",
      requestType = sep3.project.protobuf.RequestDeleteLikes.class,
      responseType = sep3.project.protobuf.LikeEmpty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteLikes,
      sep3.project.protobuf.LikeEmpty> getDeleteLikesMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteLikes, sep3.project.protobuf.LikeEmpty> getDeleteLikesMethod;
    if ((getDeleteLikesMethod = LikeServiceGrpc.getDeleteLikesMethod) == null) {
      synchronized (LikeServiceGrpc.class) {
        if ((getDeleteLikesMethod = LikeServiceGrpc.getDeleteLikesMethod) == null) {
          LikeServiceGrpc.getDeleteLikesMethod = getDeleteLikesMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestDeleteLikes, sep3.project.protobuf.LikeEmpty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLikes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestDeleteLikes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LikeEmpty.getDefaultInstance()))
              .setSchemaDescriptor(new LikeServiceMethodDescriptorSupplier("DeleteLikes"))
              .build();
        }
      }
    }
    return getDeleteLikesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LikeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceStub>() {
        @java.lang.Override
        public LikeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceStub(channel, callOptions);
        }
      };
    return LikeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LikeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceBlockingStub>() {
        @java.lang.Override
        public LikeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceBlockingStub(channel, callOptions);
        }
      };
    return LikeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LikeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LikeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LikeServiceFutureStub>() {
        @java.lang.Override
        public LikeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LikeServiceFutureStub(channel, callOptions);
        }
      };
    return LikeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LikeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void likePost(sep3.project.protobuf.RequestLikePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseLikePost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLikePostMethod(), responseObserver);
    }

    /**
     */
    public void unLikePost(sep3.project.protobuf.RequestUnLikePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnLikePostMethod(), responseObserver);
    }

    /**
     */
    public void isPostLiked(sep3.project.protobuf.RequestIsPostLiked request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseIsPostLiked> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsPostLikedMethod(), responseObserver);
    }

    /**
     */
    public void countLikes(sep3.project.protobuf.RequestCountLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCountLikes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCountLikesMethod(), responseObserver);
    }

    /**
     */
    public void deleteLikes(sep3.project.protobuf.RequestDeleteLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLikesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLikePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestLikePost,
                sep3.project.protobuf.ResponseLikePost>(
                  this, METHODID_LIKE_POST)))
          .addMethod(
            getUnLikePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestUnLikePost,
                sep3.project.protobuf.LikeEmpty>(
                  this, METHODID_UN_LIKE_POST)))
          .addMethod(
            getIsPostLikedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestIsPostLiked,
                sep3.project.protobuf.ResponseIsPostLiked>(
                  this, METHODID_IS_POST_LIKED)))
          .addMethod(
            getCountLikesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestCountLikes,
                sep3.project.protobuf.ResponseCountLikes>(
                  this, METHODID_COUNT_LIKES)))
          .addMethod(
            getDeleteLikesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestDeleteLikes,
                sep3.project.protobuf.LikeEmpty>(
                  this, METHODID_DELETE_LIKES)))
          .build();
    }
  }

  /**
   */
  public static final class LikeServiceStub extends io.grpc.stub.AbstractAsyncStub<LikeServiceStub> {
    private LikeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceStub(channel, callOptions);
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
    public void unLikePost(sep3.project.protobuf.RequestUnLikePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnLikePostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isPostLiked(sep3.project.protobuf.RequestIsPostLiked request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseIsPostLiked> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsPostLikedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void countLikes(sep3.project.protobuf.RequestCountLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCountLikes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCountLikesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteLikes(sep3.project.protobuf.RequestDeleteLikes request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLikesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LikeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LikeServiceBlockingStub> {
    private LikeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseLikePost likePost(sep3.project.protobuf.RequestLikePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLikePostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.LikeEmpty unLikePost(sep3.project.protobuf.RequestUnLikePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnLikePostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseIsPostLiked isPostLiked(sep3.project.protobuf.RequestIsPostLiked request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsPostLikedMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseCountLikes countLikes(sep3.project.protobuf.RequestCountLikes request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCountLikesMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.LikeEmpty deleteLikes(sep3.project.protobuf.RequestDeleteLikes request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLikesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LikeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LikeServiceFutureStub> {
    private LikeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LikeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LikeServiceFutureStub(channel, callOptions);
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
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.LikeEmpty> unLikePost(
        sep3.project.protobuf.RequestUnLikePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnLikePostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseIsPostLiked> isPostLiked(
        sep3.project.protobuf.RequestIsPostLiked request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsPostLikedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseCountLikes> countLikes(
        sep3.project.protobuf.RequestCountLikes request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCountLikesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.LikeEmpty> deleteLikes(
        sep3.project.protobuf.RequestDeleteLikes request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLikesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIKE_POST = 0;
  private static final int METHODID_UN_LIKE_POST = 1;
  private static final int METHODID_IS_POST_LIKED = 2;
  private static final int METHODID_COUNT_LIKES = 3;
  private static final int METHODID_DELETE_LIKES = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LikeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LikeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIKE_POST:
          serviceImpl.likePost((sep3.project.protobuf.RequestLikePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseLikePost>) responseObserver);
          break;
        case METHODID_UN_LIKE_POST:
          serviceImpl.unLikePost((sep3.project.protobuf.RequestUnLikePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty>) responseObserver);
          break;
        case METHODID_IS_POST_LIKED:
          serviceImpl.isPostLiked((sep3.project.protobuf.RequestIsPostLiked) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseIsPostLiked>) responseObserver);
          break;
        case METHODID_COUNT_LIKES:
          serviceImpl.countLikes((sep3.project.protobuf.RequestCountLikes) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCountLikes>) responseObserver);
          break;
        case METHODID_DELETE_LIKES:
          serviceImpl.deleteLikes((sep3.project.protobuf.RequestDeleteLikes) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.LikeEmpty>) responseObserver);
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

  private static abstract class LikeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LikeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Like.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LikeService");
    }
  }

  private static final class LikeServiceFileDescriptorSupplier
      extends LikeServiceBaseDescriptorSupplier {
    LikeServiceFileDescriptorSupplier() {}
  }

  private static final class LikeServiceMethodDescriptorSupplier
      extends LikeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LikeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LikeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LikeServiceFileDescriptorSupplier())
              .addMethod(getLikePostMethod())
              .addMethod(getUnLikePostMethod())
              .addMethod(getIsPostLikedMethod())
              .addMethod(getCountLikesMethod())
              .addMethod(getDeleteLikesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
