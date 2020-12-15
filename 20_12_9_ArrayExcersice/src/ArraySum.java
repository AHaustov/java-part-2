import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ArraySum {

    boolean isSumPossible(List<Integer> list, int number) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a = list.get(i);
            for (int j = i + 1; j < size; j++) {
                if (a + list.get(j) == number) return true;
            }
        }
        return false;
    }

    boolean isSumPossibleSorted(List<Integer> list, int number) {
        Deque<Integer> deque = new ArrayDeque<>(list);

        while (deque.size() >= 2) {
            int sum = deque.getFirst() * deque.getLast();

            if (sum > number) {
                deque.removeLast();
            } else if (sum < number) {
                deque.removeFirst();
            } else return true;
        }
        return false;
    }

}
