import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class Service implements Runnable {
    private final Socket socket;
    private final ThreadPoolExecutor pool;

    protected Service(Socket socket, ThreadPoolExecutor pool) {
        this.socket = socket;
        this.pool = pool;
    }


    @Override
    public void run() {
        try (PrintStream socketOutput = new PrintStream(socket.getOutputStream());
             BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Connected");

            String line;
            while ((line = socketInput.readLine()) != null) {
                String respone = "Handled by Server " + line;
                socketOutput.println(respone);
            }
            System.out.println("exit socket");
            Main.countActiveServices(pool);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
