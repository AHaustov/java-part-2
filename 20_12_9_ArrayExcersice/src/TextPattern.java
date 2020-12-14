// text, pattern filled with small latin letters
// is pattern fitting in given text? Letters same order, doesn't matter, if some are missing
public class TextPattern {


    public boolean isPatternInText(String text, String pattern) {
        if (pattern.length() == 0) return true;
        if (text.length() < pattern.length()) return false;
        return false;

    }
}
