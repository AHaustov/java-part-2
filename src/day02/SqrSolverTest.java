package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrSolverTest {

    SqrSolver sqrSolver = new SqrSolver();

    @Test
    public void testSqr_nEquals1_1() {//prefix test, than name of method, argument of test, result of test
        assertEquals(1, sqrSolver.sqr((1)));
    }

    @Test
    public void testSqr_nEquals10_100() {//prefix test, than name of method, argument of test, result of test
        assertEquals(100, sqrSolver.sqr((10)));
    }

    @Test
    public void testSqr_nEquals15_225() {//prefix test, than name of method, argument of test, result of test
        assertEquals(225, sqrSolver.sqr((15)));
    }

    @Test
    public void testSqr_nEquals13_169() {//prefix test, than name of method, argument of test, result of test
        assertEquals(169, sqrSolver.sqr((13)));
    }
}