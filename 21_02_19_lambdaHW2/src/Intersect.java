import java.util.List;
import java.util.function.IntPredicate;

public class Intersect {

    IntPredicate intersect(List<IntPredicate> predicates) {
        IntPredicate res = x -> true;
        for (IntPredicate predicate : predicates) {
            res = predicate.and(res);
        }
        return res;
    }
}