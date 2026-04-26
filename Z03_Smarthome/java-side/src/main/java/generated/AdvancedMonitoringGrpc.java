package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AdvancedMonitoringGrpc {

  private AdvancedMonitoringGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.AdvancedMonitoring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.PrivacyRequest,
      generated.Status> getSetPrivacyModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setPrivacyMode",
      requestType = generated.PrivacyRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.PrivacyRequest,
      generated.Status> getSetPrivacyModeMethod() {
    io.grpc.MethodDescriptor<generated.PrivacyRequest, generated.Status> getSetPrivacyModeMethod;
    if ((getSetPrivacyModeMethod = AdvancedMonitoringGrpc.getSetPrivacyModeMethod) == null) {
      synchronized (AdvancedMonitoringGrpc.class) {
        if ((getSetPrivacyModeMethod = AdvancedMonitoringGrpc.getSetPrivacyModeMethod) == null) {
          AdvancedMonitoringGrpc.getSetPrivacyModeMethod = getSetPrivacyModeMethod =
              io.grpc.MethodDescriptor.<generated.PrivacyRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setPrivacyMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.PrivacyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedMonitoringMethodDescriptorSupplier("setPrivacyMode"))
              .build();
        }
      }
    }
    return getSetPrivacyModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.AudioRequest,
      generated.Status> getPlayAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "playAudio",
      requestType = generated.AudioRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.AudioRequest,
      generated.Status> getPlayAudioMethod() {
    io.grpc.MethodDescriptor<generated.AudioRequest, generated.Status> getPlayAudioMethod;
    if ((getPlayAudioMethod = AdvancedMonitoringGrpc.getPlayAudioMethod) == null) {
      synchronized (AdvancedMonitoringGrpc.class) {
        if ((getPlayAudioMethod = AdvancedMonitoringGrpc.getPlayAudioMethod) == null) {
          AdvancedMonitoringGrpc.getPlayAudioMethod = getPlayAudioMethod =
              io.grpc.MethodDescriptor.<generated.AudioRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "playAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.AudioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedMonitoringMethodDescriptorSupplier("playAudio"))
              .build();
        }
      }
    }
    return getPlayAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.WeatherRequest,
      generated.Status> getSetWeatherModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setWeatherMode",
      requestType = generated.WeatherRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.WeatherRequest,
      generated.Status> getSetWeatherModeMethod() {
    io.grpc.MethodDescriptor<generated.WeatherRequest, generated.Status> getSetWeatherModeMethod;
    if ((getSetWeatherModeMethod = AdvancedMonitoringGrpc.getSetWeatherModeMethod) == null) {
      synchronized (AdvancedMonitoringGrpc.class) {
        if ((getSetWeatherModeMethod = AdvancedMonitoringGrpc.getSetWeatherModeMethod) == null) {
          AdvancedMonitoringGrpc.getSetWeatherModeMethod = getSetWeatherModeMethod =
              io.grpc.MethodDescriptor.<generated.WeatherRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setWeatherMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedMonitoringMethodDescriptorSupplier("setWeatherMode"))
              .build();
        }
      }
    }
    return getSetWeatherModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.TemperatureAlarmRequest,
      generated.Status> getSetTemperatureAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemperatureAlarm",
      requestType = generated.TemperatureAlarmRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.TemperatureAlarmRequest,
      generated.Status> getSetTemperatureAlarmMethod() {
    io.grpc.MethodDescriptor<generated.TemperatureAlarmRequest, generated.Status> getSetTemperatureAlarmMethod;
    if ((getSetTemperatureAlarmMethod = AdvancedMonitoringGrpc.getSetTemperatureAlarmMethod) == null) {
      synchronized (AdvancedMonitoringGrpc.class) {
        if ((getSetTemperatureAlarmMethod = AdvancedMonitoringGrpc.getSetTemperatureAlarmMethod) == null) {
          AdvancedMonitoringGrpc.getSetTemperatureAlarmMethod = getSetTemperatureAlarmMethod =
              io.grpc.MethodDescriptor.<generated.TemperatureAlarmRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setTemperatureAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.TemperatureAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedMonitoringMethodDescriptorSupplier("setTemperatureAlarm"))
              .build();
        }
      }
    }
    return getSetTemperatureAlarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.TemperatureRangeRequest,
      generated.Status> getSetTemperatureRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemperatureRange",
      requestType = generated.TemperatureRangeRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.TemperatureRangeRequest,
      generated.Status> getSetTemperatureRangeMethod() {
    io.grpc.MethodDescriptor<generated.TemperatureRangeRequest, generated.Status> getSetTemperatureRangeMethod;
    if ((getSetTemperatureRangeMethod = AdvancedMonitoringGrpc.getSetTemperatureRangeMethod) == null) {
      synchronized (AdvancedMonitoringGrpc.class) {
        if ((getSetTemperatureRangeMethod = AdvancedMonitoringGrpc.getSetTemperatureRangeMethod) == null) {
          AdvancedMonitoringGrpc.getSetTemperatureRangeMethod = getSetTemperatureRangeMethod =
              io.grpc.MethodDescriptor.<generated.TemperatureRangeRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setTemperatureRange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.TemperatureRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedMonitoringMethodDescriptorSupplier("setTemperatureRange"))
              .build();
        }
      }
    }
    return getSetTemperatureRangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdvancedMonitoringStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringStub>() {
        @java.lang.Override
        public AdvancedMonitoringStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedMonitoringStub(channel, callOptions);
        }
      };
    return AdvancedMonitoringStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AdvancedMonitoringBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringBlockingV2Stub>() {
        @java.lang.Override
        public AdvancedMonitoringBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedMonitoringBlockingV2Stub(channel, callOptions);
        }
      };
    return AdvancedMonitoringBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdvancedMonitoringBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringBlockingStub>() {
        @java.lang.Override
        public AdvancedMonitoringBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedMonitoringBlockingStub(channel, callOptions);
        }
      };
    return AdvancedMonitoringBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdvancedMonitoringFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedMonitoringFutureStub>() {
        @java.lang.Override
        public AdvancedMonitoringFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedMonitoringFutureStub(channel, callOptions);
        }
      };
    return AdvancedMonitoringFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setPrivacyMode(generated.PrivacyRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetPrivacyModeMethod(), responseObserver);
    }

    /**
     */
    default void playAudio(generated.AudioRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPlayAudioMethod(), responseObserver);
    }

    /**
     */
    default void setWeatherMode(generated.WeatherRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetWeatherModeMethod(), responseObserver);
    }

    /**
     */
    default void setTemperatureAlarm(generated.TemperatureAlarmRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureAlarmMethod(), responseObserver);
    }

    /**
     */
    default void setTemperatureRange(generated.TemperatureRangeRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureRangeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdvancedMonitoring.
   */
  public static abstract class AdvancedMonitoringImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdvancedMonitoringGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdvancedMonitoring.
   */
  public static final class AdvancedMonitoringStub
      extends io.grpc.stub.AbstractAsyncStub<AdvancedMonitoringStub> {
    private AdvancedMonitoringStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedMonitoringStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedMonitoringStub(channel, callOptions);
    }

    /**
     */
    public void setPrivacyMode(generated.PrivacyRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetPrivacyModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void playAudio(generated.AudioRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPlayAudioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setWeatherMode(generated.WeatherRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetWeatherModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTemperatureAlarm(generated.TemperatureAlarmRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureAlarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTemperatureRange(generated.TemperatureRangeRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureRangeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdvancedMonitoring.
   */
  public static final class AdvancedMonitoringBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AdvancedMonitoringBlockingV2Stub> {
    private AdvancedMonitoringBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedMonitoringBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedMonitoringBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.Status setPrivacyMode(generated.PrivacyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetPrivacyModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status playAudio(generated.AudioRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPlayAudioMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setWeatherMode(generated.WeatherRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetWeatherModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setTemperatureAlarm(generated.TemperatureAlarmRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetTemperatureAlarmMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setTemperatureRange(generated.TemperatureRangeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetTemperatureRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AdvancedMonitoring.
   */
  public static final class AdvancedMonitoringBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdvancedMonitoringBlockingStub> {
    private AdvancedMonitoringBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedMonitoringBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedMonitoringBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Status setPrivacyMode(generated.PrivacyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetPrivacyModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status playAudio(generated.AudioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPlayAudioMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setWeatherMode(generated.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetWeatherModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setTemperatureAlarm(generated.TemperatureAlarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureAlarmMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setTemperatureRange(generated.TemperatureRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdvancedMonitoring.
   */
  public static final class AdvancedMonitoringFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdvancedMonitoringFutureStub> {
    private AdvancedMonitoringFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedMonitoringFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedMonitoringFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setPrivacyMode(
        generated.PrivacyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetPrivacyModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> playAudio(
        generated.AudioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPlayAudioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setWeatherMode(
        generated.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetWeatherModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setTemperatureAlarm(
        generated.TemperatureAlarmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureAlarmMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setTemperatureRange(
        generated.TemperatureRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureRangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_PRIVACY_MODE = 0;
  private static final int METHODID_PLAY_AUDIO = 1;
  private static final int METHODID_SET_WEATHER_MODE = 2;
  private static final int METHODID_SET_TEMPERATURE_ALARM = 3;
  private static final int METHODID_SET_TEMPERATURE_RANGE = 4;

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
        case METHODID_SET_PRIVACY_MODE:
          serviceImpl.setPrivacyMode((generated.PrivacyRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_PLAY_AUDIO:
          serviceImpl.playAudio((generated.AudioRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_WEATHER_MODE:
          serviceImpl.setWeatherMode((generated.WeatherRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_TEMPERATURE_ALARM:
          serviceImpl.setTemperatureAlarm((generated.TemperatureAlarmRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_TEMPERATURE_RANGE:
          serviceImpl.setTemperatureRange((generated.TemperatureRangeRequest) request,
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
          getSetPrivacyModeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.PrivacyRequest,
              generated.Status>(
                service, METHODID_SET_PRIVACY_MODE)))
        .addMethod(
          getPlayAudioMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.AudioRequest,
              generated.Status>(
                service, METHODID_PLAY_AUDIO)))
        .addMethod(
          getSetWeatherModeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.WeatherRequest,
              generated.Status>(
                service, METHODID_SET_WEATHER_MODE)))
        .addMethod(
          getSetTemperatureAlarmMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.TemperatureAlarmRequest,
              generated.Status>(
                service, METHODID_SET_TEMPERATURE_ALARM)))
        .addMethod(
          getSetTemperatureRangeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.TemperatureRangeRequest,
              generated.Status>(
                service, METHODID_SET_TEMPERATURE_RANGE)))
        .build();
  }

  private static abstract class AdvancedMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdvancedMonitoringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdvancedMonitoring");
    }
  }

  private static final class AdvancedMonitoringFileDescriptorSupplier
      extends AdvancedMonitoringBaseDescriptorSupplier {
    AdvancedMonitoringFileDescriptorSupplier() {}
  }

  private static final class AdvancedMonitoringMethodDescriptorSupplier
      extends AdvancedMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdvancedMonitoringMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdvancedMonitoringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdvancedMonitoringFileDescriptorSupplier())
              .addMethod(getSetPrivacyModeMethod())
              .addMethod(getPlayAudioMethod())
              .addMethod(getSetWeatherModeMethod())
              .addMethod(getSetTemperatureAlarmMethod())
              .addMethod(getSetTemperatureRangeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
