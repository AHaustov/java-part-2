package introductionMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution test = new Solution();


    @Test
    void testSolve_13131_1() {
        assertEquals(1, test.solve(1, 3, 1, 3, 1));
    }

    @Test
    void testSolve_131315757_1() {
        assertEquals(1, test.solve(1, 3, 1, 3, 1, 5, 7, 5, 7));
    }

    @Test
    void testSolve_13131973971_3() {
        assertEquals(3, test.solve(1, 3, 1, 3, 1, 9, 7, 3, 9, 7, 1));
    }

}