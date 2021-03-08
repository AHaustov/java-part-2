import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Service implements Runnable {
    Socket socket;

    public Service(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connected");
            PrintStream history = new PrintStream(new FileOutputStream("history.txt", true));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE.LL.yyyy-hh:mm");

            history.println(socket + " " + now.format(formatter));
            PrintStream socketOutput = new PrintStream(socket.getOutputStream());
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = socketInput.readLine()) != null) {
                String respone = "Handled by Server " + line;
                socketOutput.println(respone);
            }
            history.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
