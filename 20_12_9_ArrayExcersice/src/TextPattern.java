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


}
