package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: location.proto")
public final class LocationServiceGrpc {

  private LocationServiceGrpc() {}

  public static final String SERVICE_NAME = "LocationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.CoordinatesData> getGetCoordinatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCoordinates",
      requestType = sep3.project.protobuf.LocationId.class,
      responseType = sep3.project.protobuf.CoordinatesData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.CoordinatesData> getGetCoordinatesMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId, sep3.project.protobuf.CoordinatesData> getGetCoordinatesMethod;
    if ((getGetCoordinatesMethod = LocationServiceGrpc.getGetCoordinatesMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getGetCoordinatesMethod = LocationServiceGrpc.getGetCoordinatesMethod) == null) {
          LocationServiceGrpc.getGetCoordinatesMethod = getGetCoordinatesMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.LocationId, sep3.project.protobuf.CoordinatesData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCoordinates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.CoordinatesData.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("GetCoordinates"))
              .build();
        }
      }
    }
    return getGetCoordinatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.AddressData> getGetAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddress",
      requestType = sep3.project.protobuf.LocationId.class,
      responseType = sep3.project.protobuf.AddressData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.AddressData> getGetAddressMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId, sep3.project.protobuf.AddressData> getGetAddressMethod;
    if ((getGetAddressMethod = LocationServiceGrpc.getGetAddressMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getGetAddressMethod = LocationServiceGrpc.getGetAddressMethod) == null) {
          LocationServiceGrpc.getGetAddressMethod = getGetAddressMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.LocationId, sep3.project.protobuf.AddressData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.AddressData.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("GetAddress"))
              .build();
        }
      }
    }
    return getGetAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.LocationData> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = sep3.project.protobuf.LocationId.class,
      responseType = sep3.project.protobuf.LocationData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId,
      sep3.project.protobuf.LocationData> getGetMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.LocationId, sep3.project.protobuf.LocationData> getGetMethod;
    if ((getGetMethod = LocationServiceGrpc.getGetMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getGetMethod = LocationServiceGrpc.getGetMethod) == null) {
          LocationServiceGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.LocationId, sep3.project.protobuf.LocationData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationData.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.LocationData,
      sep3.project.protobuf.LocationId> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = sep3.project.protobuf.LocationData.class,
      responseType = sep3.project.protobuf.LocationId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.LocationData,
      sep3.project.protobuf.LocationId> getCreateMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.LocationData, sep3.project.protobuf.LocationId> getCreateMethod;
    if ((getCreateMethod = LocationServiceGrpc.getCreateMethod) == null) {
      synchronized (LocationServiceGrpc.class) {
        if ((getCreateMethod = LocationServiceGrpc.getCreateMethod) == null) {
          LocationServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.LocationData, sep3.project.protobuf.LocationId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.LocationId.getDefaultInstance()))
              .setSchemaDescriptor(new LocationServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LocationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceStub>() {
        @java.lang.Override
        public LocationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceStub(channel, callOptions);
        }
      };
    return LocationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LocationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceBlockingStub>() {
        @java.lang.Override
        public LocationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceBlockingStub(channel, callOptions);
        }
      };
    return LocationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LocationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LocationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LocationServiceFutureStub>() {
        @java.lang.Override
        public LocationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LocationServiceFutureStub(channel, callOptions);
        }
      };
    return LocationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LocationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCoordinates(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CoordinatesData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCoordinatesMethod(), responseObserver);
    }

    /**
     */
    public void getAddress(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.AddressData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAddressMethod(), responseObserver);
    }

    /**
     */
    public void get(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void create(sep3.project.protobuf.LocationData request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCoordinatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.LocationId,
                sep3.project.protobuf.CoordinatesData>(
                  this, METHODID_GET_COORDINATES)))
          .addMethod(
            getGetAddressMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.LocationId,
                sep3.project.protobuf.AddressData>(
                  this, METHODID_GET_ADDRESS)))
          .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.LocationId,
                sep3.project.protobuf.LocationData>(
                  this, METHODID_GET)))
          .addMethod(
            getCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.LocationData,
                sep3.project.protobuf.LocationId>(
                  this, METHODID_CREATE)))
          .build();
    }
  }

  /**
   */
  public static final class LocationServiceStub extends io.grpc.stub.AbstractAsyncStub<LocationServiceStub> {
    private LocationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCoordinates(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.CoordinatesData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCoordinatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddress(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.AddressData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(sep3.project.protobuf.LocationId request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create(sep3.project.protobuf.LocationData request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LocationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LocationServiceBlockingStub> {
    private LocationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.CoordinatesData getCoordinates(sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCoordinatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.AddressData getAddress(sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.LocationData get(sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.LocationId create(sep3.project.protobuf.LocationData request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LocationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LocationServiceFutureStub> {
    private LocationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LocationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LocationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.CoordinatesData> getCoordinates(
        sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCoordinatesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.AddressData> getAddress(
        sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.LocationData> get(
        sep3.project.protobuf.LocationId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.LocationId> create(
        sep3.project.protobuf.LocationData request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COORDINATES = 0;
  private static final int METHODID_GET_ADDRESS = 1;
  private static final int METHODID_GET = 2;
  private static final int METHODID_CREATE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LocationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LocationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COORDINATES:
          serviceImpl.getCoordinates((sep3.project.protobuf.LocationId) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.CoordinatesData>) responseObserver);
          break;
        case METHODID_GET_ADDRESS:
          serviceImpl.getAddress((sep3.project.protobuf.LocationId) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.AddressData>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((sep3.project.protobuf.LocationId) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationData>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((sep3.project.protobuf.LocationData) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.LocationId>) responseObserver);
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

  private static abstract class LocationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LocationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Location.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LocationService");
    }
  }

  private static final class LocationServiceFileDescriptorSupplier
      extends LocationServiceBaseDescriptorSupplier {
    LocationServiceFileDescriptorSupplier() {}
  }

  private static final class LocationServiceMethodDescriptorSupplier
      extends LocationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LocationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LocationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LocationServiceFileDescriptorSupplier())
              .addMethod(getGetCoordinatesMethod())
              .addMethod(getGetAddressMethod())
              .addMethod(getGetMethod())
              .addMethod(getCreateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
