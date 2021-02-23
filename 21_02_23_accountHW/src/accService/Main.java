package accService;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Transaction one = new Transaction("1", State.CANCELED, 14, new Date(1223));
        Transaction two = new Transaction("1", State.CANCELED, 16, new Date(1223));
        Transaction three = new Transaction("1", State.FINISHED, 17, new Date(1223));
        Account acc = new Account("1", 34, List.of(one, two,three));
        AccountService as = new AccountService();
        System.out.println(as.sumOfCanceled(List.of(acc)));



    }
}
