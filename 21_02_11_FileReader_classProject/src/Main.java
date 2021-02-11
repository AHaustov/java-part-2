import Operations.OperationContext;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        OperationContext oc = new OperationContext();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
                Thread supplier = new Thread(new Supplier(br, queue));
                Thread consumer = new Thread(new Consumer(queue, pw, oc));
                supplier.isDaemon();
                consumer.isDaemon();

                supplier.start();
                consumer.start();

                supplier.join();
                consumer.join();

            }
        }
    }
}
