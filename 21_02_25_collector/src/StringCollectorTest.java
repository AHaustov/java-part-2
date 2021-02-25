import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringCollectorTest {

    StringCollector test = new StringCollector();
    List<String> toTest = Arrays.asList("bob", "hello", "hellolleh", "lagerregal", "Lagerregal", "blobblob");
    List<String> palindrome = Arrays.asList("bob", "hellolleh", "lagerregal", "Lagerregal");
    List<String> notPalindrome = Arrays.asList("hello", "blobblob");

    @Test
    public void test_empty() {
        Map<Boolean, List<String>> expected = new HashMap<>();
        expected.put(true, Collections.emptyList());
        expected.put(false, Collections.emptyList());
        assertEquals(expected, test.findPalindrome(Collections.emptyList()));
    }

    @Test
    public void test_palindromes() {
        Map<Boolean, List<String>> expected = new HashMap<>();
        expected.put(true, palindrome);
        expected.put(false, notPalindrome);
        assertEquals(expected, test.findPalindrome(toTest));
    }
}