package task1_chiffre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringExcersiceTest {
    StringExcersice test = new StringExcersice();

    @Test
    void testShortLength_aaaaaabbbbb_a6b5() {
        String str = "aaaaaabbbbb";
        assertEquals("a6b5",test.shortLength(str) );

    }
    @Test
    void testShortLength_aaaaaabbbbb_a6b5c6() {
        String str = "aaaaaabbbbbccccccd";
        assertEquals("a6b5c6d",test.shortLength(str) );

    }
    @Test
    void testShortLength_aabbaabbccc_a2b2a2b2c3() {
        String str = "aabbaabbccc";
        assertEquals("a2b2a2b2c3",test.shortLength(str) );

    }
}