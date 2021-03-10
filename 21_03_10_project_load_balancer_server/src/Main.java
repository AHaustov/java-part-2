import java.io.IOException;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    private final static int UDP_SERVER_PORT = 4000;
    private final static String UDP_SERVER_HOST = "localhost";

    public static void main(String[] args) throws IOException {

        int port = Integer.parseInt(args[0]);

        ServerSocket serverSocket = new ServerSocket(port);

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new Service(socket, pool));
            countActiveServices(pool);
        }

    }


    static void countActiveServices(ThreadPoolExecutor pool) throws IOException {

        String activeCount = String.valueOf(pool.getActiveCount());
        byte[] outputData = activeCount.getBytes();

        DatagramSocket udpSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName(UDP_SERVER_HOST);

        DatagramPacket packetOut = new DatagramPacket(
                outputData,
                outputData.length,
                inetAddress,
                UDP_SERVER_PORT
        );
        udpSocket.send(packetOut);
    }
}
