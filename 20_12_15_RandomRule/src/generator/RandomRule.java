package generator;
// first implementation Range Random Rule n:int -> 0 < n
// second implementation List Random Rule values:List<Integer>
// ListRR(List<Integer> list)  ListRR(int[] numbers)
// third: class Random Generator uses a RandomRule to generate List<Integer> with size=n

public interface RandomRule {

    int nextInt();

}
