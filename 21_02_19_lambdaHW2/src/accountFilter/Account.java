package accountFilter;

public class Account {
    String number;
    long balance;
    boolean isLocked;

    public Account(String number, long balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    //true if balance > 0
    //true if balance is > 100000 and not locked
}
