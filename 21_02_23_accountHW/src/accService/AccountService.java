package accService;

import java.util.List;

import java.util.stream.LongStream;


public class AccountService {

    public long sumOfCanceled(List<Account> acc) {

        return acc.stream().flatMapToLong(x -> x.transactions.stream().
                filter(y -> y.state.equals(State.CANCELED)).
                flatMapToLong(z -> LongStream.of(z.sum))).sum();
    }
}
