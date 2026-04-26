package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class LightGrpc {

  private LightGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.Light";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getToggleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Toggle",
      requestType = generated.DeviceId.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getToggleMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.Status> getToggleMethod;
    if ((getToggleMethod = LightGrpc.getToggleMethod) == null) {
      synchronized (LightGrpc.class) {
        if ((getToggleMethod = LightGrpc.getToggleMethod) == null) {
          LightGrpc.getToggleMethod = getToggleMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Toggle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new LightMethodDescriptorSupplier("Toggle"))
              .build();
        }
      }
    }
    return getToggleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.BrigthnessRequest,
      generated.Status> getSetBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setBrightness",
      requestType = generated.BrigthnessRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.BrigthnessRequest,
      generated.Status> getSetBrightnessMethod() {
    io.grpc.MethodDescriptor<generated.BrigthnessRequest, generated.Status> getSetBrightnessMethod;
    if ((getSetBrightnessMethod = LightGrpc.getSetBrightnessMethod) == null) {
      synchronized (LightGrpc.class) {
        if ((getSetBrightnessMethod = LightGrpc.getSetBrightnessMethod) == null) {
          LightGrpc.getSetBrightnessMethod = getSetBrightnessMethod =
              io.grpc.MethodDescriptor.<generated.BrigthnessRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.BrigthnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new LightMethodDescriptorSupplier("setBrightness"))
              .build();
        }
      }
    }
    return getSetBrightnessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.PowerUsageStats> getGetPowerUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPowerUsage",
      requestType = generated.DeviceId.class,
      responseType = generated.PowerUsageStats.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.PowerUsageStats> getGetPowerUsageMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.PowerUsageStats> getGetPowerUsageMethod;
    if ((getGetPowerUsageMethod = LightGrpc.getGetPowerUsageMethod) == null) {
      synchronized (LightGrpc.class) {
        if ((getGetPowerUsageMethod = LightGrpc.getGetPowerUsageMethod) == null) {
          LightGrpc.getGetPowerUsageMethod = getGetPowerUsageMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.PowerUsageStats>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPowerUsage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.PowerUsageStats.getDefaultInstance()))
              .setSchemaDescriptor(new LightMethodDescriptorSupplier("getPowerUsage"))
              .build();
        }
      }
    }
    return getGetPowerUsageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.ScheduleRequest,
      generated.Status> getScheduleONMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "scheduleON",
      requestType = generated.ScheduleRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.ScheduleRequest,
      generated.Status> getScheduleONMethod() {
    io.grpc.MethodDescriptor<generated.ScheduleRequest, generated.Status> getScheduleONMethod;
    if ((getScheduleONMethod = LightGrpc.getScheduleONMethod) == null) {
      synchronized (LightGrpc.class) {
        if ((getScheduleONMethod = LightGrpc.getScheduleONMethod) == null) {
          LightGrpc.getScheduleONMethod = getScheduleONMethod =
              io.grpc.MethodDescriptor.<generated.ScheduleRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "scheduleON"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new LightMethodDescriptorSupplier("scheduleON"))
              .build();
        }
      }
    }
    return getScheduleONMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.ScheduleRequest,
      generated.Status> getScheduleOFFMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "scheduleOFF",
      requestType = generated.ScheduleRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.ScheduleRequest,
      generated.Status> getScheduleOFFMethod() {
    io.grpc.MethodDescriptor<generated.ScheduleRequest, generated.Status> getScheduleOFFMethod;
    if ((getScheduleOFFMethod = LightGrpc.getScheduleOFFMethod) == null) {
      synchronized (LightGrpc.class) {
        if ((getScheduleOFFMethod = LightGrpc.getScheduleOFFMethod) == null) {
          LightGrpc.getScheduleOFFMethod = getScheduleOFFMethod =
              io.grpc.MethodDescriptor.<generated.ScheduleRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "scheduleOFF"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new LightMethodDescriptorSupplier("scheduleOFF"))
              .build();
        }
      }
    }
    return getScheduleOFFMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightStub>() {
        @java.lang.Override
        public LightStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightStub(channel, callOptions);
        }
      };
    return LightStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static LightBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightBlockingV2Stub>() {
        @java.lang.Override
        public LightBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightBlockingV2Stub(channel, callOptions);
        }
      };
    return LightBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightBlockingStub>() {
        @java.lang.Override
        public LightBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightBlockingStub(channel, callOptions);
        }
      };
    return LightBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightFutureStub>() {
        @java.lang.Override
        public LightFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightFutureStub(channel, callOptions);
        }
      };
    return LightFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void toggle(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getToggleMethod(), responseObserver);
    }

    /**
     */
    default void setBrightness(generated.BrigthnessRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetBrightnessMethod(), responseObserver);
    }

    /**
     */
    default void getPowerUsage(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.PowerUsageStats> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPowerUsageMethod(), responseObserver);
    }

    /**
     */
    default void scheduleON(generated.ScheduleRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleONMethod(), responseObserver);
    }

    /**
     */
    default void scheduleOFF(generated.ScheduleRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleOFFMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Light.
   */
  public static abstract class LightImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LightGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Light.
   */
  public static final class LightStub
      extends io.grpc.stub.AbstractAsyncStub<LightStub> {
    private LightStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightStub(channel, callOptions);
    }

    /**
     */
    public void toggle(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getToggleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setBrightness(generated.BrigthnessRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetBrightnessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPowerUsage(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.PowerUsageStats> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPowerUsageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleON(generated.ScheduleRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleONMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scheduleOFF(generated.ScheduleRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleOFFMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Light.
   */
  public static final class LightBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LightBlockingV2Stub> {
    private LightBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.Status toggle(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getToggleMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setBrightness(generated.BrigthnessRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetBrightnessMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.PowerUsageStats getPowerUsage(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPowerUsageMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status scheduleON(generated.ScheduleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getScheduleONMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status scheduleOFF(generated.ScheduleRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getScheduleOFFMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Light.
   */
  public static final class LightBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LightBlockingStub> {
    private LightBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Status toggle(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getToggleMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setBrightness(generated.BrigthnessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetBrightnessMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.PowerUsageStats getPowerUsage(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPowerUsageMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status scheduleON(generated.ScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleONMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status scheduleOFF(generated.ScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleOFFMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Light.
   */
  public static final class LightFutureStub
      extends io.grpc.stub.AbstractFutureStub<LightFutureStub> {
    private LightFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> toggle(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getToggleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setBrightness(
        generated.BrigthnessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetBrightnessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.PowerUsageStats> getPowerUsage(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPowerUsageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> scheduleON(
        generated.ScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleONMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> scheduleOFF(
        generated.ScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleOFFMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TOGGLE = 0;
  private static final int METHODID_SET_BRIGHTNESS = 1;
  private static final int METHODID_GET_POWER_USAGE = 2;
  private static final int METHODID_SCHEDULE_ON = 3;
  private static final int METHODID_SCHEDULE_OFF = 4;

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
        case METHODID_TOGGLE:
          serviceImpl.toggle((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_BRIGHTNESS:
          serviceImpl.setBrightness((generated.BrigthnessRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_GET_POWER_USAGE:
          serviceImpl.getPowerUsage((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.PowerUsageStats>) responseObserver);
          break;
        case METHODID_SCHEDULE_ON:
          serviceImpl.scheduleON((generated.ScheduleRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SCHEDULE_OFF:
          serviceImpl.scheduleOFF((generated.ScheduleRequest) request,
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
          getToggleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.Status>(
                service, METHODID_TOGGLE)))
        .addMethod(
          getSetBrightnessMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.BrigthnessRequest,
              generated.Status>(
                service, METHODID_SET_BRIGHTNESS)))
        .addMethod(
          getGetPowerUsageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.PowerUsageStats>(
                service, METHODID_GET_POWER_USAGE)))
        .addMethod(
          getScheduleONMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.ScheduleRequest,
              generated.Status>(
                service, METHODID_SCHEDULE_ON)))
        .addMethod(
          getScheduleOFFMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.ScheduleRequest,
              generated.Status>(
                service, METHODID_SCHEDULE_OFF)))
        .build();
  }

  private static abstract class LightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Light");
    }
  }

  private static final class LightFileDescriptorSupplier
      extends LightBaseDescriptorSupplier {
    LightFileDescriptorSupplier() {}
  }

  private static final class LightMethodDescriptorSupplier
      extends LightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LightMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LightGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightFileDescriptorSupplier())
              .addMethod(getToggleMethod())
              .addMethod(getSetBrightnessMethod())
              .addMethod(getGetPowerUsageMethod())
              .addMethod(getScheduleONMethod())
              .addMethod(getScheduleOFFMethod())
              .build();
        }
      }
    }
    return result;
  }
}
