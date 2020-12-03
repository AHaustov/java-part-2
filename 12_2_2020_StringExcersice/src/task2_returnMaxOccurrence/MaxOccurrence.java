package task2_returnMaxOccurrence;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurrence {


    int maxOccurrence(int... numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        Map<Integer, Integer> occurrenceByNumber = new HashMap<>();
        for (int number : numbers) {
            occurrenceByNumber.compute(number, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }
        int maxOccu = occurrenceByNumber.get(numbers[0]);
        int max = numbers[0];
        for (int number : occurrenceByNumber.keySet()) {
            if (maxOccu < occurrenceByNumber.get(number)) {
                maxOccu = occurrenceByNumber.get(number);
                max = number;
            }
        }
        return max;
    }
}
