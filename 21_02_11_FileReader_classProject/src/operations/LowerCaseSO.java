package operations;

public class LowerCaseSO implements IStringOperation{
    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
