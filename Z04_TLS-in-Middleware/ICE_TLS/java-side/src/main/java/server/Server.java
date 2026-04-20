package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class Server {
    public static void main(String[] args) {
        Communicator communicator = null;

        try {
            communicator = Util.initialize(args);
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter", "tcp -h 127.0.0.2 -p 10000");
            CalculatorI contractServant = new CalculatorI();

            adapter.add(contractServant, new Identity("contract", "contract"));

            adapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
