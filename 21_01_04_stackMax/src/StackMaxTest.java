import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMaxTest {
    StackMax test = new StackMax();

    @Test
    public void test_addLast_1_1() {
        test.addLast(1);
        assertEquals(1, test.getLast());
    }

    @Test
    public void test_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> test.getMax());
        assertThrows(IndexOutOfBoundsException.class, () -> test.getLast());
        assertEquals(0, test.size());
    }

    @Test
    public void test_getMax_5int_5() {
        for (int i = 5; i > 0; i--) {
            test.addLast(i);
            assertEquals(5, test.getMax());
        }
    }

    @Test
    public void test_removeLast_5xadd_4xremove() {
        for (int i = 0; i < 6; i++) {
            test.addLast(5 - i);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(5, test.getMax());
            assertEquals(i, test.removeLast());
        }
    }

    @Test
    public void test_addLast_x50_max100() {
        test.addLast(100);
        assertEquals(100, test.getMax());
        for (int i = 0; i < 50; i++) {
            test.addLast((int) Math.random() * 100);
            assertEquals(100, test.getMax());
        }
    }
    @Test
    public void test_addLast5xremoveLast5x_IndexOOB(){
        for (int i = 0; i < 5; i++) {
            test.addLast(i);
        }
        for (int i = 0; i < 5; i++) {
            test.removeLast();
        }
        assertThrows(IndexOutOfBoundsException.class,()->test.getMax());
        assertThrows(IndexOutOfBoundsException.class,()->test.getLast());
    }
}