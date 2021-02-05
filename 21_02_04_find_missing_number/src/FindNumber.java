import java.util.ArrayList;

import java.util.List;

public class FindNumber {

    List<Integer> lib;

    public FindNumber(int size) {
        lib = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            lib.add(i);
        }
    }

    public int findMissingNumber(List<Integer> target) {
        lib.removeAll(target);
        return lib.get(0) ;
    }

}
