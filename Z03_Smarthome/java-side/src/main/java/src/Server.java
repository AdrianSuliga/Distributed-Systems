package src;

import io.grpc.ServerBuilder;
import model.*;
import repository.DeviceRepository;

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
    private int port;
    private String site;
    private io.grpc.Server server;

    private SocketAddress socket;

    public Server(int port, String site) {
        this.port = port;
        this.site = site;
    }

    private void start() throws IOException
    {
        try {
            socket = new InetSocketAddress(InetAddress.getByName(address), port);
        } catch (UnknownHostException e) { }

        DeviceRepository repo = new DeviceRepository();

        if (this.site.equals("Kraków")) {
            repo.addDevice(new RGBLamp(1, "RGB Lamp Tracer Smart Desk 1"));
            repo.addDevice(new RGBLamp(2, "RGB Lamp Tracer Smart Desk 2"));
            repo.addDevice(new LEDStrip(3, "LED strip 5m Govee Strip"));
            repo.addDevice(new OutdoorLamp(4, "Outdoor Govee Detection Lamp"));

            repo.addDevice(new IndoorCamera(5, "Eufy Indoor Cam"));
            repo.addDevice(new OutdoorCamera(6, "Tapo TP-LINK security camera 1"));
            repo.addDevice(new OutdoorCamera(7, "Tapo TP-LINK security camera 2"));
            repo.addDevice(new ThermalCamera(8, "FLIR Thermal Camera"));
        } else if (this.site.equals("Łódź")) {
            repo.addDevice(new RGBLamp(9, "RGB Lamp Tracer Smart Desk 2"));
            repo.addDevice(new RGBLamp(10, "RGB Lamp Tracer Smart Desk 3"));
            repo.addDevice(new LEDStrip(11, "LED strip 8m Govee Strip"));
            repo.addDevice(new OutdoorLamp(12, "Outdoor SmartX Detection Lamp"));

            repo.addDevice(new IndoorCamera(13, "Eufer Indoor Cam"));
            repo.addDevice(new OutdoorCamera(14, "Tapo TP-LINK security camera 3"));
            repo.addDevice(new OutdoorCamera(15, "Tapo TP-LINK security camera 4"));
            repo.addDevice(new ThermalCamera(16, "FIRE Thermal Camera"));
        }

        server = ServerBuilder.forPort(port).executor((Executors.newFixedThreadPool(16)))
                .addService(new TestImpl())
                .addService(new RegistryImpl(repo))
                .addService(new DeviceImpl(repo))
                .addService(new LightImpl(repo))
                .addService(new AdvancedLightImpl(repo))
                .addService(new MonitoringImpl(repo))
                .addService(new AdvancedMonitoringImpl(repo))
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

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(args[0]);
        String floor = args[1];

        final Server server = new Server(port, floor);
        server.start();
        server.blockUntilShutdown();
    }
}
