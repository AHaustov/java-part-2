package day07.excercise2;

public class Picture extends Shape {
    Shape[] shapes;

    public Picture(char symbol, Shape... shapes) {
        super(symbol);
        this.shapes = shapes;
    }

    @Override
    void draw() {
        for (int i = 0; i < 20; i++) {
            System.out.print(symbol);
        }
        System.out.println();
        for (Shape shape : this.shapes) {
            shape.draw();
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
