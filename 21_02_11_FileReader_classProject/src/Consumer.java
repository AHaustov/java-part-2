import Operations.IStringOperation;
import Operations.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext oc;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext oc) {
        this.queue = queue;
        this.writer = writer;
        this.oc = oc;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String temp = queue.take();
                String toWrite = handleStr(temp);
                writer.println(toWrite);
                System.out.println(temp);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String handleStr(String line) {
        if (!line.contains("#") || line.indexOf('#') != line.lastIndexOf('#'))
            return line + "#wrong format";

        int index = line.indexOf('#') + 1;
        if (index < line.length()) {
            IStringOperation handle = oc.getOperation(line.substring(index));
            if (handle != null)
                return handle.operate(line.substring(0, index - 1));
        }
        return line + "#wrong operation";
    }
}
