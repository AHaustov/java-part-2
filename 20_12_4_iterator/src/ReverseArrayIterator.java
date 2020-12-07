import java.util.Iterator;

public class ReverseArrayIterator implements Iterator<Integer> {
    private final int[] arrayToIterate;
    private int currentIndex;

    ReverseArrayIterator(int[] arrayToIterate) {
        this.arrayToIterate = arrayToIterate;
        currentIndex = arrayToIterate.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Integer next() {
        return arrayToIterate[currentIndex--];
    }
}
