import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static int TCP_PORT = 3000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(TCP_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            Thread newSection = new Thread(new Service(socket));
            newSection.start();
        }
    }


}