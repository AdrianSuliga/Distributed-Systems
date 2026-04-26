package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class TestGrpc {

  private TestGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contract.Test";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.Empty,
      generated.EchoResult> getEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "echo",
      requestType = generated.Empty.class,
      responseType = generated.EchoResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.Empty,
      generated.EchoResult> getEchoMethod() {
    io.grpc.MethodDescriptor<generated.Empty, generated.EchoResult> getEchoMethod;
    if ((getEchoMethod = TestGrpc.getEchoMethod) == null) {
      synchronized (TestGrpc.class) {
        if ((getEchoMethod = TestGrpc.getEchoMethod) == null) {
          TestGrpc.getEchoMethod = getEchoMethod =
              io.grpc.MethodDescriptor.<generated.Empty, generated.EchoResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "echo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.EchoResult.getDefaultInstance()))
              .setSchemaDescriptor(new TestMethodDescriptorSupplier("echo"))
              .build();
        }
      }
    }
    return getEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.ArithmeticOpArguments,
      generated.ArithmeticOpResult> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = generated.ArithmeticOpArguments.class,
      responseType = generated.ArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.ArithmeticOpArguments,
      generated.ArithmeticOpResult> getAddMethod() {
    io.grpc.MethodDescriptor<generated.ArithmeticOpArguments, generated.ArithmeticOpResult> getAddMethod;
    if ((getAddMethod = TestGrpc.getAddMethod) == null) {
      synchronized (TestGrpc.class) {
        if ((getAddMethod = TestGrpc.getAddMethod) == null) {
          TestGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<generated.ArithmeticOpArguments, generated.ArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new TestMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestStub>() {
        @java.lang.Override
        public TestStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestStub(channel, callOptions);
        }
      };
    return TestStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static TestBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestBlockingV2Stub>() {
        @java.lang.Override
        public TestBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestBlockingV2Stub(channel, callOptions);
        }
      };
    return TestBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestBlockingStub>() {
        @java.lang.Override
        public TestBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestBlockingStub(channel, callOptions);
        }
      };
    return TestBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestFutureStub>() {
        @java.lang.Override
        public TestFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestFutureStub(channel, callOptions);
        }
      };
    return TestFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void echo(generated.Empty request,
        io.grpc.stub.StreamObserver<generated.EchoResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoMethod(), responseObserver);
    }

    /**
     */
    default void add(generated.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<generated.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Test.
   */
  public static abstract class TestImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TestGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Test.
   */
  public static final class TestStub
      extends io.grpc.stub.AbstractAsyncStub<TestStub> {
    private TestStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestStub(channel, callOptions);
    }

    /**
     */
    public void echo(generated.Empty request,
        io.grpc.stub.StreamObserver<generated.EchoResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(generated.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<generated.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Test.
   */
  public static final class TestBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TestBlockingV2Stub> {
    private TestBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public generated.EchoResult echo(generated.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEchoMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.ArithmeticOpResult add(generated.ArithmeticOpArguments request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Test.
   */
  public static final class TestBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TestBlockingStub> {
    private TestBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.EchoResult echo(generated.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.ArithmeticOpResult add(generated.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Test.
   */
  public static final class TestFutureStub
      extends io.grpc.stub.AbstractFutureStub<TestFutureStub> {
    private TestFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.EchoResult> echo(
        generated.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.ArithmeticOpResult> add(
        generated.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;
  private static final int METHODID_ADD = 1;

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
        case METHODID_ECHO:
          serviceImpl.echo((generated.Empty) request,
              (io.grpc.stub.StreamObserver<generated.EchoResult>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((generated.ArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<generated.ArithmeticOpResult>) responseObserver);
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
          getEchoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.Empty,
              generated.EchoResult>(
                service, METHODID_ECHO)))
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.ArithmeticOpArguments,
              generated.ArithmeticOpResult>(
                service, METHODID_ADD)))
        .build();
  }

  private static abstract class TestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Test");
    }
  }

  private static final class TestFileDescriptorSupplier
      extends TestBaseDescriptorSupplier {
    TestFileDescriptorSupplier() {}
  }

  private static final class TestMethodDescriptorSupplier
      extends TestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TestMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestFileDescriptorSupplier())
              .addMethod(getEchoMethod())
              .addMethod(getAddMethod())
              .build();
        }
      }
    }
    return result;
  }
}
