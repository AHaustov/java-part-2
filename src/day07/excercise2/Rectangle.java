package day07.excercise2;

public class Rectangle extends Shape {
    int height;
    int width;

    public Rectangle(char symbol,int height, int width) {
        super(symbol);
        this.height = height;
        this.width = width;
    }

    @Override
    void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
