package StreamHW;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    Factorial fac = new Factorial();


    @Test
    public void test_0() {
        assertThrows(NoSuchElementException.class, () -> fac.factorial(0));
    }

    @Test
    public void test_4_24() {
        assertEquals(24, fac.factorial(4));
    }

    @Test
    public void test_6_720() {
        assertEquals(720, fac.factorial(6));
    }
}