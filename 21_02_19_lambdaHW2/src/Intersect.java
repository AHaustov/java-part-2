import java.util.List;
import java.util.function.IntPredicate;

public class Intersect {

    IntPredicate intersect(List<IntPredicate> predicates) {
        IntPredicate res = null;
        for (int i = 0; i < predicates.size(); i++) {
            res = predicates.get(i).and(res);
        }
        return res;
    }
}