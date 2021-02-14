package operations;

import java.util.Arrays;

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
