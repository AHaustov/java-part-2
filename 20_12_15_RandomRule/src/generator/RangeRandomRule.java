package generator;

import generator.RandomRule;

import java.util.Random;

public class RangeRandomRule implements RandomRule {

    private int max;
    private Random random = new Random();

    public RangeRandomRule(int n) {
        this.max = n;
    }

    @Override
    public int nextInt() {
        return random.nextInt(max);
    }
}
