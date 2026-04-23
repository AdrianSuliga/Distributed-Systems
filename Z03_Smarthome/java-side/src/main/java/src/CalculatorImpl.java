package src;

import generated.ArithmeticOpArguments;
import generated.ArithmeticOpResult;
import generated.CalculatorGrpc;

public class CalculatorImpl extends CalculatorGrpc.CalculatorImplBase {
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
