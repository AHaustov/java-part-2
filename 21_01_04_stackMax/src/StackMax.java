import java.util.ArrayDeque;
import java.util.ArrayList;

public class StackMax {
    private ArrayDeque<Integer> source;
    private ArrayDeque<Integer> maxStack;

    public StackMax() {
        source = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }


    public void addLast(int elt) {
        if (source.size() == 0)
            maxStack.addLast(elt);
        else {
            int input = getMax() < elt ? elt : getMax();
            maxStack.addLast(input);
        }
        source.addLast(elt);
    }

    public int getLast() {
        if (source.size() == 0)
            throw new IndexOutOfBoundsException();
        return source.getLast();
    }

    public int removeLast() {
        if (source.size() == 0)
            throw new IndexOutOfBoundsException();
        maxStack.removeLast();
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
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
