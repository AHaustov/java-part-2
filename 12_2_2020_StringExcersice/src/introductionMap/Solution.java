package introductionMap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solve(int... numbers) {
        Map<Integer, Integer> occurrenceByNumber = new HashMap<>();

        for (int number : numbers) {
            occurrenceByNumber.compute(number, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }
        for (int number : occurrenceByNumber.keySet()) {
            if (occurrenceByNumber.get(number) % 2 != 0) return number;
        }

        return Integer.MIN_VALUE;
    }
}
