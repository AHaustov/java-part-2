import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurTreeMapTest {
    OurTreeMap<Integer, Integer> test = new OurTreeMap<>();

    @Test
    public void test_empty_size0() {
        assertEquals(0, test.size());
        assertEquals(null, test.get(1));
    }

    @Test
    public void test_get() {
        assertEquals(null, test.put(1, 1));
        assertEquals(null, test.get(2));
    }

    @Test
    public void test_put5x_size_get() {
        for (int i = 0; i < 5; i++) {
            test.put(i, i * 2);

        }
        assertEquals(5, test.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(i * 2, test.get(i));
        }
    }
}