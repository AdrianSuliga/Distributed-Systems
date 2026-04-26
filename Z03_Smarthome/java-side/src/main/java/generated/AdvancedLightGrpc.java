package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AdvancedLightGrpc {

  private AdvancedLightGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.AdvancedLight";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.RGBRequest,
      generated.Status> getSetRGBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setRGB",
      requestType = generated.RGBRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.RGBRequest,
      generated.Status> getSetRGBMethod() {
    io.grpc.MethodDescriptor<generated.RGBRequest, generated.Status> getSetRGBMethod;
    if ((getSetRGBMethod = AdvancedLightGrpc.getSetRGBMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetRGBMethod = AdvancedLightGrpc.getSetRGBMethod) == null) {
          AdvancedLightGrpc.getSetRGBMethod = getSetRGBMethod =
              io.grpc.MethodDescriptor.<generated.RGBRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setRGB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.RGBRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setRGB"))
              .build();
        }
      }
    }
    return getSetRGBMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.HueRequest,
      generated.Status> getSetHueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setHue",
      requestType = generated.HueRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.HueRequest,
      generated.Status> getSetHueMethod() {
    io.grpc.MethodDescriptor<generated.HueRequest, generated.Status> getSetHueMethod;
    if ((getSetHueMethod = AdvancedLightGrpc.getSetHueMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetHueMethod = AdvancedLightGrpc.getSetHueMethod) == null) {
          AdvancedLightGrpc.getSetHueMethod = getSetHueMethod =
              io.grpc.MethodDescriptor.<generated.HueRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setHue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.HueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setHue"))
              .build();
        }
      }
    }
    return getSetHueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.EffectRequest,
      generated.Status> getSetEffectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setEffect",
      requestType = generated.EffectRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.EffectRequest,
      generated.Status> getSetEffectMethod() {
    io.grpc.MethodDescriptor<generated.EffectRequest, generated.Status> getSetEffectMethod;
    if ((getSetEffectMethod = AdvancedLightGrpc.getSetEffectMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetEffectMethod = AdvancedLightGrpc.getSetEffectMethod) == null) {
          AdvancedLightGrpc.getSetEffectMethod = getSetEffectMethod =
              io.grpc.MethodDescriptor.<generated.EffectRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setEffect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.EffectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setEffect"))
              .build();
        }
      }
    }
    return getSetEffectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.AnimationRequest,
      generated.Status> getSetStripAnimationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setStripAnimation",
      requestType = generated.AnimationRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.AnimationRequest,
      generated.Status> getSetStripAnimationMethod() {
    io.grpc.MethodDescriptor<generated.AnimationRequest, generated.Status> getSetStripAnimationMethod;
    if ((getSetStripAnimationMethod = AdvancedLightGrpc.getSetStripAnimationMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetStripAnimationMethod = AdvancedLightGrpc.getSetStripAnimationMethod) == null) {
          AdvancedLightGrpc.getSetStripAnimationMethod = getSetStripAnimationMethod =
              io.grpc.MethodDescriptor.<generated.AnimationRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setStripAnimation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.AnimationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setStripAnimation"))
              .build();
        }
      }
    }
    return getSetStripAnimationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.MotionRequest,
      generated.Status> getSetMotionDetecionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setMotionDetecion",
      requestType = generated.MotionRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.MotionRequest,
      generated.Status> getSetMotionDetecionMethod() {
    io.grpc.MethodDescriptor<generated.MotionRequest, generated.Status> getSetMotionDetecionMethod;
    if ((getSetMotionDetecionMethod = AdvancedLightGrpc.getSetMotionDetecionMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetMotionDetecionMethod = AdvancedLightGrpc.getSetMotionDetecionMethod) == null) {
          AdvancedLightGrpc.getSetMotionDetecionMethod = getSetMotionDetecionMethod =
              io.grpc.MethodDescriptor.<generated.MotionRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setMotionDetecion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.MotionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setMotionDetecion"))
              .build();
        }
      }
    }
    return getSetMotionDetecionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.SensitivityRequest,
      generated.Status> getSetMotionSensitivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setMotionSensitivity",
      requestType = generated.SensitivityRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.SensitivityRequest,
      generated.Status> getSetMotionSensitivityMethod() {
    io.grpc.MethodDescriptor<generated.SensitivityRequest, generated.Status> getSetMotionSensitivityMethod;
    if ((getSetMotionSensitivityMethod = AdvancedLightGrpc.getSetMotionSensitivityMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetMotionSensitivityMethod = AdvancedLightGrpc.getSetMotionSensitivityMethod) == null) {
          AdvancedLightGrpc.getSetMotionSensitivityMethod = getSetMotionSensitivityMethod =
              io.grpc.MethodDescriptor.<generated.SensitivityRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setMotionSensitivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.SensitivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setMotionSensitivity"))
              .build();
        }
      }
    }
    return getSetMotionSensitivityMethod;
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
    if ((getSetWeatherModeMethod = AdvancedLightGrpc.getSetWeatherModeMethod) == null) {
      synchronized (AdvancedLightGrpc.class) {
        if ((getSetWeatherModeMethod = AdvancedLightGrpc.getSetWeatherModeMethod) == null) {
          AdvancedLightGrpc.getSetWeatherModeMethod = getSetWeatherModeMethod =
              io.grpc.MethodDescriptor.<generated.WeatherRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setWeatherMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new AdvancedLightMethodDescriptorSupplier("setWeatherMode"))
              .build();
        }
      }
    }
    return getSetWeatherModeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdvancedLightStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedLightStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedLightStub>() {
        @java.lang.Override
        public AdvancedLightStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedLightStub(channel, callOptions);
        }
      };
    return AdvancedLightStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AdvancedLightBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedLightBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedLightBlockingV2Stub>() {
        @java.lang.Override
        public AdvancedLightBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedLightBlockingV2Stub(channel, callOptions);
        }
      };
    return AdvancedLightBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdvancedLightBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedLightBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedLightBlockingStub>() {
        @java.lang.Override
        public AdvancedLightBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedLightBlockingStub(channel, callOptions);
        }
      };
    return AdvancedLightBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdvancedLightFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvancedLightFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvancedLightFutureStub>() {
        @java.lang.Override
        public AdvancedLightFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvancedLightFutureStub(channel, callOptions);
        }
      };
    return AdvancedLightFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setRGB(generated.RGBRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetRGBMethod(), responseObserver);
    }

    /**
     */
    default void setHue(generated.HueRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetHueMethod(), responseObserver);
    }

    /**
     */
    default void setEffect(generated.EffectRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetEffectMethod(), responseObserver);
    }

    /**
     */
    default void setStripAnimation(generated.AnimationRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetStripAnimationMethod(), responseObserver);
    }

    /**
     */
    default void setMotionDetecion(generated.MotionRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMotionDetecionMethod(), responseObserver);
    }

    /**
     */
    default void setMotionSensitivity(generated.SensitivityRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMotionSensitivityMethod(), responseObserver);
    }

    /**
     */
    default void setWeatherMode(generated.WeatherRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetWeatherModeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdvancedLight.
   */
  public static abstract class AdvancedLightImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdvancedLightGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdvancedLight.
   */
  public static final class AdvancedLightStub
      extends io.grpc.stub.AbstractAsyncStub<AdvancedLightStub> {
    private AdvancedLightStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedLightStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedLightStub(channel, callOptions);
    }

    /**
     */
    public void setRGB(generated.RGBRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetRGBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setHue(generated.HueRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetHueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setEffect(generated.EffectRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetEffectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setStripAnimation(generated.AnimationRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetStripAnimationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMotionDetecion(generated.MotionRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMotionDetecionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMotionSensitivity(generated.SensitivityRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMotionSensitivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setWeatherMode(generated.WeatherRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetWeatherModeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdvancedLight.
   */
  public static final class AdvancedLightBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AdvancedLightBlockingV2Stub> {
    private AdvancedLightBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedLightBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedLightBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.Status setRGB(generated.RGBRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetRGBMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setHue(generated.HueRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetHueMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setEffect(generated.EffectRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetEffectMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setStripAnimation(generated.AnimationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetStripAnimationMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setMotionDetecion(generated.MotionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetMotionDetecionMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setMotionSensitivity(generated.SensitivityRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetMotionSensitivityMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setWeatherMode(generated.WeatherRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetWeatherModeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AdvancedLight.
   */
  public static final class AdvancedLightBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdvancedLightBlockingStub> {
    private AdvancedLightBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedLightBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedLightBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Status setRGB(generated.RGBRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetRGBMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setHue(generated.HueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetHueMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setEffect(generated.EffectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetEffectMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setStripAnimation(generated.AnimationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetStripAnimationMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setMotionDetecion(generated.MotionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMotionDetecionMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setMotionSensitivity(generated.SensitivityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMotionSensitivityMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status setWeatherMode(generated.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetWeatherModeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdvancedLight.
   */
  public static final class AdvancedLightFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdvancedLightFutureStub> {
    private AdvancedLightFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvancedLightFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvancedLightFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setRGB(
        generated.RGBRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetRGBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setHue(
        generated.HueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetHueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setEffect(
        generated.EffectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetEffectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setStripAnimation(
        generated.AnimationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetStripAnimationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setMotionDetecion(
        generated.MotionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMotionDetecionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setMotionSensitivity(
        generated.SensitivityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMotionSensitivityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> setWeatherMode(
        generated.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetWeatherModeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_RGB = 0;
  private static final int METHODID_SET_HUE = 1;
  private static final int METHODID_SET_EFFECT = 2;
  private static final int METHODID_SET_STRIP_ANIMATION = 3;
  private static final int METHODID_SET_MOTION_DETECION = 4;
  private static final int METHODID_SET_MOTION_SENSITIVITY = 5;
  private static final int METHODID_SET_WEATHER_MODE = 6;

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
        case METHODID_SET_RGB:
          serviceImpl.setRGB((generated.RGBRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_HUE:
          serviceImpl.setHue((generated.HueRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_EFFECT:
          serviceImpl.setEffect((generated.EffectRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_STRIP_ANIMATION:
          serviceImpl.setStripAnimation((generated.AnimationRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_MOTION_DETECION:
          serviceImpl.setMotionDetecion((generated.MotionRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_MOTION_SENSITIVITY:
          serviceImpl.setMotionSensitivity((generated.SensitivityRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_SET_WEATHER_MODE:
          serviceImpl.setWeatherMode((generated.WeatherRequest) request,
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
          getSetRGBMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.RGBRequest,
              generated.Status>(
                service, METHODID_SET_RGB)))
        .addMethod(
          getSetHueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.HueRequest,
              generated.Status>(
                service, METHODID_SET_HUE)))
        .addMethod(
          getSetEffectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.EffectRequest,
              generated.Status>(
                service, METHODID_SET_EFFECT)))
        .addMethod(
          getSetStripAnimationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.AnimationRequest,
              generated.Status>(
                service, METHODID_SET_STRIP_ANIMATION)))
        .addMethod(
          getSetMotionDetecionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.MotionRequest,
              generated.Status>(
                service, METHODID_SET_MOTION_DETECION)))
        .addMethod(
          getSetMotionSensitivityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.SensitivityRequest,
              generated.Status>(
                service, METHODID_SET_MOTION_SENSITIVITY)))
        .addMethod(
          getSetWeatherModeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.WeatherRequest,
              generated.Status>(
                service, METHODID_SET_WEATHER_MODE)))
        .build();
  }

  private static abstract class AdvancedLightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdvancedLightBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdvancedLight");
    }
  }

  private static final class AdvancedLightFileDescriptorSupplier
      extends AdvancedLightBaseDescriptorSupplier {
    AdvancedLightFileDescriptorSupplier() {}
  }

  private static final class AdvancedLightMethodDescriptorSupplier
      extends AdvancedLightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdvancedLightMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdvancedLightGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdvancedLightFileDescriptorSupplier())
              .addMethod(getSetRGBMethod())
              .addMethod(getSetHueMethod())
              .addMethod(getSetEffectMethod())
              .addMethod(getSetStripAnimationMethod())
              .addMethod(getSetMotionDetecionMethod())
              .addMethod(getSetMotionSensitivityMethod())
              .addMethod(getSetWeatherModeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
