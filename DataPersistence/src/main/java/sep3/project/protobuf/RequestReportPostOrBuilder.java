// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: report.proto

package sep3.project.protobuf;

public interface RequestReportPostOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RequestReportPost)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string violation_desc = 1;</code>
   * @return The violationDesc.
   */
  java.lang.String getViolationDesc();
  /**
   * <code>string violation_desc = 1;</code>
   * @return The bytes for violationDesc.
   */
  com.google.protobuf.ByteString
      getViolationDescBytes();

  /**
   * <code>int32 post_id = 2;</code>
   * @return The postId.
   */
  int getPostId();

  /**
   * <code>int32 user_id = 3;</code>
   * @return The userId.
   */
  int getUserId();
}
