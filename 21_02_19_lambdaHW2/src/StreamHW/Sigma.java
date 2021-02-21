package StreamHW;


import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Sigma {

    public int sum(int a, int b, IntFunction<IntStream> f) {
        return IntStream.rangeClosed(a, b).flatMap(f).distinct().sum();
    }
}
