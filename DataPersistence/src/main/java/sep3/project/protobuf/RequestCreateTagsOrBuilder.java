// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tag.proto

package sep3.project.protobuf;

public interface RequestCreateTagsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RequestCreateTags)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 postId = 1;</code>
   * @return The postId.
   */
  long getPostId();

  /**
   * <code>repeated string tags = 2;</code>
   * @return A list containing the tags.
   */
  java.util.List<java.lang.String>
      getTagsList();
  /**
   * <code>repeated string tags = 2;</code>
   * @return The count of tags.
   */
  int getTagsCount();
  /**
   * <code>repeated string tags = 2;</code>
   * @param index The index of the element to return.
   * @return The tags at the given index.
   */
  java.lang.String getTags(int index);
  /**
   * <code>repeated string tags = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the tags at the given index.
   */
  com.google.protobuf.ByteString
      getTagsBytes(int index);
}
