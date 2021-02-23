import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    public Map<Integer, Integer> solve(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int n : numbers) {
            res.put(n,
                    (int) cuts.stream().
                            filter(x -> x.left <= n && x.right >= n)
                            .count());
        }
        return res;
    }


}

class Cut {
    int left;
    int right;

    public Cut(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
