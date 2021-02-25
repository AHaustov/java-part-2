import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.groupingBy;

public class Transactions {

    public Map<String, Long> sumOfTransactionsPerAccount(List<Transaction> transactions) {

        return transactions.stream()
                .collect(groupingBy(Transaction::getAccount,
                        Collectors.summingLong((Transaction::getSum))));

    }
}

class Transaction {
    final long sum;
    final String account;

    public Transaction(long sum, String account) {
        this.sum = sum;
        this.account = account;
    }

    public long getSum() {
        return sum;
    }

    public String getAccount() {
        return account;
    }
}