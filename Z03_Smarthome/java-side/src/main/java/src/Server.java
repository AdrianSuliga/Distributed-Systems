package src;

import io.grpc.ServerBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private String address = "127.0.0.5";
    private int port = 50051;
    private io.grpc.Server server;

    private SocketAddress socket;

    private void start() throws IOException
    {
        try {
            socket = new InetSocketAddress(InetAddress.getByName(address), port);
        } catch(UnknownHostException e) { }

        server = ServerBuilder.forPort(port).executor((Executors.newFixedThreadPool(16)))
                .addService(new TestImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("Shutting down gRPC server...");
            Server.this.stop();
            System.err.println("Server shut down.");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final Server server = new Server();
        server.start();
        server.blockUntilShutdown();
    }
}
