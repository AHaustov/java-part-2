import java.util.ArrayDeque;
import java.util.ArrayList;

public class StackMax {
    private ArrayDeque<Integer> source;
    private ArrayList<Integer> maxStack;

    public StackMax() {
        source = new ArrayDeque<>();
        maxStack = new ArrayList<>();
    }

    public int findIndex(int elt) {
        int index = maxStack.size() - 1;
        while (elt < maxStack.get(index) && index != 0)
            index--;
        return index;
    }

    public void addLast(int elt) {
        if (maxStack.size() == 0)
            maxStack.add(elt);
        else if (getMax() < elt)
            maxStack.add(elt);
        else {
            maxStack.add(findIndex(elt), elt);
        }
        source.addLast(elt);
    }

    public int getLast() {
        return source.getLast();
    }

    public int removeLast() {
        maxStack.remove(maxStack.size() - 1);
        return source.removeLast();
    }

    public int size() {
        return source.size();
    }

    public int getMax() {
        return maxStack.get(maxStack.size() - 1);
    }

   /* public int getMax() {
        int max = source.getFirst();
        for (Integer number : source) {
            max = max < number ? number : max;
        }
        return max;
    }*/
}
