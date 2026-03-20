import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class JavaUdpSmartServer {

    public static void main(String args[])
    {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9008;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                Arrays.fill(receiveBuffer, (byte)0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + msg);

                DatagramPacket sendPacket = getSendPacket(receivePacket);
                socket.send(sendPacket);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    private static DatagramPacket getSendPacket(DatagramPacket receivePacket) {
        byte[] sendBuffer;
        if (receivePacket.getPort() == 9009) { // JAVA CLIENT
            sendBuffer = "Pong Java".getBytes();
        } else if (receivePacket.getPort() == 9010) { // PYTHON CLIENT
            sendBuffer = "Pong Python".getBytes();
        } else { // OTHER CLIENT
            sendBuffer = "Pong ???".getBytes();
        }

        return new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
        );
    }
}
