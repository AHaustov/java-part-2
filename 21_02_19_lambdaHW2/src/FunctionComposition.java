import java.util.function.Function;

public class FunctionComposition {

        Function<Integer, Integer> f = x -> x + 2;
        Function<Integer, Integer> g = x -> x + 3;

        Function<Integer, Integer> h = f.compose(g); //-> f = x -> g(x) + 2 -> (x + 3) + 2

}
