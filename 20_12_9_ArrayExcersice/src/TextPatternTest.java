import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextPatternTest {
    TextPattern test = new TextPattern();

    @Test
    public void testIsPatternInTextStringBuilder_emptyPattern_true() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        assertTrue(test.isPatternInText(text, pattern));
        text.append("hello");
        assertTrue(test.isPatternInText(text, pattern));
    }

    @Test
    public void testIsPatternInTextStringBuilder_pattern1_isInText() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        text.append("hello");
        pattern.append("hlo");
        assertTrue(test.isPatternInText(text, pattern));

    }

    @Test
    public void testIsPatternInTextStringBuilder_pattern1_isNotInText() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        text.append("hello");
        pattern.append("lol");
        assertFalse(test.isPatternInText(text, pattern));
    }

    @Test
    public void testIsPatternInTextStringBuilder_patternLongerThanText_false() {
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        text.append("hello");
        pattern.append("helloWorld");
        assertFalse(test.isPatternInText(text, pattern));
    }

    @Test
    public void testIsPatternInTextString_emptyPattern_true() {
        String text = "";
        String pattern = "";
        assertTrue(test.isPatternInText(text, pattern, 0, 0));
        text = "hello";
        assertTrue(test.isPatternInText(text, pattern, 0, 0));
    }

    @Test
    public void testIsPatternInTextString_pattern1_isInText() {
        String text = "hello";
        String pattern = "hlo";

        assertTrue(test.isPatternInText(text, pattern, 0, 0));

    }

    @Test
    public void testIsPatternInTextString_pattern1_isNotInText() {
        String text = "hello";
        String pattern = "lol";

        assertFalse(test.isPatternInText(text, pattern, 0, 0));
    }

    @Test
    public void testIsPatternInTextString_patternLongerThanText_false() {
        String text = "hello";
        String pattern = "helloWorld";

        assertFalse(test.isPatternInText(text, pattern, 0, 0));
    }
}