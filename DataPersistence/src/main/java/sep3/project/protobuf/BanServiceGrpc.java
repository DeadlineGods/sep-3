package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: ban.proto")
public final class BanServiceGrpc {

  private BanServiceGrpc() {}

  public static final String SERVICE_NAME = "BanService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.BanData,
      sep3.project.protobuf.PostId> getBanPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BanPost",
      requestType = sep3.project.protobuf.BanData.class,
      responseType = sep3.project.protobuf.PostId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.BanData,
      sep3.project.protobuf.PostId> getBanPostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.BanData, sep3.project.protobuf.PostId> getBanPostMethod;
    if ((getBanPostMethod = BanServiceGrpc.getBanPostMethod) == null) {
      synchronized (BanServiceGrpc.class) {
        if ((getBanPostMethod = BanServiceGrpc.getBanPostMethod) == null) {
          BanServiceGrpc.getBanPostMethod = getBanPostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.BanData, sep3.project.protobuf.PostId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BanPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.BanData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.PostId.getDefaultInstance()))
              .setSchemaDescriptor(new BanServiceMethodDescriptorSupplier("BanPost"))
              .build();
        }
      }
    }
    return getBanPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.PostId,
      sep3.project.protobuf.PostId> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = sep3.project.protobuf.PostId.class,
      responseType = sep3.project.protobuf.PostId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.PostId,
      sep3.project.protobuf.PostId> getGetMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.PostId, sep3.project.protobuf.PostId> getGetMethod;
    if ((getGetMethod = BanServiceGrpc.getGetMethod) == null) {
      synchronized (BanServiceGrpc.class) {
        if ((getGetMethod = BanServiceGrpc.getGetMethod) == null) {
          BanServiceGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.PostId, sep3.project.protobuf.PostId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.PostId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.PostId.getDefaultInstance()))
              .setSchemaDescriptor(new BanServiceMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BanServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BanServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BanServiceStub>() {
        @java.lang.Override
        public BanServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BanServiceStub(channel, callOptions);
        }
      };
    return BanServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BanServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BanServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BanServiceBlockingStub>() {
        @java.lang.Override
        public BanServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BanServiceBlockingStub(channel, callOptions);
        }
      };
    return BanServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BanServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BanServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BanServiceFutureStub>() {
        @java.lang.Override
        public BanServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BanServiceFutureStub(channel, callOptions);
        }
      };
    return BanServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BanServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void banPost(sep3.project.protobuf.BanData request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBanPostMethod(), responseObserver);
    }

    /**
     */
    public void get(sep3.project.protobuf.PostId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBanPostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.BanData,
                sep3.project.protobuf.PostId>(
                  this, METHODID_BAN_POST)))
          .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.PostId,
                sep3.project.protobuf.PostId>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   */
  public static final class BanServiceStub extends io.grpc.stub.AbstractAsyncStub<BanServiceStub> {
    private BanServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BanServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BanServiceStub(channel, callOptions);
    }

    /**
     */
    public void banPost(sep3.project.protobuf.BanData request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBanPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(sep3.project.protobuf.PostId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BanServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BanServiceBlockingStub> {
    private BanServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BanServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BanServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.PostId banPost(sep3.project.protobuf.BanData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBanPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.PostId get(sep3.project.protobuf.PostId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BanServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BanServiceFutureStub> {
    private BanServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BanServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BanServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.PostId> banPost(
        sep3.project.protobuf.BanData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBanPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.PostId> get(
        sep3.project.protobuf.PostId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BAN_POST = 0;
  private static final int METHODID_GET = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BanServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BanServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BAN_POST:
          serviceImpl.banPost((sep3.project.protobuf.BanData) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((sep3.project.protobuf.PostId) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.PostId>) responseObserver);
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

  private static abstract class BanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BanServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Ban.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BanService");
    }
  }

  private static final class BanServiceFileDescriptorSupplier
      extends BanServiceBaseDescriptorSupplier {
    BanServiceFileDescriptorSupplier() {}
  }

  private static final class BanServiceMethodDescriptorSupplier
      extends BanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BanServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BanServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BanServiceFileDescriptorSupplier())
              .addMethod(getBanPostMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
