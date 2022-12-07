package sep3.project.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: tag.proto")
public final class TagServiceGrpc {

  private TagServiceGrpc() {}

  public static final String SERVICE_NAME = "TagService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateTags,
      sep3.project.protobuf.ResponseCreateTag> getCreateTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTags",
      requestType = sep3.project.protobuf.RequestCreateTags.class,
      responseType = sep3.project.protobuf.ResponseCreateTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateTags,
      sep3.project.protobuf.ResponseCreateTag> getCreateTagsMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestCreateTags, sep3.project.protobuf.ResponseCreateTag> getCreateTagsMethod;
    if ((getCreateTagsMethod = TagServiceGrpc.getCreateTagsMethod) == null) {
      synchronized (TagServiceGrpc.class) {
        if ((getCreateTagsMethod = TagServiceGrpc.getCreateTagsMethod) == null) {
          TagServiceGrpc.getCreateTagsMethod = getCreateTagsMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestCreateTags, sep3.project.protobuf.ResponseCreateTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTags"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestCreateTags.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseCreateTag.getDefaultInstance()))
              .setSchemaDescriptor(new TagServiceMethodDescriptorSupplier("CreateTags"))
              .build();
        }
      }
    }
    return getCreateTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPostTag,
      sep3.project.protobuf.ResponseGetPostTag> getGetPostTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPostTag",
      requestType = sep3.project.protobuf.RequestGetPostTag.class,
      responseType = sep3.project.protobuf.ResponseGetPostTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPostTag,
      sep3.project.protobuf.ResponseGetPostTag> getGetPostTagMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetPostTag, sep3.project.protobuf.ResponseGetPostTag> getGetPostTagMethod;
    if ((getGetPostTagMethod = TagServiceGrpc.getGetPostTagMethod) == null) {
      synchronized (TagServiceGrpc.class) {
        if ((getGetPostTagMethod = TagServiceGrpc.getGetPostTagMethod) == null) {
          TagServiceGrpc.getGetPostTagMethod = getGetPostTagMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetPostTag, sep3.project.protobuf.ResponseGetPostTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPostTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetPostTag.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetPostTag.getDefaultInstance()))
              .setSchemaDescriptor(new TagServiceMethodDescriptorSupplier("GetPostTag"))
              .build();
        }
      }
    }
    return getGetPostTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetTagList,
      sep3.project.protobuf.ResponseGetTagList> getGetTagListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTagList",
      requestType = sep3.project.protobuf.RequestGetTagList.class,
      responseType = sep3.project.protobuf.ResponseGetTagList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetTagList,
      sep3.project.protobuf.ResponseGetTagList> getGetTagListMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestGetTagList, sep3.project.protobuf.ResponseGetTagList> getGetTagListMethod;
    if ((getGetTagListMethod = TagServiceGrpc.getGetTagListMethod) == null) {
      synchronized (TagServiceGrpc.class) {
        if ((getGetTagListMethod = TagServiceGrpc.getGetTagListMethod) == null) {
          TagServiceGrpc.getGetTagListMethod = getGetTagListMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestGetTagList, sep3.project.protobuf.ResponseGetTagList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTagList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestGetTagList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.ResponseGetTagList.getDefaultInstance()))
              .setSchemaDescriptor(new TagServiceMethodDescriptorSupplier("GetTagList"))
              .build();
        }
      }
    }
    return getGetTagListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteTag,
      sep3.project.protobuf.EmptyTag> getDeleteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTag",
      requestType = sep3.project.protobuf.RequestDeleteTag.class,
      responseType = sep3.project.protobuf.EmptyTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteTag,
      sep3.project.protobuf.EmptyTag> getDeleteTagMethod() {
    io.grpc.MethodDescriptor<sep3.project.protobuf.RequestDeleteTag, sep3.project.protobuf.EmptyTag> getDeleteTagMethod;
    if ((getDeleteTagMethod = TagServiceGrpc.getDeleteTagMethod) == null) {
      synchronized (TagServiceGrpc.class) {
        if ((getDeleteTagMethod = TagServiceGrpc.getDeleteTagMethod) == null) {
          TagServiceGrpc.getDeleteTagMethod = getDeleteTagMethod =
              io.grpc.MethodDescriptor.<sep3.project.protobuf.RequestDeleteTag, sep3.project.protobuf.EmptyTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.RequestDeleteTag.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sep3.project.protobuf.EmptyTag.getDefaultInstance()))
              .setSchemaDescriptor(new TagServiceMethodDescriptorSupplier("DeleteTag"))
              .build();
        }
      }
    }
    return getDeleteTagMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TagServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagServiceStub>() {
        @java.lang.Override
        public TagServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagServiceStub(channel, callOptions);
        }
      };
    return TagServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TagServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagServiceBlockingStub>() {
        @java.lang.Override
        public TagServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagServiceBlockingStub(channel, callOptions);
        }
      };
    return TagServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TagServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TagServiceFutureStub>() {
        @java.lang.Override
        public TagServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TagServiceFutureStub(channel, callOptions);
        }
      };
    return TagServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TagServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createTags(sep3.project.protobuf.RequestCreateTags request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagsMethod(), responseObserver);
    }

    /**
     */
    public void getPostTag(sep3.project.protobuf.RequestGetPostTag request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPostTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostTagMethod(), responseObserver);
    }

    /**
     */
    public void getTagList(sep3.project.protobuf.RequestGetTagList request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetTagList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTagListMethod(), responseObserver);
    }

    /**
     */
    public void deleteTag(sep3.project.protobuf.RequestDeleteTag request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTagMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestCreateTags,
                sep3.project.protobuf.ResponseCreateTag>(
                  this, METHODID_CREATE_TAGS)))
          .addMethod(
            getGetPostTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetPostTag,
                sep3.project.protobuf.ResponseGetPostTag>(
                  this, METHODID_GET_POST_TAG)))
          .addMethod(
            getGetTagListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestGetTagList,
                sep3.project.protobuf.ResponseGetTagList>(
                  this, METHODID_GET_TAG_LIST)))
          .addMethod(
            getDeleteTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sep3.project.protobuf.RequestDeleteTag,
                sep3.project.protobuf.EmptyTag>(
                  this, METHODID_DELETE_TAG)))
          .build();
    }
  }

  /**
   */
  public static final class TagServiceStub extends io.grpc.stub.AbstractAsyncStub<TagServiceStub> {
    private TagServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagServiceStub(channel, callOptions);
    }

    /**
     */
    public void createTags(sep3.project.protobuf.RequestCreateTags request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPostTag(sep3.project.protobuf.RequestGetPostTag request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPostTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTagList(sep3.project.protobuf.RequestGetTagList request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetTagList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTagListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTag(sep3.project.protobuf.RequestDeleteTag request,
        io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TagServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TagServiceBlockingStub> {
    private TagServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sep3.project.protobuf.ResponseCreateTag createTags(sep3.project.protobuf.RequestCreateTags request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagsMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetPostTag getPostTag(sep3.project.protobuf.RequestGetPostTag request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.ResponseGetTagList getTagList(sep3.project.protobuf.RequestGetTagList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTagListMethod(), getCallOptions(), request);
    }

    /**
     */
    public sep3.project.protobuf.EmptyTag deleteTag(sep3.project.protobuf.RequestDeleteTag request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TagServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TagServiceFutureStub> {
    private TagServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseCreateTag> createTags(
        sep3.project.protobuf.RequestCreateTags request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetPostTag> getPostTag(
        sep3.project.protobuf.RequestGetPostTag request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.ResponseGetTagList> getTagList(
        sep3.project.protobuf.RequestGetTagList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTagListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sep3.project.protobuf.EmptyTag> deleteTag(
        sep3.project.protobuf.RequestDeleteTag request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TAGS = 0;
  private static final int METHODID_GET_POST_TAG = 1;
  private static final int METHODID_GET_TAG_LIST = 2;
  private static final int METHODID_DELETE_TAG = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TagServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TagServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TAGS:
          serviceImpl.createTags((sep3.project.protobuf.RequestCreateTags) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseCreateTag>) responseObserver);
          break;
        case METHODID_GET_POST_TAG:
          serviceImpl.getPostTag((sep3.project.protobuf.RequestGetPostTag) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetPostTag>) responseObserver);
          break;
        case METHODID_GET_TAG_LIST:
          serviceImpl.getTagList((sep3.project.protobuf.RequestGetTagList) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.ResponseGetTagList>) responseObserver);
          break;
        case METHODID_DELETE_TAG:
          serviceImpl.deleteTag((sep3.project.protobuf.RequestDeleteTag) request,
              (io.grpc.stub.StreamObserver<sep3.project.protobuf.EmptyTag>) responseObserver);
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

  private static abstract class TagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TagServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sep3.project.protobuf.Tag.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TagService");
    }
  }

  private static final class TagServiceFileDescriptorSupplier
      extends TagServiceBaseDescriptorSupplier {
    TagServiceFileDescriptorSupplier() {}
  }

  private static final class TagServiceMethodDescriptorSupplier
      extends TagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TagServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TagServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TagServiceFileDescriptorSupplier())
              .addMethod(getCreateTagsMethod())
              .addMethod(getGetPostTagMethod())
              .addMethod(getGetTagListMethod())
              .addMethod(getDeleteTagMethod())
              .build();
        }
      }
    }
    return result;
  }
}
