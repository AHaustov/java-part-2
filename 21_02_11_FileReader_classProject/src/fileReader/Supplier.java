package fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Supplier implements Runnable {

    private final BufferedReader br;
    private final BlockingQueue<String> queue;
    LineCounter lc;

    public Supplier(BufferedReader br, BlockingQueue<String> queue, LineCounter lc) {
        this.br = br;
        this.queue = queue;
        this.lc = lc;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                queue.put(line);
                lc.increase();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
