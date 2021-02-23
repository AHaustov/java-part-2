import java.util.Arrays;
import java.util.Set;

public class Censor {
    private Set<String> dictionary;

    public Censor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean verify(String text) {
        return Arrays.stream(text.split(" "))
                .noneMatch(x -> dictionary.contains(x.toLowerCase()));
            }
}
