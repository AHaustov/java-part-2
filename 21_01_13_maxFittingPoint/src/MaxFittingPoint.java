import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MaxFittingPoint {

    public int maxFittingPoints(List<Integer> numbers, int interval) {
        if (numbers.isEmpty() || interval == 0)
            return 0;
        Deque<Integer> intervalQueue = new ArrayDeque<>();
        int res = 0;
        for (int number : numbers) {
            intervalQueue.addLast(number);

            while (number - intervalQueue.getFirst() > interval) {
                intervalQueue.removeFirst();
            }
            if (res < intervalQueue.size())
                res = intervalQueue.size();
        }
        return res;
    }
}
