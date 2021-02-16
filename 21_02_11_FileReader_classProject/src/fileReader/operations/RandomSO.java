package fileReader.operations;

import java.util.Random;

public class RandomSO implements IStringOperation {
    Random random = new Random();

    @Override
    public String operate(String line) {
        StringBuilder temp = new StringBuilder(line);
        StringBuilder res = new StringBuilder();
        while (temp.length() != 0) {
            synchronized (res) {
                char input = randomChar(temp);
                res.append(input);
            }
        }
        return new String(res);
    }

    private char randomChar(StringBuilder temp) {
        int n = random.nextInt(temp.length());
        char res=temp.charAt(n);
        temp.deleteCharAt(n);
        return res;
    }

    @Override
    public String getName() {
        return "random";
    }
}
