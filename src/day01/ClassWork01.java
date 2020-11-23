package day01;

public class ClassWork01 {

    public ClassWork01() {
    }

    public String reverse(String str) {
        String output = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            output += str.charAt(i);
        }
        return output;
    }

    public int recursionSquareOfN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return recursionSquareOfN(n - 1) + n + n - 1;
        }
    }
}
