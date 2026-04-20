package server;

import com.zeroc.Ice.*;

import java.lang.Exception;

public class Server {
    public static void main(String[] args) {
        Communicator communicator = null;

        try {
            communicator = Util.initialize(args);
            ObjectAdapter adapter = null;

            try {
                adapter = communicator.createObjectAdapter("Adapter");
            } catch (InitializationException ex) {
                System.out.println("Provide valid server.config");
                return;
            }

            System.out.println(communicator.getProperties().getProperty("Adapter.Endpoints"));

            PersonRegistryI contractServant = new PersonRegistryI();

            adapter.add(contractServant, new Identity("registry", "contract"));

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
