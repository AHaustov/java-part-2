package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements RandomRule {
    private ArrayList<Integer> values;
    private Random random = new Random();

    public ListRandomRule(List<Integer> values) {
        this.values = new ArrayList<>(values);
    }

    public ListRandomRule(int... values) {
        for (int element : values) {
            this.values.add(element);
        }
    }

    @Override
    public int nextInt() {
        return values.get(random.nextInt(values.size()));
    }
}
