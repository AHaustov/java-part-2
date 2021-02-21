package accountFilter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Predicate<Account> pred1 = x -> x.balance > 0;
    Predicate<Account> pred2 = x -> x.balance > 100000 && !x.isLocked;
    AccFilter filter = new AccFilter();

    Account one = new Account("1", 0, false);
    Account two = new Account("2", 0, true);
    Account three = new Account("3", 1, false);
    Account four = new Account("4", 1, true);
    Account five = new Account("5", 100000, false);
    Account six = new Account("6", 100000, true);
    Account seven = new Account("7", 99999, false);
    Account eight = new Account("8", 99999, true);
    Account nine = new Account("9", 100001, false);
    Account ten = new Account("10", 100001, true);
    List<Account> test = Arrays.asList(one, two, three, four, five, six, seven, eight, nine, ten);

    @Test
    public void test_emptyList() {
        List<Account> list = new ArrayList<>();
        assertTrue(filter.filter(list, pred1).isEmpty());
        assertTrue(filter.filter(list, pred2).isEmpty());
    }

    @Test
    public void test_pred1() {
        List<Account> expected = Arrays.asList(three, four, five, six, seven, eight, nine, ten);
        assertEquals(expected, filter.filter(test, pred1));
    }

    @Test
    public void test_pred2() {
        List<Account> expected = Arrays.asList(nine);
        assertEquals(expected, filter.filter(test, pred2));
    }
}