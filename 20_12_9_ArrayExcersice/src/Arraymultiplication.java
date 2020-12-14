import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Arraymultiplication {


    boolean isMultiplicationPossible(List<Integer> list, int number) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a = list.get(i);
            for (int j = i + 1; j < size; j++) {
                if (a * list.get(j) == number) return true;
            }
        }
        return false;
    }

    public boolean solve(List<Integer> numbers, int n) {
        Deque<Integer> deque = new ArrayDeque<>(numbers);

        while (deque.size() >= 2) {
            int multiplication = deque.getFirst() * deque.getLast();

            if (multiplication > n) {
                deque.removeLast();
            } else if (multiplication < n) {
                deque.removeFirst();
            } else return true;
        }
        return false;
    }
}



