import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntCollector {

    public int sumOfSquares(List<Integer> list) {

        return list.stream()
                .collect(Collectors.summingInt(number -> number * number));
    }

    public int multiplicationOfSquares(List<Integer> list) {

        return list.stream()
                .flatMapToInt(number-> IntStream.of(number*number))
                .boxed()
                .collect(Collectors.reducing( (num1, num2) -> num1 * num2 ))
                .orElse(0);

    }

}
