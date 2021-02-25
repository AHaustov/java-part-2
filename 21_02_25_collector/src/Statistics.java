
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {

    public Map<String, Long> countByEntries(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    }

    public Map<String, Map<String, Long>> countByDifferentUsers(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.
                        groupingBy(LogEntry::getUrl,
                                Collectors.groupingBy(LogEntry::getLogin,
                                        Collectors.counting())));
    }
}

class LogEntry {

    long timestamp;
    String login;
    String url;

    public LogEntry(long timestamp, String login, String url) {
        this.timestamp = timestamp;
        this.login = login;
        this.url = url;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }
}
