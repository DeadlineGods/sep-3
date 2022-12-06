// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: post.proto

package sep3.project.protobuf;

public final class Post {
  private Post() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestCreatePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestCreatePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseCreatePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseCreatePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PostData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PostData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestDeletePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestDeletePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmptyPost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmptyPost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestGetPost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestGetPost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseGetPost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseGetPost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestUpdatePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestUpdatePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseUpdatePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseUpdatePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestGetPostById_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestGetPostById_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseGetPostById_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseGetPostById_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\npost.proto\"y\n\021RequestCreatePost\022\r\n\005tit" +
      "le\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\022\016\n\006userId\030" +
      "\003 \001(\003\022\016\n\006imgUrl\030\004 \001(\t\022\014\n\004tags\030\005 \003(\t\022\022\n\nl" +
      "ocationId\030\006 \001(\005\" \n\022ResponseCreatePost\022\n\n" +
      "\002id\030\001 \001(\005\"\233\001\n\010PostData\022\n\n\002id\030\001 \001(\005\022\016\n\006us" +
      "erId\030\002 \001(\003\022\r\n\005likes\030\003 \001(\005\022\r\n\005title\030\004 \001(\t" +
      "\022\023\n\013description\030\005 \001(\t\022\016\n\006imgUrl\030\006 \001(\t\022\022\n" +
      "\nlocationId\030\007 \001(\005\022\034\n\024postedOnMillisecond" +
      "s\030\010 \001(\003\"\037\n\021RequestDeletePost\022\n\n\002id\030\001 \001(\005" +
      "\"\013\n\tEmptyPost\"f\n\016RequestGetPost\022\017\n\002id\030\001 " +
      "\001(\005H\000\210\001\001\022\023\n\006userId\030\002 \001(\003H\001\210\001\001\022\022\n\005title\030\003" +
      " \001(\tH\002\210\001\001B\005\n\003_idB\t\n\007_userIdB\010\n\006_title\"+\n" +
      "\017ResponseGetPost\022\030\n\005posts\030\001 \003(\0132\t.PostDa" +
      "ta\"Q\n\021RequestUpdatePost\022\n\n\002id\030\001 \001(\005\022\r\n\005t" +
      "itle\030\002 \001(\t\022\023\n\013description\030\003 \001(\t\022\014\n\004tags\030" +
      "\004 \003(\t\" \n\022ResponseUpdatePost\022\n\n\002id\030\001 \001(\005\"" +
      " \n\022RequestGetPostById\022\n\n\002id\030\001 \001(\005\"\202\001\n\023Re" +
      "sponseGetPostById\022\n\n\002id\030\001 \001(\005\022\016\n\006userId\030" +
      "\002 \001(\003\022\r\n\005likes\030\003 \001(\005\022\r\n\005title\030\004 \001(\t\022\023\n\013d" +
      "escription\030\005 \001(\t\022\034\n\024postedOnMilliseconds" +
      "\030\006 \001(\0032\327\001\n\013PostService\0225\n\nCreatePost\022\022.R" +
      "equestCreatePost\032\023.ResponseCreatePost\022,\n" +
      "\007GetPost\022\017.RequestGetPost\032\020.ResponseGetP" +
      "ost\022,\n\nDeletePost\022\022.RequestDeletePost\032\n." +
      "EmptyPost\0225\n\nUpdatePost\022\022.RequestUpdateP" +
      "ost\032\023.ResponseUpdatePostB\031\n\025sep3.project" +
      ".protobufP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_RequestCreatePost_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RequestCreatePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestCreatePost_descriptor,
        new java.lang.String[] { "Title", "Description", "UserId", "ImgUrl", "Tags", "LocationId", });
    internal_static_ResponseCreatePost_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ResponseCreatePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseCreatePost_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_PostData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_PostData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PostData_descriptor,
        new java.lang.String[] { "Id", "UserId", "Likes", "Title", "Description", "ImgUrl", "LocationId", "PostedOnMilliseconds", });
    internal_static_RequestDeletePost_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_RequestDeletePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestDeletePost_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_EmptyPost_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_EmptyPost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmptyPost_descriptor,
        new java.lang.String[] { });
    internal_static_RequestGetPost_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_RequestGetPost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestGetPost_descriptor,
        new java.lang.String[] { "Id", "UserId", "Title", "Id", "UserId", "Title", });
    internal_static_ResponseGetPost_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ResponseGetPost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseGetPost_descriptor,
        new java.lang.String[] { "Posts", });
    internal_static_RequestUpdatePost_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_RequestUpdatePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestUpdatePost_descriptor,
        new java.lang.String[] { "Id", "Title", "Description", "Tags", });
    internal_static_ResponseUpdatePost_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ResponseUpdatePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseUpdatePost_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_RequestGetPostById_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_RequestGetPostById_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestGetPostById_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_ResponseGetPostById_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ResponseGetPostById_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseGetPostById_descriptor,
        new java.lang.String[] { "Id", "UserId", "Likes", "Title", "Description", "PostedOnMilliseconds", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
