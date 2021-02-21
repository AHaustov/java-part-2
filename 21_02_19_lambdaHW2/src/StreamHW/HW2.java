package StreamHW;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HW2 {
    public static void main(String[] args) {
        int end = 100;
        IntStream even = IntStream.rangeClosed(0, end).filter(x -> x % 2 == 0);
        IntStream notEven = IntStream.rangeClosed(0, end).filter(x -> x % 2 != 0);

        IntStream threeAndFive = IntStream.concat(even, notEven).filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted();

        //System.out.println(Arrays.toString(threeAndFive.toArray()));
        System.out.println(Arrays.toString(skip(threeAndFive, 3).toArray()));
    }

    static IntStream skip(IntStream is, long n) {
        return is.skip(n);
    }

}
