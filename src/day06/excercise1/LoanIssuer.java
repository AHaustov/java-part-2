package day06.excercise1;

public class LoanIssuer {
    private String name;
    private boolean isLazy;
    private boolean isKind;

    public LoanIssuer() {
    }

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public String getName() {
        return name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public boolean isKind() {
        return isKind;
    }

    public boolean toIssue(LoanConsumer consumer) {
        if (consumer.getAge() < 18 || consumer.getAnnualIncome() < 20000)
            return false;
        else if (isLazy)
            return true;
        else if (isKind && consumer.getAge() < 70)
            return true;
        else return consumer.getAge() < 50;
    }
}
