package generator;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }


    public List<Integer> nextInts(int n) {
       List<Integer> list= new ArrayList<>(); {
            for (int i = 0; i < n; i++) {
                list.add(rule.nextInt());
            }
       }
        return list;
    }
}
