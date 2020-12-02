package day07.excercise2;

public class Line extends Shape {
    int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
