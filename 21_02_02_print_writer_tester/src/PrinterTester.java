import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PrinterTester {

    final IPrinter printer;


    public PrinterTester(IPrinter printer) {
        this.printer = printer;

    }

    public long test(String filename, int linesQty, String line) throws IOException {
        long timeBeforeTest = System.currentTimeMillis();
        List<String> text = createText(linesQty, line);
        printer.writeToFile(filename, text);
        return System.currentTimeMillis() - timeBeforeTest;
    }

    private List<String> createText(int linesQty, String line) {
        return Collections.nCopies(linesQty, line);
    }
}
