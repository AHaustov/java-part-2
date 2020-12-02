package day07.excercise2;

public abstract class Shape {
    /**
     * Char which is used for drawing
     */
    char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    /**
     * method used for drawing
     */
   abstract void draw();
}
