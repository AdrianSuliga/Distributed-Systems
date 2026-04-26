package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MonitoringGrpc {

  private MonitoringGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.Monitoring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.MoveRequest,
      generated.Status> getMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "move",
      requestType = generated.MoveRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.MoveRequest,
      generated.Status> getMoveMethod() {
    io.grpc.MethodDescriptor<generated.MoveRequest, generated.Status> getMoveMethod;
    if ((getMoveMethod = MonitoringGrpc.getMoveMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getMoveMethod = MonitoringGrpc.getMoveMethod) == null) {
          MonitoringGrpc.getMoveMethod = getMoveMethod =
              io.grpc.MethodDescriptor.<generated.MoveRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "move"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.MoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("move"))
              .build();
        }
      }
    }
    return getMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.CaptureOneRequest,
      generated.Image> getCaptureImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "captureImage",
      requestType = generated.CaptureOneRequest.class,
      responseType = generated.Image.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.CaptureOneRequest,
      generated.Image> getCaptureImageMethod() {
    io.grpc.MethodDescriptor<generated.CaptureOneRequest, generated.Image> getCaptureImageMethod;
    if ((getCaptureImageMethod = MonitoringGrpc.getCaptureImageMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getCaptureImageMethod = MonitoringGrpc.getCaptureImageMethod) == null) {
          MonitoringGrpc.getCaptureImageMethod = getCaptureImageMethod =
              io.grpc.MethodDescriptor.<generated.CaptureOneRequest, generated.Image>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "captureImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.CaptureOneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Image.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("captureImage"))
              .build();
        }
      }
    }
    return getCaptureImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.CaptureManyRequest,
      generated.Images> getCaptureImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "captureImages",
      requestType = generated.CaptureManyRequest.class,
      responseType = generated.Images.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.CaptureManyRequest,
      generated.Images> getCaptureImagesMethod() {
    io.grpc.MethodDescriptor<generated.CaptureManyRequest, generated.Images> getCaptureImagesMethod;
    if ((getCaptureImagesMethod = MonitoringGrpc.getCaptureImagesMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getCaptureImagesMethod = MonitoringGrpc.getCaptureImagesMethod) == null) {
          MonitoringGrpc.getCaptureImagesMethod = getCaptureImagesMethod =
              io.grpc.MethodDescriptor.<generated.CaptureManyRequest, generated.Images>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "captureImages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.CaptureManyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Images.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("captureImages"))
              .build();
        }
      }
    }
    return getCaptureImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getStartRecordingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startRecording",
      requestType = generated.DeviceId.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Status> getStartRecordingMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.Status> getStartRecordingMethod;
    if ((getStartRecordingMethod = MonitoringGrpc.getStartRecordingMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getStartRecordingMethod = MonitoringGrpc.getStartRecordingMethod) == null) {
          MonitoringGrpc.getStartRecordingMethod = getStartRecordingMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "startRecording"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("startRecording"))
              .build();
        }
      }
    }
    return getStartRecordingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Recording> getEndRecordingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "endRecording",
      requestType = generated.DeviceId.class,
      responseType = generated.Recording.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.DeviceId,
      generated.Recording> getEndRecordingMethod() {
    io.grpc.MethodDescriptor<generated.DeviceId, generated.Recording> getEndRecordingMethod;
    if ((getEndRecordingMethod = MonitoringGrpc.getEndRecordingMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getEndRecordingMethod = MonitoringGrpc.getEndRecordingMethod) == null) {
          MonitoringGrpc.getEndRecordingMethod = getEndRecordingMethod =
              io.grpc.MethodDescriptor.<generated.DeviceId, generated.Recording>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "endRecording"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.DeviceId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Recording.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("endRecording"))
              .build();
        }
      }
    }
    return getEndRecordingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.PatrolRequest,
      generated.Status> getConfigurePatrolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "configurePatrol",
      requestType = generated.PatrolRequest.class,
      responseType = generated.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.PatrolRequest,
      generated.Status> getConfigurePatrolMethod() {
    io.grpc.MethodDescriptor<generated.PatrolRequest, generated.Status> getConfigurePatrolMethod;
    if ((getConfigurePatrolMethod = MonitoringGrpc.getConfigurePatrolMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getConfigurePatrolMethod = MonitoringGrpc.getConfigurePatrolMethod) == null) {
          MonitoringGrpc.getConfigurePatrolMethod = getConfigurePatrolMethod =
              io.grpc.MethodDescriptor.<generated.PatrolRequest, generated.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "configurePatrol"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.PatrolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Status.getDefaultInstance()))
              .setSchemaDescriptor(new MonitoringMethodDescriptorSupplier("configurePatrol"))
              .build();
        }
      }
    }
    return getConfigurePatrolMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitoringStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitoringStub>() {
        @java.lang.Override
        public MonitoringStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitoringStub(channel, callOptions);
        }
      };
    return MonitoringStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static MonitoringBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingV2Stub>() {
        @java.lang.Override
        public MonitoringBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitoringBlockingV2Stub(channel, callOptions);
        }
      };
    return MonitoringBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitoringBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingStub>() {
        @java.lang.Override
        public MonitoringBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitoringBlockingStub(channel, callOptions);
        }
      };
    return MonitoringBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitoringFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MonitoringFutureStub>() {
        @java.lang.Override
        public MonitoringFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MonitoringFutureStub(channel, callOptions);
        }
      };
    return MonitoringFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void move(generated.MoveRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMoveMethod(), responseObserver);
    }

    /**
     */
    default void captureImage(generated.CaptureOneRequest request,
        io.grpc.stub.StreamObserver<generated.Image> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCaptureImageMethod(), responseObserver);
    }

    /**
     */
    default void captureImages(generated.CaptureManyRequest request,
        io.grpc.stub.StreamObserver<generated.Images> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCaptureImagesMethod(), responseObserver);
    }

    /**
     */
    default void startRecording(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartRecordingMethod(), responseObserver);
    }

    /**
     */
    default void endRecording(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Recording> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEndRecordingMethod(), responseObserver);
    }

    /**
     */
    default void configurePatrol(generated.PatrolRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConfigurePatrolMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Monitoring.
   */
  public static abstract class MonitoringImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MonitoringGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Monitoring.
   */
  public static final class MonitoringStub
      extends io.grpc.stub.AbstractAsyncStub<MonitoringStub> {
    private MonitoringStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringStub(channel, callOptions);
    }

    /**
     */
    public void move(generated.MoveRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void captureImage(generated.CaptureOneRequest request,
        io.grpc.stub.StreamObserver<generated.Image> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCaptureImageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void captureImages(generated.CaptureManyRequest request,
        io.grpc.stub.StreamObserver<generated.Images> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCaptureImagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startRecording(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartRecordingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endRecording(generated.DeviceId request,
        io.grpc.stub.StreamObserver<generated.Recording> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEndRecordingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void configurePatrol(generated.PatrolRequest request,
        io.grpc.stub.StreamObserver<generated.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConfigurePatrolMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Monitoring.
   */
  public static final class MonitoringBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MonitoringBlockingV2Stub> {
    private MonitoringBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.Status move(generated.MoveRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Image captureImage(generated.CaptureOneRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCaptureImageMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Images captureImages(generated.CaptureManyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCaptureImagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status startRecording(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartRecordingMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Recording endRecording(generated.DeviceId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEndRecordingMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status configurePatrol(generated.PatrolRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getConfigurePatrolMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Monitoring.
   */
  public static final class MonitoringBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MonitoringBlockingStub> {
    private MonitoringBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Status move(generated.MoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Image captureImage(generated.CaptureOneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCaptureImageMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Images captureImages(generated.CaptureManyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCaptureImagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status startRecording(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartRecordingMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Recording endRecording(generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEndRecordingMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.Status configurePatrol(generated.PatrolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConfigurePatrolMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Monitoring.
   */
  public static final class MonitoringFutureStub
      extends io.grpc.stub.AbstractFutureStub<MonitoringFutureStub> {
    private MonitoringFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> move(
        generated.MoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Image> captureImage(
        generated.CaptureOneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCaptureImageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Images> captureImages(
        generated.CaptureManyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCaptureImagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> startRecording(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartRecordingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Recording> endRecording(
        generated.DeviceId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEndRecordingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Status> configurePatrol(
        generated.PatrolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConfigurePatrolMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MOVE = 0;
  private static final int METHODID_CAPTURE_IMAGE = 1;
  private static final int METHODID_CAPTURE_IMAGES = 2;
  private static final int METHODID_START_RECORDING = 3;
  private static final int METHODID_END_RECORDING = 4;
  private static final int METHODID_CONFIGURE_PATROL = 5;

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
        case METHODID_MOVE:
          serviceImpl.move((generated.MoveRequest) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_CAPTURE_IMAGE:
          serviceImpl.captureImage((generated.CaptureOneRequest) request,
              (io.grpc.stub.StreamObserver<generated.Image>) responseObserver);
          break;
        case METHODID_CAPTURE_IMAGES:
          serviceImpl.captureImages((generated.CaptureManyRequest) request,
              (io.grpc.stub.StreamObserver<generated.Images>) responseObserver);
          break;
        case METHODID_START_RECORDING:
          serviceImpl.startRecording((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.Status>) responseObserver);
          break;
        case METHODID_END_RECORDING:
          serviceImpl.endRecording((generated.DeviceId) request,
              (io.grpc.stub.StreamObserver<generated.Recording>) responseObserver);
          break;
        case METHODID_CONFIGURE_PATROL:
          serviceImpl.configurePatrol((generated.PatrolRequest) request,
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
          getMoveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.MoveRequest,
              generated.Status>(
                service, METHODID_MOVE)))
        .addMethod(
          getCaptureImageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.CaptureOneRequest,
              generated.Image>(
                service, METHODID_CAPTURE_IMAGE)))
        .addMethod(
          getCaptureImagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.CaptureManyRequest,
              generated.Images>(
                service, METHODID_CAPTURE_IMAGES)))
        .addMethod(
          getStartRecordingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.Status>(
                service, METHODID_START_RECORDING)))
        .addMethod(
          getEndRecordingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.DeviceId,
              generated.Recording>(
                service, METHODID_END_RECORDING)))
        .addMethod(
          getConfigurePatrolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.PatrolRequest,
              generated.Status>(
                service, METHODID_CONFIGURE_PATROL)))
        .build();
  }

  private static abstract class MonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitoringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Monitoring");
    }
  }

  private static final class MonitoringFileDescriptorSupplier
      extends MonitoringBaseDescriptorSupplier {
    MonitoringFileDescriptorSupplier() {}
  }

  private static final class MonitoringMethodDescriptorSupplier
      extends MonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MonitoringMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MonitoringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitoringFileDescriptorSupplier())
              .addMethod(getMoveMethod())
              .addMethod(getCaptureImageMethod())
              .addMethod(getCaptureImagesMethod())
              .addMethod(getStartRecordingMethod())
              .addMethod(getEndRecordingMethod())
              .addMethod(getConfigurePatrolMethod())
              .build();
        }
      }
    }
    return result;
  }
}
