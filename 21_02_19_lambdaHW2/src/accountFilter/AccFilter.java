package accountFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccFilter {


    List<Account> filter(List<Account> list, Predicate<Account> pred) {
        List<Account> res = new ArrayList<>();
        for (Account acc : list) {
            if (pred.test(acc))
                res.add(acc);
        }
        return res;
    }
}
