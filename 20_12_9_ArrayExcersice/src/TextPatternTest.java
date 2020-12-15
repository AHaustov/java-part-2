import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextPatternTest {
    TextPattern test = new TextPattern();

    @Test
    public void testIsPatternInText_emptyPattern_true() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        assertTrue(test.isPatternInText(text, pattern));
        text.append("hello");
        assertTrue(test.isPatternInText(text, pattern));
    }

    @Test
    public void testIsPatternInText_pattern1_isInText() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        text.append("hello");
        pattern.append("hlo");
        assertTrue(test.isPatternInText(text, pattern));

    }

    public void testIsPatternInText_pattern1_isNotInText() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        text.append("hello");
        pattern.append("lol");
        assertFalse(test.isPatternInText(text, pattern));
    }
}