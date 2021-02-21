package ternaryIntPredicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TernaryIntPredicateTest {

    TernaryInts one = new TernaryInts(1, 2, 3);
    TernaryInts two = new TernaryInts(1, 2, 1);
    TernaryInts three = new TernaryInts(-1, 2, 1);
    TernaryInts four = new TernaryInts(1, 1, 1);
    TernaryInts five = new TernaryInts(6, 2, 2);
    List<TernaryInts> test = Arrays.asList(one, two, three, four, five);

    @Test
    public void test() {
        List<TernaryInts> expected = Arrays.asList(one, three);
        TernaryIntPredicate pred = (a, b, c) -> a != b && a != c && b != c;
        List<TernaryInts> res = TernaryInts.notEquals(test, pred);
        assertEquals(expected, res);
    }
}