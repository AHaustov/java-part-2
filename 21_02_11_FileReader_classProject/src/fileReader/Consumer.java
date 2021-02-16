package fileReader;

import fileReader.operations.IStringOperation;
import fileReader.operations.OperationContext;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {

    final public static String SEPARATOR = "#";
    final public static String WRONG_FORMAT = "wrong format";
    final public static String WRONG_OPERATION = "wrong operation";

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


    String handleStr(String line) {
        String[] res = line.split(SEPARATOR);
        if (res.length != 2)
            return line + SEPARATOR + WRONG_FORMAT;
        String stringToPerform = res[0];
        String operationName = res[1];

        IStringOperation stringOperation = oc.getOperation(operationName);

        if (stringOperation == null)
            return line + SEPARATOR + WRONG_OPERATION;

        return stringOperation.operate(stringToPerform);
    }
}
