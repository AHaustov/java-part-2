package task2_returnMaxOccurrence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxOccurrenceTest {

    MaxOccurrence test = new MaxOccurrence();


    @Test
    void test_1333333567_3(){
        assertEquals(3,test.maxOccurrence(1,3,3,3,3,3,3,5,6,7));
    }

    @Test
    void test_13333335671011_3(){
        assertEquals(3,test.maxOccurrence(1,3,3,3,3,3,3,5,6,7,10,1,1));
    }

    @Test
    void test_13333335678888888889_8(){
        assertEquals(8,test.maxOccurrence(1,3,3,3,3,3,3,5,6,7,8,8,8,8,8,8,8,8,9));
    }
}