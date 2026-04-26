package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DeviceGrpc {

  private DeviceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.Device";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getTurnONMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "turnON",
      requestType = generated.DeviceId.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getTurnONMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.Status> getTurnONMethod;
    if ((getTurnONMethod = DeviceGrpc.getTurnONMethod) == null) {
      synchronized (DeviceGrpc.class) {
        if ((getTurnONMethod = DeviceGrpc.getTurnONMethod) == null) {
          DeviceGrpc.getTurnONMethod = getTurnONMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "turnON"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new DeviceMethodDescriptorSupplier("turnON"))
              .build();
        }
      }
    }
    return getTurnONMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getTurnOFFMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "turnOFF",
      requestType = generated.DeviceId.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getTurnOFFMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.Status> getTurnOFFMethod;
    if ((getTurnOFFMethod = DeviceGrpc.getTurnOFFMethod) == null) {
      synchronized (DeviceGrpc.class) {
        if ((getTurnOFFMethod = DeviceGrpc.getTurnOFFMethod) == null) {
          DeviceGrpc.getTurnOFFMethod = getTurnOFFMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "turnOFF"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new DeviceMethodDescriptorSupplier("turnOFF"))
              .build();
        }
      }
    }
    return getTurnOFFMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceStub>() {
        @java.lang.Override
        public DeviceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceStub(channel, callOptions);
        }
      };
    return DeviceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static DeviceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingV2Stub>() {
        @java.lang.Override
        public DeviceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceBlockingV2Stub(channel, callOptions);
        }
      };
    return DeviceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceBlockingStub>() {
        @java.lang.Override
        public DeviceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceBlockingStub(channel, callOptions);
        }
      };
    return DeviceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeviceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeviceFutureStub>() {
        @java.lang.Override
        public DeviceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeviceFutureStub(channel, callOptions);
        }
      };
    return DeviceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void turnON(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnONMethod(), responseObserver);
    }

    /**
     */
    default void turnOFF(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnOFFMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Device.
   */
  public static abstract class DeviceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DeviceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Device.
   */
  public static final class DeviceStub
      extends io.grpc.stub.AbstractAsyncStub<DeviceStub> {
    private DeviceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceStub(channel, callOptions);
    }

    /**
     */
    public void turnON(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTurnONMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void turnOFF(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTurnOFFMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Device.
   */
  public static final class DeviceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DeviceBlockingV2Stub> {
    private DeviceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.Status turnON(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTurnONMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status turnOFF(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTurnOFFMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Device.
   */
  public static final class DeviceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeviceBlockingStub> {
    private DeviceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Status turnON(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTurnONMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status turnOFF(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTurnOFFMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Device.
   */
  public static final class DeviceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeviceFutureStub> {
    private DeviceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeviceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> turnON(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTurnONMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> turnOFF(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTurnOFFMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON = 0;
  private static final int METHODID_TURN_OFF = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURN_ON:
          serviceImpl.turnON((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_TURN_OFF:
          serviceImpl.turnOFF((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getTurnONMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.Status>(
                service, METHODID_TURN_ON)))
        .addMethod(
          getTurnOFFMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.Status>(
                service, METHODID_TURN_OFF)))
        .build();
  }

  private static abstract class DeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeviceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Device");
    }
  }

  private static final class DeviceFileDescriptorSupplier
      extends DeviceBaseDescriptorSupplier {
    DeviceFileDescriptorSupplier() {}
  }

  private static final class DeviceMethodDescriptorSupplier
      extends DeviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeviceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeviceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeviceFileDescriptorSupplier())
              .addMethod(getTurnONMethod())
              .addMethod(getTurnOFFMethod())
              .build();
        }
      }
    }
    return result;
  }
}
