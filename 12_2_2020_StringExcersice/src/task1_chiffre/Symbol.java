package task1_chiffre;

public class Symbol {
    int number;
    char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
        number = 1;
    }

    public int getNumber() {
        return number;
    }

    public char getSymbol() {
        return symbol;
    }

    public void plus() {
        number++;
    }
}
