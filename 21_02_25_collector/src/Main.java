import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TransferQueue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-234, 5, 567);

        double average = numbers.stream()
                .collect(Collectors.averagingInt((num) -> num));

        List<Transaction> list=Arrays.asList(new Transaction(123,"a"),new Transaction(123,"a")
        ,new Transaction(123,"b"),new Transaction(123,"c"));

        Transactions test=new Transactions();
        System.out.println(test.sumOfTransactionsPerAccount(list).get("a"));
        System.out.println(test.sumOfTransactionsPerAccount(list).get("b"));
        System.out.println(test.sumOfTransactionsPerAccount(list).get("c"));
    }
}

class Account {
    String uuid;
    long balance;
    AccountState state;

    public Account(String uuid, long balance, AccountState state) {
        this.uuid = uuid;
        this.balance = balance;
        this.state = state;
    }
}

enum AccountState {
    REMOVED, ACTIVE, BLOCKED
}