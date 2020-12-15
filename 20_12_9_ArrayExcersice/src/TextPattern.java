// text, pattern filled with small latin letters
// is pattern fitting in given text? Letters same order, doesn't matter, if some are missing
public class TextPattern {


    public boolean isPatternInText(StringBuilder text, StringBuilder pattern) {
        if (pattern.length() == 0) return true;
        if (text.length() < pattern.length()) return false;
        if (text.charAt(text.length() - 1) == pattern.charAt(pattern.length() - 1))
            return isPatternInText(text.deleteCharAt(text.length() - 1), pattern.deleteCharAt(pattern.length() - 1));
        else return isPatternInText(text.deleteCharAt(text.length() - 1), pattern);
    }


    /**
     *
     * @param text
     * @param pattern
     * @param start count for pattern position of char to compare
     * @param zero count for text position of char to compare
     * @return boolean , if String Pattern is somehow included in text in right order -> "Hl" return true for "Hello"
     */
    public boolean isPatternInText(String text, String pattern, int start, int zero) {
        if (pattern.length() == start) return true;
        if (text.length() - zero < pattern.length() - start) return false;
        if (text.charAt(zero) == pattern.charAt(start))
            return isPatternInText(text, pattern, ++start, ++zero);
        else return isPatternInText(text, pattern, start, ++zero);
    }
}
