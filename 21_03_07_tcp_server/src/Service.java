import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Service implements Runnable {
    Socket socket;

    public Service(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connected");

            PrintStream socketOutput = new PrintStream(socket.getOutputStream());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = socketInput.readLine()) != null) {
                String respone = "Handled by Server " + line;
                socketOutput.println(respone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
