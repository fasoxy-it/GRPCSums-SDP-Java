import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: Sum.proto")
public final class StreamSumGrpc {

  private StreamSumGrpc() {}

  public static final String SERVICE_NAME = "StreamSum";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Sum.StreamSumRequest,
      Sum.StreamSumResponse> getStreamStreamSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamStreamSum",
      requestType = Sum.StreamSumRequest.class,
      responseType = Sum.StreamSumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Sum.StreamSumRequest,
      Sum.StreamSumResponse> getStreamStreamSumMethod() {
    io.grpc.MethodDescriptor<Sum.StreamSumRequest, Sum.StreamSumResponse> getStreamStreamSumMethod;
    if ((getStreamStreamSumMethod = StreamSumGrpc.getStreamStreamSumMethod) == null) {
      synchronized (StreamSumGrpc.class) {
        if ((getStreamStreamSumMethod = StreamSumGrpc.getStreamStreamSumMethod) == null) {
          StreamSumGrpc.getStreamStreamSumMethod = getStreamStreamSumMethod =
              io.grpc.MethodDescriptor.<Sum.StreamSumRequest, Sum.StreamSumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamStreamSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.StreamSumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.StreamSumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamSumMethodDescriptorSupplier("streamStreamSum"))
              .build();
        }
      }
    }
    return getStreamStreamSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamSumStub newStub(io.grpc.Channel channel) {
    return new StreamSumStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamSumBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StreamSumBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamSumFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StreamSumFutureStub(channel);
  }

  /**
   */
  public static abstract class StreamSumImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamStreamSum(Sum.StreamSumRequest request,
        io.grpc.stub.StreamObserver<Sum.StreamSumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamStreamSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamStreamSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Sum.StreamSumRequest,
                Sum.StreamSumResponse>(
                  this, METHODID_STREAM_STREAM_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class StreamSumStub extends io.grpc.stub.AbstractStub<StreamSumStub> {
    private StreamSumStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamSumStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamSumStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamSumStub(channel, callOptions);
    }

    /**
     */
    public void streamStreamSum(Sum.StreamSumRequest request,
        io.grpc.stub.StreamObserver<Sum.StreamSumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStreamStreamSumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StreamSumBlockingStub extends io.grpc.stub.AbstractStub<StreamSumBlockingStub> {
    private StreamSumBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamSumBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamSumBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamSumBlockingStub(channel, callOptions);
    }

    /**
     */
    public Sum.StreamSumResponse streamStreamSum(Sum.StreamSumRequest request) {
      return blockingUnaryCall(
          getChannel(), getStreamStreamSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StreamSumFutureStub extends io.grpc.stub.AbstractStub<StreamSumFutureStub> {
    private StreamSumFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamSumFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamSumFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamSumFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Sum.StreamSumResponse> streamStreamSum(
        Sum.StreamSumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStreamStreamSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_STREAM_SUM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreamSumImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StreamSumImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_STREAM_SUM:
          serviceImpl.streamStreamSum((Sum.StreamSumRequest) request,
              (io.grpc.stub.StreamObserver<Sum.StreamSumResponse>) responseObserver);
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

  private static abstract class StreamSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamSumBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamSum");
    }
  }

  private static final class StreamSumFileDescriptorSupplier
      extends StreamSumBaseDescriptorSupplier {
    StreamSumFileDescriptorSupplier() {}
  }

  private static final class StreamSumMethodDescriptorSupplier
      extends StreamSumBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StreamSumMethodDescriptorSupplier(String methodName) {
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
      synchronized (StreamSumGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamSumFileDescriptorSupplier())
              .addMethod(getStreamStreamSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
