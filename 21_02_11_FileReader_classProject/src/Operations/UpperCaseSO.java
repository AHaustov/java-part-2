package Operations;

public class UpperCaseSO implements IStringOperation{
    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return "upper_case";
    }
}
