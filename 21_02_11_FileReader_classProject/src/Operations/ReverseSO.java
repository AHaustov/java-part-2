package Operations;

public class ReverseSO implements IStringOperation {
    @Override
    public String operate(String line) {
        char[] res = line.toCharArray();
        int n = res.length / 2;
        for (int i = 0; i < n; i++) {
            res[i] = res[res.length - 1 - i];
        }
        return new String(res);
    }

    @Override
    public String getName() {
        return "reverse";
    }
}
