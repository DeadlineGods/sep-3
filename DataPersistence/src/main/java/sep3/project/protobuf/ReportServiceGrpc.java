package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: report.proto")
public final class ReportServiceGrpc {

  private ReportServiceGrpc() {}

  public static final String SERVICE_NAME = "ReportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestReportPost,
      sep3.project.protobuf.ResponseReportPost> getReportPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportPost",
      requestType = sep3.project.protobuf.RequestReportPost.class,
      responseType = sep3.project.protobuf.ResponseReportPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestReportPost,
      sep3.project.protobuf.ResponseReportPost> getReportPostMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestReportPost, sep3.project.protobuf.ResponseReportPost> getReportPostMethod;
    if ((getReportPostMethod = ReportServiceGrpc.getReportPostMethod) == null) {
      synchronized (ReportServiceGrpc.class) {
        if ((getReportPostMethod = ReportServiceGrpc.getReportPostMethod) == null) {
          ReportServiceGrpc.getReportPostMethod = getReportPostMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestReportPost, sep3.project.protobuf.ResponseReportPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestReportPost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseReportPost.getDefaultInstance()))
              .setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("ReportPost"))
              .build();
        }
      }
    }
    return getReportPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByIdReport,
      sep3.project.protobuf.ReportData> getGetByIdReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetByIdReport",
      requestType = sep3.project.protobuf.RequestGetByIdReport.class,
      responseType = sep3.project.protobuf.ReportData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByIdReport,
      sep3.project.protobuf.ReportData> getGetByIdReportMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetByIdReport, sep3.project.protobuf.ReportData> getGetByIdReportMethod;
    if ((getGetByIdReportMethod = ReportServiceGrpc.getGetByIdReportMethod) == null) {
      synchronized (ReportServiceGrpc.class) {
        if ((getGetByIdReportMethod = ReportServiceGrpc.getGetByIdReportMethod) == null) {
          ReportServiceGrpc.getGetByIdReportMethod = getGetByIdReportMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetByIdReport, sep3.project.protobuf.ReportData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByIdReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetByIdReport.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ReportData.getDefaultInstance()))
              .setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("GetByIdReport"))
              .build();
        }
      }
    }
    return getGetByIdReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.ReportEmpty,
      sep3.project.protobuf.ResponseGetReports> getGetReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReports",
      requestType = sep3.project.protobuf.ReportEmpty.class,
      responseType = sep3.project.protobuf.ResponseGetReports.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.ReportEmpty,
      sep3.project.protobuf.ResponseGetReports> getGetReportsMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.ReportEmpty, sep3.project.protobuf.ResponseGetReports> getGetReportsMethod;
    if ((getGetReportsMethod = ReportServiceGrpc.getGetReportsMethod) == null) {
      synchronized (ReportServiceGrpc.class) {
        if ((getGetReportsMethod = ReportServiceGrpc.getGetReportsMethod) == null) {
          ReportServiceGrpc.getGetReportsMethod = getGetReportsMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.ReportEmpty, sep3.project.protobuf.ResponseGetReports>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReports"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ReportEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetReports.getDefaultInstance()))
              .setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("GetReports"))
              .build();
        }
      }
    }
    return getGetReportsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceStub>() {
        @java.lang.Override
        public ReportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceStub(channel, callOptions);
        }
      };
    return ReportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceBlockingStub>() {
        @java.lang.Override
        public ReportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceBlockingStub(channel, callOptions);
        }
      };
    return ReportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReportServiceFutureStub>() {
        @java.lang.Override
        public ReportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReportServiceFutureStub(channel, callOptions);
        }
      };
    return ReportServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ReportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void reportPost(sep3.project.protobuf.RequestReportPost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseReportPost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportPostMethod(), responseObserver);
    }

    /**
     */
    public void getByIdReport(sep3.project.protobuf.RequestGetByIdReport request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ReportData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdReportMethod(), responseObserver);
    }

    /**
     */
    public void getReports(sep3.project.protobuf.ReportEmpty request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetReports> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReportsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReportPostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestReportPost,
                sep3.project.protobuf.ResponseReportPost>(
                  this, METHODID_REPORT_POST)))
          .addMethod(
            getGetByIdReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetByIdReport,
                sep3.project.protobuf.ReportData>(
                  this, METHODID_GET_BY_ID_REPORT)))
          .addMethod(
            getGetReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.ReportEmpty,
                sep3.project.protobuf.ResponseGetReports>(
                  this, METHODID_GET_REPORTS)))
          .build();
    }
  }

  /**
   */
  public static final class ReportServiceStub extends io.grpc.stub.AbstractAsyncStub<ReportServiceStub> {
    private ReportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceStub(channel, callOptions);
    }

    /**
     */
    public void reportPost(sep3.project.protobuf.RequestReportPost request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseReportPost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByIdReport(sep3.project.protobuf.RequestGetByIdReport request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ReportData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReports(sep3.project.protobuf.ReportEmpty request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetReports> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReportsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ReportServiceBlockingStub> {
    private ReportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseReportPost reportPost(sep3.project.protobuf.RequestReportPost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ReportData getByIdReport(sep3.project.protobuf.RequestGetByIdReport request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdReportMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetReports getReports(sep3.project.protobuf.ReportEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReportsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ReportServiceFutureStub> {
    private ReportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseReportPost> reportPost(
        sep3.project.protobuf.RequestReportPost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ReportData> getByIdReport(
        sep3.project.protobuf.RequestGetByIdReport request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdReportMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetReports> getReports(
        sep3.project.protobuf.ReportEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_POST = 0;
  private static final int METHODID_GET_BY_ID_REPORT = 1;
  private static final int METHODID_GET_REPORTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_POST:
          serviceImpl.reportPost((sep3.project.protobuf.RequestReportPost) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseReportPost>) responseObserver);
          break;
        case METHODID_GET_BY_ID_REPORT:
          serviceImpl.getByIdReport((sep3.project.protobuf.RequestGetByIdReport) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ReportData>) responseObserver);
          break;
        case METHODID_GET_REPORTS:
          serviceImpl.getReports((sep3.project.protobuf.ReportEmpty) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetReports>) responseObserver);
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

  private static abstract class ReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Report.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportService");
    }
  }

  private static final class ReportServiceFileDescriptorSupplier
      extends ReportServiceBaseDescriptorSupplier {
    ReportServiceFileDescriptorSupplier() {}
  }

  private static final class ReportServiceMethodDescriptorSupplier
      extends ReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReportServiceFileDescriptorSupplier())
              .addMethod(getReportPostMethod())
              .addMethod(getGetByIdReportMethod())
              .addMethod(getGetReportsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
