package accService;

import java.util.List;

public class Account {
    String id;
    long balance;
    List<Transaction> transactions;

    public Account(String id, long balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }
}
