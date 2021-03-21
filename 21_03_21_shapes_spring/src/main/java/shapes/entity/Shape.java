package shapes.entity;

public abstract class Shape {

    protected final char symbol;

    public Shape(char symbol) {
        this.symbol = symbol;
    }

    public abstract void draw();

    public char getSymbol() {
        return symbol;
    }
}
