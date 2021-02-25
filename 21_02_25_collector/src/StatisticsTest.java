import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    Statistics statistics = new Statistics();
    List<LogEntry> logs = Arrays.asList(new LogEntry(System.currentTimeMillis(), "anton", "deepl.com")
            , new LogEntry(System.currentTimeMillis(), "anton", "deepl.com")
            , new LogEntry(System.currentTimeMillis(), "bob", "facebook.com")
            , new LogEntry(System.currentTimeMillis(), "tom", "deepl.com")
            , new LogEntry(System.currentTimeMillis() + 1, "anton", "google.com")
            , new LogEntry(System.currentTimeMillis() + 1, "tom", "deepl.com")
            , new LogEntry(System.currentTimeMillis() + 4, "anton", "google.com")
            , new LogEntry(System.currentTimeMillis() + 6, "anton", "deepl.com")
            , new LogEntry(System.currentTimeMillis() + 2, "bob", "google.com")
            , new LogEntry(System.currentTimeMillis() + 10, "anton", "deepl.com"));

    @Test
    public void test_empty() {
        assertTrue(statistics.countByEntries(new ArrayList<>()).isEmpty());
        assertTrue(statistics.countByDifferentUsers(new ArrayList<>()).isEmpty());
    }

    @Test
    public void test_countByUrl() {
        Map<String, Long> expected = new HashMap<>();
        expected.put("deepl.com", 6L);
        expected.put("facebook.com", 1L);
        expected.put("google.com", 3L);

        assertEquals(expected, statistics.countByEntries(logs));
    }

    @Test
    public void test_countByUsers() {
        Map<String, Map<String, Long>> expected = new HashMap<>();
        Map<String, Long> deepl = new HashMap<>();
        Map<String, Long> google = new HashMap<>();
        Map<String, Long> facebook = new HashMap<>();

        deepl.put("anton", 4L);
        deepl.put("tom", 2L);

        google.put("anton", 2L);
        google.put("bob", 1L);

        facebook.put("bob", 1L);


        expected.put("deepl.com", deepl);
        expected.put("google.com", google);
        expected.put("facebook.com", facebook);

        assertEquals(expected, statistics.countByDifferentUsers(logs));
    }
}