package Operations;

import java.util.Random;

public class RandomSO implements IStringOperation {
    Random random = new Random();

    @Override
    public String operate(String line) {
        StringBuilder temp = new StringBuilder(line);
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            res.append(randomChar(temp));
        }

        return new String(res);
    }

    private StringBuilder randomChar(StringBuilder temp) {
        int n = random.nextInt(temp.length());
        return temp.deleteCharAt(n);
    }

    @Override
    public String getName() {
        return "random";
    }
}
