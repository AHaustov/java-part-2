import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    public Map<Integer, Integer> solve(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int number : numbers) {
            res.put(number,
                    (int) cuts.stream()
                            .filter(cut -> cut.left <= number && cut.right >= number)
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
