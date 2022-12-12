package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: test.proto")
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getRestartDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartDatabase",
      requestType = sep3.project.protobuf.EmptyTest.class,
      responseType = sep3.project.protobuf.EmptyTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getRestartDatabaseMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest> getRestartDatabaseMethod;
    if ((getRestartDatabaseMethod = TestServiceGrpc.getRestartDatabaseMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getRestartDatabaseMethod = TestServiceGrpc.getRestartDatabaseMethod) == null) {
          TestServiceGrpc.getRestartDatabaseMethod = getRestartDatabaseMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("RestartDatabase"))
              .build();
        }
      }
    }
    return getRestartDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getSwitchToTestDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchToTestDatabase",
      requestType = sep3.project.protobuf.EmptyTest.class,
      responseType = sep3.project.protobuf.EmptyTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getSwitchToTestDatabaseMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest> getSwitchToTestDatabaseMethod;
    if ((getSwitchToTestDatabaseMethod = TestServiceGrpc.getSwitchToTestDatabaseMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getSwitchToTestDatabaseMethod = TestServiceGrpc.getSwitchToTestDatabaseMethod) == null) {
          TestServiceGrpc.getSwitchToTestDatabaseMethod = getSwitchToTestDatabaseMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchToTestDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("SwitchToTestDatabase"))
              .build();
        }
      }
    }
    return getSwitchToTestDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getSwitchToProductionDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchToProductionDatabase",
      requestType = sep3.project.protobuf.EmptyTest.class,
      responseType = sep3.project.protobuf.EmptyTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest,
      sep3.project.protobuf.EmptyTest> getSwitchToProductionDatabaseMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest> getSwitchToProductionDatabaseMethod;
    if ((getSwitchToProductionDatabaseMethod = TestServiceGrpc.getSwitchToProductionDatabaseMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getSwitchToProductionDatabaseMethod = TestServiceGrpc.getSwitchToProductionDatabaseMethod) == null) {
          TestServiceGrpc.getSwitchToProductionDatabaseMethod = getSwitchToProductionDatabaseMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.EmptyTest, sep3.project.protobuf.EmptyTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SwitchToProductionDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTest.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("SwitchToProductionDatabase"))
              .build();
        }
      }
    }
    return getSwitchToProductionDatabaseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void restartDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestartDatabaseMethod(), responseObserver);
    }

    /**
     */
    public void switchToTestDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchToTestDatabaseMethod(), responseObserver);
    }

    /**
     */
    public void switchToProductionDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchToProductionDatabaseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRestartDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.EmptyTest,
                sep3.project.protobuf.EmptyTest>(
                  this, METHODID_RESTART_DATABASE)))
          .addMethod(
            getSwitchToTestDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.EmptyTest,
                sep3.project.protobuf.EmptyTest>(
                  this, METHODID_SWITCH_TO_TEST_DATABASE)))
          .addMethod(
            getSwitchToProductionDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.EmptyTest,
                sep3.project.protobuf.EmptyTest>(
                  this, METHODID_SWITCH_TO_PRODUCTION_DATABASE)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     */
    public void restartDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchToTestDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchToTestDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchToProductionDatabase(sep3.project.protobuf.EmptyTest request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchToProductionDatabaseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.EmptyTest restartDatabase(sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartDatabaseMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.EmptyTest switchToTestDatabase(sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchToTestDatabaseMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.EmptyTest switchToProductionDatabase(sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchToProductionDatabaseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyTest> restartDatabase(
        sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartDatabaseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyTest> switchToTestDatabase(
        sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchToTestDatabaseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyTest> switchToProductionDatabase(
        sep3.project.protobuf.EmptyTest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchToProductionDatabaseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESTART_DATABASE = 0;
  private static final int METHODID_SWITCH_TO_TEST_DATABASE = 1;
  private static final int METHODID_SWITCH_TO_PRODUCTION_DATABASE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RESTART_DATABASE:
          serviceImpl.restartDatabase((sep3.project.protobuf.EmptyTest) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest>) responseObserver);
          break;
        case METHODID_SWITCH_TO_TEST_DATABASE:
          serviceImpl.switchToTestDatabase((sep3.project.protobuf.EmptyTest) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest>) responseObserver);
          break;
        case METHODID_SWITCH_TO_PRODUCTION_DATABASE:
          serviceImpl.switchToProductionDatabase((sep3.project.protobuf.EmptyTest) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTest>) responseObserver);
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

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Test.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getRestartDatabaseMethod())
              .addMethod(getSwitchToTestDatabaseMethod())
              .addMethod(getSwitchToProductionDatabaseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
