package StreamHW;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(primeNumbersTill(5));
    }

    public static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
