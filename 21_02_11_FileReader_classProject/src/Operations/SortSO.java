package Operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortSO implements IStringOperation {
    @Override
    public String operate(String line) {
        char[] res=line.toCharArray();
        Arrays.sort(res);
        return new String(res);
    }

    @Override
    public String getName() {
        return "sort";
    }
}
