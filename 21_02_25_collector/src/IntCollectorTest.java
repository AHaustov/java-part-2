import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class IntCollectorTest {

    IntCollector collector = new IntCollector();
    List<Integer> toTest1 = IntStream.rangeClosed(1, 13)
            .boxed()
            .collect(Collectors.toList());
    List<Integer> toTest2 = IntStream.rangeClosed(1, 3)
            .boxed()
            .collect(Collectors.toList());

    @Test
    public void test_emptyList() {
        assertEquals(0, collector.sumOfSquares(Collections.emptyList()));
        assertEquals(0, collector.multiplicationOfSquares(Collections.emptyList()));
    }

    @Test
    public void test_sumOfSquares() {
        assertEquals(819, collector.sumOfSquares(toTest1));
    }

    @Test
    public void test_multiplicationOfSquares() {
        assertEquals(36, collector.multiplicationOfSquares(toTest2));
    }
}