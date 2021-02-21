package StreamHW;

import java.util.stream.IntStream;

public class Factorial {

    public int factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce((oldValue, currentValue) -> oldValue * currentValue)
                .getAsInt();
    }

}
