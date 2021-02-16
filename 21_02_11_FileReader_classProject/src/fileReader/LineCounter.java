package fileReader;

public class LineCounter {

    Integer count;

    public LineCounter() {
        count = 0;
    }

    public void increase() {
        synchronized (count) {
            count++;
        }
    }

    public void decrease() {
        synchronized (count) {
            count--;
        }
    }
}
