package src;

import generated.*;

public class TestImpl extends TestGrpc.TestImplBase {
    @Override
    public void echo(Empty request, io.grpc.stub.StreamObserver<EchoResult> responseObserver)
    {
        String message = "ECHO";
        EchoResult result = EchoResult.newBuilder().setRes(message).build();

        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void add(ArithmeticOpArguments request, io.grpc.stub.StreamObserver<ArithmeticOpResult> responseObserver)
    {
        System.out.println("addRequest (" + request.getArg1() + ", " + request.getArg2() +")");
        int val = request.getArg1() + request.getArg2();
        ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();

        if (request.getArg1() > 100 && request.getArg2() > 100) {
            try {
                Thread.sleep(5000);
            } catch (java.lang.InterruptedException ex) { }
        }

        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
