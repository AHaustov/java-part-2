import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindNumberTest {

    FindNumber test = new FindNumber(100);


    @Test
    public void test_findNUmber() {
        List<Integer> notFinalList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            notFinalList.add(i);
        }
        notFinalList.remove(1);

        assertEquals(1,test.findMissingNumber(notFinalList));

    }
}