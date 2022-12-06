package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: post.proto")
public final class PostServiceGrpc {

  private PostServiceGrpc() {}

  public static final String SERVICE_NAME = "PostService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreatePost,
      sep3.project.protobuf.ResponseCreatePost> getCreatePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePost",
      requestType = sep3.project.protobuf.RequestCreatePost.class,
      responseType = sep3.project.protobuf.ResponseCreatePost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreatePost,
      sep3.project.protobuf.ResponseCreatePost> getCreatePostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreatePost, sep3.project.protobuf.ResponseCreatePost> getCreatePostMethod;
    if ((getCreatePostMethod = PostServiceGrpc.getCreatePostMethod) == null) {
      synchronized (PostServiceGrpc.class) {
        if ((getCreatePostMethod = PostServiceGrpc.getCreatePostMethod) == null) {
          PostServiceGrpc.getCreatePostMethod = getCreatePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCreatePost, sep3.project.protobuf.ResponseCreatePost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCreatePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseCreatePost.getDefaultInstance()))
              .setSchemaDescriptor(new PostServiceMethodDescriptorSupplier("CreatePost"))
              .build();
        }
      }
    }
    return getCreatePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPost,
      sep3.project.protobuf.ResponseGetPost> getGetPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPost",
      requestType = sep3.project.protobuf.RequestGetPost.class,
      responseType = sep3.project.protobuf.ResponseGetPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPost,
      sep3.project.protobuf.ResponseGetPost> getGetPostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPost, sep3.project.protobuf.ResponseGetPost> getGetPostMethod;
    if ((getGetPostMethod = PostServiceGrpc.getGetPostMethod) == null) {
      synchronized (PostServiceGrpc.class) {
        if ((getGetPostMethod = PostServiceGrpc.getGetPostMethod) == null) {
          PostServiceGrpc.getGetPostMethod = getGetPostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetPost, sep3.project.protobuf.ResponseGetPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetPost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetPost.getDefaultInstance()))
              .setSchemaDescriptor(new PostServiceMethodDescriptorSupplier("GetPost"))
              .build();
        }
      }
    }
    return getGetPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeletePost,
      sep3.project.protobuf.EmptyPost> getDeletePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePost",
      requestType = sep3.project.protobuf.RequestDeletePost.class,
      responseType = sep3.project.protobuf.EmptyPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeletePost,
      sep3.project.protobuf.EmptyPost> getDeletePostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeletePost, sep3.project.protobuf.EmptyPost> getDeletePostMethod;
    if ((getDeletePostMethod = PostServiceGrpc.getDeletePostMethod) == null) {
      synchronized (PostServiceGrpc.class) {
        if ((getDeletePostMethod = PostServiceGrpc.getDeletePostMethod) == null) {
          PostServiceGrpc.getDeletePostMethod = getDeletePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestDeletePost, sep3.project.protobuf.EmptyPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestDeletePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyPost.getDefaultInstance()))
              .setSchemaDescriptor(new PostServiceMethodDescriptorSupplier("DeletePost"))
              .build();
        }
      }
    }
    return getDeletePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUpdatePost,
      sep3.project.protobuf.ResponseUpdatePost> getUpdatePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePost",
      requestType = sep3.project.protobuf.RequestUpdatePost.class,
      responseType = sep3.project.protobuf.ResponseUpdatePost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUpdatePost,
      sep3.project.protobuf.ResponseUpdatePost> getUpdatePostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestUpdatePost, sep3.project.protobuf.ResponseUpdatePost> getUpdatePostMethod;
    if ((getUpdatePostMethod = PostServiceGrpc.getUpdatePostMethod) == null) {
      synchronized (PostServiceGrpc.class) {
        if ((getUpdatePostMethod = PostServiceGrpc.getUpdatePostMethod) == null) {
          PostServiceGrpc.getUpdatePostMethod = getUpdatePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestUpdatePost, sep3.project.protobuf.ResponseUpdatePost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestUpdatePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseUpdatePost.getDefaultInstance()))
              .setSchemaDescriptor(new PostServiceMethodDescriptorSupplier("UpdatePost"))
              .build();
        }
      }
    }
    return getUpdatePostMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PostServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostServiceStub>() {
        @java.lang.Override
        public PostServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostServiceStub(channel, callOptions);
        }
      };
    return PostServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PostServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostServiceBlockingStub>() {
        @java.lang.Override
        public PostServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostServiceBlockingStub(channel, callOptions);
        }
      };
    return PostServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PostServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostServiceFutureStub>() {
        @java.lang.Override
        public PostServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostServiceFutureStub(channel, callOptions);
        }
      };
    return PostServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PostServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPost(sep3.project.protobuf.RequestCreatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreatePost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePostMethod(), responseObserver);
    }

    /**
     */
    public void getPost(sep3.project.protobuf.RequestGetPost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostMethod(), responseObserver);
    }

    /**
     */
    public void deletePost(sep3.project.protobuf.RequestDeletePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyPost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePostMethod(), responseObserver);
    }

    /**
     */
    public void updatePost(sep3.project.protobuf.RequestUpdatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseUpdatePost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePostMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestCreatePost,
                sep3.project.protobuf.ResponseCreatePost>(
                  this, METHODID_CREATE_POST)))
          .addMethod(
            getGetPostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetPost,
                sep3.project.protobuf.ResponseGetPost>(
                  this, METHODID_GET_POST)))
          .addMethod(
            getDeletePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestDeletePost,
                sep3.project.protobuf.EmptyPost>(
                  this, METHODID_DELETE_POST)))
          .addMethod(
            getUpdatePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestUpdatePost,
                sep3.project.protobuf.ResponseUpdatePost>(
                  this, METHODID_UPDATE_POST)))
          .build();
    }
  }

  /**
   */
  public static final class PostServiceStub extends io.grpc.stub.AbstractAsyncStub<PostServiceStub> {
    private PostServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPost(sep3.project.protobuf.RequestCreatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreatePost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPost(sep3.project.protobuf.RequestGetPost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePost(sep3.project.protobuf.RequestDeletePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyPost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePost(sep3.project.protobuf.RequestUpdatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseUpdatePost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePostMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PostServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PostServiceBlockingStub> {
    private PostServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseCreatePost createPost(sep3.project.protobuf.RequestCreatePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetPost getPost(sep3.project.protobuf.RequestGetPost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.EmptyPost deletePost(sep3.project.protobuf.RequestDeletePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseUpdatePost updatePost(sep3.project.protobuf.RequestUpdatePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePostMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PostServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PostServiceFutureStub> {
    private PostServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseCreatePost> createPost(
        sep3.project.protobuf.RequestCreatePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetPost> getPost(
        sep3.project.protobuf.RequestGetPost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyPost> deletePost(
        sep3.project.protobuf.RequestDeletePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseUpdatePost> updatePost(
        sep3.project.protobuf.RequestUpdatePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePostMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_POST = 0;
  private static final int METHODID_GET_POST = 1;
  private static final int METHODID_DELETE_POST = 2;
  private static final int METHODID_UPDATE_POST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PostServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PostServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_POST:
          serviceImpl.createPost((sep3.project.protobuf.RequestCreatePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreatePost>) responseObserver);
          break;
        case METHODID_GET_POST:
          serviceImpl.getPost((sep3.project.protobuf.RequestGetPost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPost>) responseObserver);
          break;
        case METHODID_DELETE_POST:
          serviceImpl.deletePost((sep3.project.protobuf.RequestDeletePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyPost>) responseObserver);
          break;
        case METHODID_UPDATE_POST:
          serviceImpl.updatePost((sep3.project.protobuf.RequestUpdatePost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseUpdatePost>) responseObserver);
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

  private static abstract class PostServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PostServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Post.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PostService");
    }
  }

  private static final class PostServiceFileDescriptorSupplier
      extends PostServiceBaseDescriptorSupplier {
    PostServiceFileDescriptorSupplier() {}
  }

  private static final class PostServiceMethodDescriptorSupplier
      extends PostServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PostServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PostServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PostServiceFileDescriptorSupplier())
              .addMethod(getCreatePostMethod())
              .addMethod(getGetPostMethod())
              .addMethod(getDeletePostMethod())
              .addMethod(getUpdatePostMethod())
              .build();
        }
      }
    }
    return result;
  }
}
