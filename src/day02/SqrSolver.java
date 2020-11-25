package day02;

public class SqrSolver {

    int sqr(int n) {
        if (n == 1) return 1;
        return sqr(n - 1) + n + n - 1;
    }
}
