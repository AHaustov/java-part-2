import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StringCollector {

    public Map<Boolean, List<String>> findPalindrome(List<String> words) {

        return words.stream().collect(Collectors
                .partitioningBy(word -> word.equalsIgnoreCase(reverseOf(word))));
    }

    private String reverseOf(String word) {
        char[] res = word.toCharArray();
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            res[i] = res[length - i - 1];
        }
        return String.valueOf(res);
    }
}
