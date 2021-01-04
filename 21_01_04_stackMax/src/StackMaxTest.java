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
    public void test_getMax_5int_4() {
        for (int i = 5; i > 0; i--) {
            test.addLast(i);
            assertEquals(5, test.getMax());
        }
    }
}