package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistryGrpc {

  private RegistryGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.Registry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.Empty,
      generated.DeviceList> getListDevicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listDevices",
      requestType = generated.Empty.class,
      responseType = generated.DeviceList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.Empty,
      generated.DeviceList> getListDevicesMethod() {
    io.grpc.MethodDescriptor<generated.Empty, generated.DeviceList> getListDevicesMethod;
    if ((getListDevicesMethod = RegistryGrpc.getListDevicesMethod) == null) {
      synchronized (RegistryGrpc.class) {
        if ((getListDevicesMethod = RegistryGrpc.getListDevicesMethod) == null) {
          RegistryGrpc.getListDevicesMethod = getListDevicesMethod =
              io.grpc.MethodDescriptor.<generated.Empty, generated.DeviceList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceList.getDefaultInstance()))
              .setSchemaDescriptor(new RegistryMethodDescriptorSupplier("listDevices"))
              .build();
        }
      }
    }
    return getListDevicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryStub>() {
        @java.lang.Override
        public RegistryStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryStub(channel, callOptions);
        }
      };
    return RegistryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static RegistryBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingV2Stub>() {
        @java.lang.Override
        public RegistryBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryBlockingV2Stub(channel, callOptions);
        }
      };
    return RegistryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryBlockingStub>() {
        @java.lang.Override
        public RegistryBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryBlockingStub(channel, callOptions);
        }
      };
    return RegistryBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryFutureStub>() {
        @java.lang.Override
        public RegistryFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryFutureStub(channel, callOptions);
        }
      };
    return RegistryFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void listDevices(generated.Empty request,
        io.grpc.stub.StreamObserver<generated.DeviceList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDevicesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Registry.
   */
  public static abstract class RegistryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RegistryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Registry.
   */
  public static final class RegistryStub
      extends io.grpc.stub.AbstractAsyncStub<RegistryStub> {
    private RegistryStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryStub(channel, callOptions);
    }

    /**
     */
    public void listDevices(generated.Empty request,
        io.grpc.stub.StreamObserver<generated.DeviceList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Registry.
   */
  public static final class RegistryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RegistryBlockingV2Stub> {
    private RegistryBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.DeviceList listDevices(generated.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListDevicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Registry.
   */
  public static final class RegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegistryBlockingStub> {
    private RegistryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.DeviceList listDevices(generated.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDevicesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Registry.
   */
  public static final class RegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegistryFutureStub> {
    private RegistryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.DeviceList> listDevices(
        generated.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DEVICES = 0;

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
        case METHODID_LIST_DEVICES:
          serviceImpl.listDevices((generated.Empty) request,
              (io.grpc.stub.StreamObserver<generated.DeviceList>) responseObserver);
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
          getListDevicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.Empty,
              generated.DeviceList>(
                service, METHODID_LIST_DEVICES)))
        .build();
  }

  private static abstract class RegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Registry");
    }
  }

  private static final class RegistryFileDescriptorSupplier
      extends RegistryBaseDescriptorSupplier {
    RegistryFileDescriptorSupplier() {}
  }

  private static final class RegistryMethodDescriptorSupplier
      extends RegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegistryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistryFileDescriptorSupplier())
              .addMethod(getListDevicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
