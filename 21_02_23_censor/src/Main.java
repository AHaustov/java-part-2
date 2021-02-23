import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String text = "bad bad boy";
        String text2 = "all good good";
        String text3 = "all good good bad";
        Censor censor = new Censor(new HashSet<String>(Arrays.asList("bad")));

        System.out.println(censor.verify(text));
        System.out.println(censor.verify(text2));
        System.out.println(censor.verify(text3));
    }
}
