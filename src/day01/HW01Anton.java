package day01;

public class HW01Anton {
    public static void main(String[] args) {
        int a = 30;
        int b = 25;
        int c = 110;
        System.out.println(nod(a, b));
        System.out.println(nod2(b, c));
    }

    private static int nod(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        else if (a > b) {
            return nod(a - b, b);
        } else {
            return nod(a, b - a);
        }
    }

    private static int nod2(int a, int b) {
        if (b == 0) return a;
        else return nod2(b, a % b);
    }

}
