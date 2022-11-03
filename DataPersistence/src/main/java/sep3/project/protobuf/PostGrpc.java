package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: post.proto")
public final class PostGrpc {

  private PostGrpc() {}

  public static final String SERVICE_NAME = "Post";

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
    if ((getCreatePostMethod = PostGrpc.getCreatePostMethod) == null) {
      synchronized (PostGrpc.class) {
        if ((getCreatePostMethod = PostGrpc.getCreatePostMethod) == null) {
          PostGrpc.getCreatePostMethod = getCreatePostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCreatePost, sep3.project.protobuf.ResponseCreatePost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCreatePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseCreatePost.getDefaultInstance()))
              .setSchemaDescriptor(new PostMethodDescriptorSupplier("CreatePost"))
              .build();
        }
      }
    }
    return getCreatePostMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PostStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostStub>() {
        @java.lang.Override
        public PostStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostStub(channel, callOptions);
        }
      };
    return PostStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PostBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostBlockingStub>() {
        @java.lang.Override
        public PostBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostBlockingStub(channel, callOptions);
        }
      };
    return PostBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PostFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PostFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PostFutureStub>() {
        @java.lang.Override
        public PostFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PostFutureStub(channel, callOptions);
        }
      };
    return PostFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PostImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPost(sep3.project.protobuf.RequestCreatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreatePost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePostMethod(), responseObserver);
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
          .build();
    }
  }

  /**
   */
  public static final class PostStub extends io.grpc.stub.AbstractAsyncStub<PostStub> {
    private PostStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostStub(channel, callOptions);
    }

    /**
     */
    public void createPost(sep3.project.protobuf.RequestCreatePost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreatePost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PostBlockingStub extends io.grpc.stub.AbstractBlockingStub<PostBlockingStub> {
    private PostBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseCreatePost createPost(sep3.project.protobuf.RequestCreatePost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePostMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PostFutureStub extends io.grpc.stub.AbstractFutureStub<PostFutureStub> {
    private PostFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PostFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PostFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseCreatePost> createPost(
        sep3.project.protobuf.RequestCreatePost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_POST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PostImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PostImplBase serviceImpl, int methodId) {
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

  private static abstract class PostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PostBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.PostOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Post");
    }
  }

  private static final class PostFileDescriptorSupplier
      extends PostBaseDescriptorSupplier {
    PostFileDescriptorSupplier() {}
  }

  private static final class PostMethodDescriptorSupplier
      extends PostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PostMethodDescriptorSupplier(String methodName) {
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
      synchronized (PostGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PostFileDescriptorSupplier())
              .addMethod(getCreatePostMethod())
              .build();
        }
      }
    }
    return result;
  }
}
