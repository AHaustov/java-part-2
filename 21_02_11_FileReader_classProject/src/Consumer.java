import operations.IStringOperation;
import operations.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final PrintWriter writer;
    private final OperationContext oc;
    private final LineCounter lc;

    public Consumer(BlockingQueue<String> queue, PrintWriter writer, OperationContext oc, LineCounter lc) {
        this.queue = queue;
        this.writer = writer;
        this.oc = oc;
        this.lc = lc;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String temp = queue.take();
                String toWrite = handleStr(temp);
                writer.println(toWrite);
                lc.decrease();

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
