package fileReader;

import fileReader.operations.OperationContext;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        ConfigReader cr = new ConfigReader("config.props");
        List<String> operations = cr.getOperationPaths();
        OperationContext oc = new OperationContext(operations);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        LineCounter lc = new LineCounter();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        Thread supplier = new Thread(new Supplier(br, queue, lc));
        Thread consumer = new Thread(new Consumer(queue, pw, oc, lc));
        Thread consumer2 = new Thread(new Consumer(queue, pw, oc, lc));
        Thread consumer3 = new Thread(new Consumer(queue, pw, oc, lc));

        consumer.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);
        supplier.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
        supplier.join();

        while (lc.count != 0)
            Thread.sleep(1);

        pw.close();
        br.close();
    }


}
