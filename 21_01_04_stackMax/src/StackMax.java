import java.util.ArrayDeque;
import java.util.Comparator;


public class StackMax<T> {
    private final ArrayDeque<T> source;
    private final ArrayDeque<T> maxStack;
    private final Comparator<T> comparator;

    public StackMax(Comparator<T> comparator) {
        this.comparator = comparator;
        source = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }


    public void addLast(T elt) {
        if (source.size() == 0) {
            maxStack.addLast(elt);
            source.addLast(elt);
        } else if (comparator.compare(elt, getMax())>=0) {
            maxStack.addLast(elt);
            source.addLast(elt);
        } else
            source.addLast(elt);
    }

    public T getLast() {
        if (source.size() == 0)
            throw new IndexOutOfBoundsException();
        return source.getLast();
    }

    public T removeLast() {
        if (source.size() == 0)
            throw new IndexOutOfBoundsException();
        if (comparator.compare(getLast(), getMax())  >=0)
            maxStack.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public T getMax() {
        if (source.size() == 0)
            throw new IndexOutOfBoundsException();
        return maxStack.getLast();
    }

   /* public int getMax() {
        int max = source.getFirst();
        for (Integer number : source) {
            max = max < number ? number : max;
        }
        return max;
    }*/
}
