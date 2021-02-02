import java.io.*;

public class HWWriter {
    public static void main(String[] args) throws IOException {
        writeFromConsole();
    }

    public static void writeFromConsole() throws IOException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.equals("exit")) {
            pw.println(line);
        }
        pw.flush();
    }
}
