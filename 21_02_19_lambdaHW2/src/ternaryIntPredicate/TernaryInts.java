package ternaryIntPredicate;

import java.util.ArrayList;
import java.util.List;

public class TernaryInts {
    int a;
    int b;
    int c;

    public TernaryInts(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static List<TernaryInts> notEquals(List<TernaryInts> list, TernaryIntPredicate pred) {
        List<TernaryInts> res = new ArrayList<>();
        for (TernaryInts ti : list) {
            if (pred.test(ti.a, ti.b, ti.c))
                res.add(ti);
        }
        return res;
    }
}
