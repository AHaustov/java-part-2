import Operations.OperationContext;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        OperationContext oc = new OperationContext();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
                Thread supplier = new Thread(new Supplier(br, queue));
                Thread consumer = new Thread(new Consumer(queue, pw, oc));
                Thread consumer2 = new Thread(new Consumer(queue, pw, oc));
                Thread consumer3 = new Thread(new Consumer(queue, pw, oc));

                consumer.setDaemon(true);
                consumer2.setDaemon(true);
                consumer3.setDaemon(true);
                supplier.start();
                consumer.start();
                consumer2.start();
                consumer3.start();
                supplier.join();
                while (!queue.isEmpty())
                    Thread.sleep(1);
            }
        }
    }
}
