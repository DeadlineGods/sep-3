// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: report.proto

package sep3.project.protobuf;

/**
 * Protobuf type {@code RequestReportPost}
 */
public final class RequestReportPost extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RequestReportPost)
    RequestReportPostOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestReportPost.newBuilder() to construct.
  private RequestReportPost(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestReportPost() {
    violationDesc_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RequestReportPost();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestReportPost(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            violationDesc_ = s;
            break;
          }
          case 16: {

            postId_ = input.readInt64();
            break;
          }
          case 24: {

            userId_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sep3.project.protobuf.Report.internal_static_RequestReportPost_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sep3.project.protobuf.Report.internal_static_RequestReportPost_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sep3.project.protobuf.RequestReportPost.class, sep3.project.protobuf.RequestReportPost.Builder.class);
  }

  public static final int VIOLATION_DESC_FIELD_NUMBER = 1;
  private volatile java.lang.Object violationDesc_;
  /**
   * <code>string violation_desc = 1;</code>
   * @return The violationDesc.
   */
  @java.lang.Override
  public java.lang.String getViolationDesc() {
    java.lang.Object ref = violationDesc_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      violationDesc_ = s;
      return s;
    }
  }
  /**
   * <code>string violation_desc = 1;</code>
   * @return The bytes for violationDesc.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getViolationDescBytes() {
    java.lang.Object ref = violationDesc_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      violationDesc_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int POST_ID_FIELD_NUMBER = 2;
  private long postId_;
  /**
   * <code>int64 post_id = 2;</code>
   * @return The postId.
   */
  @java.lang.Override
  public long getPostId() {
    return postId_;
  }

  public static final int USER_ID_FIELD_NUMBER = 3;
  private long userId_;
  /**
   * <code>int64 user_id = 3;</code>
   * @return The userId.
   */
  @java.lang.Override
  public long getUserId() {
    return userId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(violationDesc_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, violationDesc_);
    }
    if (postId_ != 0L) {
      output.writeInt64(2, postId_);
    }
    if (userId_ != 0L) {
      output.writeInt64(3, userId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(violationDesc_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, violationDesc_);
    }
    if (postId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, postId_);
    }
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, userId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sep3.project.protobuf.RequestReportPost)) {
      return super.equals(obj);
    }
    sep3.project.protobuf.RequestReportPost other = (sep3.project.protobuf.RequestReportPost) obj;

    if (!getViolationDesc()
        .equals(other.getViolationDesc())) return false;
    if (getPostId()
        != other.getPostId()) return false;
    if (getUserId()
        != other.getUserId()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VIOLATION_DESC_FIELD_NUMBER;
    hash = (53 * hash) + getViolationDesc().hashCode();
    hash = (37 * hash) + POST_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPostId());
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sep3.project.protobuf.RequestReportPost parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sep3.project.protobuf.RequestReportPost parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sep3.project.protobuf.RequestReportPost parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sep3.project.protobuf.RequestReportPost parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sep3.project.protobuf.RequestReportPost prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RequestReportPost}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RequestReportPost)
      sep3.project.protobuf.RequestReportPostOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sep3.project.protobuf.Report.internal_static_RequestReportPost_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sep3.project.protobuf.Report.internal_static_RequestReportPost_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sep3.project.protobuf.RequestReportPost.class, sep3.project.protobuf.RequestReportPost.Builder.class);
    }

    // Construct using sep3.project.protobuf.RequestReportPost.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      violationDesc_ = "";

      postId_ = 0L;

      userId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sep3.project.protobuf.Report.internal_static_RequestReportPost_descriptor;
    }

    @java.lang.Override
    public sep3.project.protobuf.RequestReportPost getDefaultInstanceForType() {
      return sep3.project.protobuf.RequestReportPost.getDefaultInstance();
    }

    @java.lang.Override
    public sep3.project.protobuf.RequestReportPost build() {
      sep3.project.protobuf.RequestReportPost result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sep3.project.protobuf.RequestReportPost buildPartial() {
      sep3.project.protobuf.RequestReportPost result = new sep3.project.protobuf.RequestReportPost(this);
      result.violationDesc_ = violationDesc_;
      result.postId_ = postId_;
      result.userId_ = userId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sep3.project.protobuf.RequestReportPost) {
        return mergeFrom((sep3.project.protobuf.RequestReportPost)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sep3.project.protobuf.RequestReportPost other) {
      if (other == sep3.project.protobuf.RequestReportPost.getDefaultInstance()) return this;
      if (!other.getViolationDesc().isEmpty()) {
        violationDesc_ = other.violationDesc_;
        onChanged();
      }
      if (other.getPostId() != 0L) {
        setPostId(other.getPostId());
      }
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      sep3.project.protobuf.RequestReportPost parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (sep3.project.protobuf.RequestReportPost) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object violationDesc_ = "";
    /**
     * <code>string violation_desc = 1;</code>
     * @return The violationDesc.
     */
    public java.lang.String getViolationDesc() {
      java.lang.Object ref = violationDesc_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        violationDesc_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string violation_desc = 1;</code>
     * @return The bytes for violationDesc.
     */
    public com.google.protobuf.ByteString
        getViolationDescBytes() {
      java.lang.Object ref = violationDesc_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        violationDesc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string violation_desc = 1;</code>
     * @param value The violationDesc to set.
     * @return This builder for chaining.
     */
    public Builder setViolationDesc(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      violationDesc_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string violation_desc = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearViolationDesc() {
      
      violationDesc_ = getDefaultInstance().getViolationDesc();
      onChanged();
      return this;
    }
    /**
     * <code>string violation_desc = 1;</code>
     * @param value The bytes for violationDesc to set.
     * @return This builder for chaining.
     */
    public Builder setViolationDescBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      violationDesc_ = value;
      onChanged();
      return this;
    }

    private long postId_ ;
    /**
     * <code>int64 post_id = 2;</code>
     * @return The postId.
     */
    @java.lang.Override
    public long getPostId() {
      return postId_;
    }
    /**
     * <code>int64 post_id = 2;</code>
     * @param value The postId to set.
     * @return This builder for chaining.
     */
    public Builder setPostId(long value) {
      
      postId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 post_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPostId() {
      
      postId_ = 0L;
      onChanged();
      return this;
    }

    private long userId_ ;
    /**
     * <code>int64 user_id = 3;</code>
     * @return The userId.
     */
    @java.lang.Override
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>int64 user_id = 3;</code>
     * @param value The userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserId(long value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 user_id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserId() {
      
      userId_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RequestReportPost)
  }

  // @@protoc_insertion_point(class_scope:RequestReportPost)
  private static final sep3.project.protobuf.RequestReportPost DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sep3.project.protobuf.RequestReportPost();
  }

  public static sep3.project.protobuf.RequestReportPost getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestReportPost>
      PARSER = new com.google.protobuf.AbstractParser<RequestReportPost>() {
    @java.lang.Override
    public RequestReportPost parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestReportPost(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestReportPost> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestReportPost> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sep3.project.protobuf.RequestReportPost getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

