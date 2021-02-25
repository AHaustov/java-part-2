import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {
    Transactions test = new Transactions();
    List<Transaction> transactions = Arrays.asList(
            new Transaction(12, "my"),
            new Transaction(-12, "my"),
            new Transaction(12, "your"),
            new Transaction(1234, "my"),
            new Transaction(-13, "your"),
            new Transaction(1, "my"),
            new Transaction(1, "my"));

    @Test
    public void test_emptyList() {
        assertTrue(test.sumOfTransactionsPerAccount(Collections.emptyList()).isEmpty());
    }

    @Test
    public void test_sumOfTransactions() {
        Map<String, Long> expected = new HashMap<>();
        expected.put("my", 1236L);
        expected.put("your", -1L);
        assertEquals(expected, test.sumOfTransactionsPerAccount(transactions));
    }
}