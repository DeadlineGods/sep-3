// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: report.proto

package sep3.project.protobuf;

public interface ReportDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ReportData)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 report_id = 1;</code>
   * @return The reportId.
   */
  long getReportId();

  /**
   * <code>string violation_desc = 2;</code>
   * @return The violationDesc.
   */
  java.lang.String getViolationDesc();
  /**
   * <code>string violation_desc = 2;</code>
   * @return The bytes for violationDesc.
   */
  com.google.protobuf.ByteString
      getViolationDescBytes();

  /**
   * <code>int64 post_id = 3;</code>
   * @return The postId.
   */
  long getPostId();

  /**
   * <code>int64 user_id = 4;</code>
   * @return The userId.
   */
  long getUserId();
}
