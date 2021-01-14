import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {


    OurHashMap<Integer, Integer> map = new OurHashMap<>();

    @Test
    public void test_emptyMap() {
        assertEquals(0, map.size());
    }

    @Test
    public void test_put_get() {
        map.put(1, 2);
        assertEquals(1, map.size());
        assertEquals(2, map.get(1));
        map.put(1, 4);
        assertEquals(4, map.get(1));
        assertEquals(1, map.size());
        map.put(2, 3);
        assertEquals(3, map.get(2));
        assertEquals(2, map.size());
    }

    @Test
    public void test_remove() {
        map.put(1, 2);
        map.put(17, 3);
        map.put(33, 4);

        assertEquals(3, map.size());
        assertEquals(3, map.remove(17));
        assertEquals(2, map.size());
    }

    @Test
    public void test_several_remove() {
        for (int i = 0; i < 20; i++) {
            map.put(i * 2, i * 3);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i * 3, map.remove(i * 2));
        }
    }

    @Test
    public void test_iterator() {
        for (int i = 0; i < 11; i++) {
            map.put(i, i * 11);
        }
        Iterator<Integer> it = map.keyIterator();
        int i = 0;
        while (it.hasNext())
            assertEquals(i++, it.next());
    }
}