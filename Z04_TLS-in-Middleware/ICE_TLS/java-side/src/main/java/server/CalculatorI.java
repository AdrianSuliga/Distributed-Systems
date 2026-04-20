package server;

import com.zeroc.Ice.Current;

public class CalculatorI implements Contract.Calculator {
    @Override
    public long add(int a, int b, Current __current) {
        System.out.println("Servant adding " + a + " and " + b);
        return a + b;
    }
}
