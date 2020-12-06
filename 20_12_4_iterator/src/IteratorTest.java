import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    void testReverseIterator_1234_4321() {
        int[] arr = {1, 2, 3, 4};
        Iterator<Integer> reverseIterator = new ReverseArrayIterator(arr);
        int count = 0;
        while (reverseIterator.hasNext()) {
            assertEquals(arr[count++], reverseIterator.next());
        }
    }

    @Test
    void testSortIntIterator_356421_123456() {
        int[] arr = {3, 5, 6, 4, 2, 1};
        Iterator<Integer> sortIntIterator = new SortIntIterator(arr);
        int count = 1;
        while (sortIntIterator.hasNext()) {
            assertEquals(count++, sortIntIterator.next());
        }
    }
}