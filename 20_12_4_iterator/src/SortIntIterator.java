import java.util.Arrays;
import java.util.Iterator;

public class SortIntIterator implements Iterator<Integer> {
    private final int[] arrayToIterate;
    private int currentIndex = 0;

    public SortIntIterator(int[] arrayToIterate) {
        this.arrayToIterate = Arrays.copyOf(arrayToIterate, arrayToIterate.length);
        Arrays.sort(this.arrayToIterate);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < arrayToIterate.length;
    }

    @Override
    public Integer next() {
        return arrayToIterate[currentIndex++];
    }
}
