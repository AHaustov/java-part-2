package accService;

import java.util.Date;

public class Transaction {
    String unID;
    State state;
    long sum;
    Date date;

    public Transaction(String unID, State state, long sum, Date date) {
        this.unID = unID;
        this.state = state;
        this.sum = sum;
        this.date = date;
    }
}
