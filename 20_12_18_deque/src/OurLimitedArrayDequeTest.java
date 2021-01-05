import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurLimitedArrayDequeTest {

    OurLimitedArrayDeque<Integer> deque = new OurLimitedArrayDeque<Integer>(4);
    OurLimitedArrayDeque<String> stringDeque = new OurLimitedArrayDeque<String>(4);

    @org.junit.jupiter.api.Test
    void testSize_emptyList_zero() {
        assertEquals(0, deque.size());
    }

    @org.junit.jupiter.api.Test
    void testGetFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.getFirst();
        });
    }

    @org.junit.jupiter.api.Test
    void testGetLast_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.getLast();
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveFirst_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.removeFirst();
        });
    }

    @org.junit.jupiter.api.Test
    void testRemoveLast_emptyList_throwsEmptyDequeException() {
        assertThrows(EmptyDequeException.class, () -> {
            deque.removeLast();
        });
    }

    @org.junit.jupiter.api.Test
    void testSizeAndAddLast_addSeveralElements_correctSize() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
    }

    @org.junit.jupiter.api.Test
    void testSizeAndAddFirst_addSeveralElements_correctSize() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
    }

    @org.junit.jupiter.api.Test
    void testGetLastAndAddLast_addSeveralElements_correctOrderOfElements() {
        int[] numbers = new int[]{0, 1, 2};
        for (int i = 0; i < 3; i++) {
            deque.addLast(i);
            assertEquals(numbers[i], deque.getLast());
        }
    }

    @org.junit.jupiter.api.Test
    void testGetFirstAndAddFirst_addSeveralElements_correctOrderOfElements() {
        int[] numbers = new int[]{0, 1, 2};
        for (int i = 0; i < 3; i++) {
            deque.addFirst(i);
            assertEquals(numbers[i], deque.getFirst());
        }
    }

    @org.junit.jupiter.api.Test
    void testGetFirstAndAddFirst_GetLastAndAddLast_correctOrderOfElements() {
        //int[] numbers = new int[]{10, 100,  0};
        deque.addFirst(10);
        deque.addLast(100);
        deque.addLast(0);
        assertEquals(10, deque.getFirst());
        assertEquals(0, deque.getLast());
    }

    @org.junit.jupiter.api.Test
    void testAddFirst_throwsDequeOverflowException() {
        deque.addFirst(12);
        deque.addFirst(12);
        deque.addFirst(12);
        deque.addFirst(12);
        assertThrows(DequeOverflowException.class, () -> deque.addFirst(33));
    }

    @org.junit.jupiter.api.Test
    void testAddLast_throwsDequeOverflowException() {
        deque.addLast(10);
        deque.addLast(-55);
        deque.addLast(3);
        deque.addLast(1);
        assertEquals(4, deque.size());
        assertThrows(DequeOverflowException.class, () -> deque.addLast(33));
    }

    @org.junit.jupiter.api.Test
    public void testRemoveLastSeveralTimes_throwsEmptyDequeException() {
        deque.addLast(10);
        deque.removeLast();
        assertThrows(EmptyDequeException.class, () -> deque.removeLast());
    }

    @org.junit.jupiter.api.Test
    public void testRemoveFirstSeveralTimes_throwsEmptyDequeException() {
        deque.addFirst(101);
        deque.removeFirst();
        assertThrows(EmptyDequeException.class, () -> deque.removeFirst());
    }

    @Test
    public void test_iterator() {
        String[] test = {"Brian", "Tom", "Georg"};
        for (String str : test) {
            stringDeque.addLast(str);
        }
        Iterator<String> it = stringDeque.iterator();
        for (int i = 0; i < 3; i++) {
            assertEquals(stringDeque.removeFirst(),it.next());
        }
    }
}