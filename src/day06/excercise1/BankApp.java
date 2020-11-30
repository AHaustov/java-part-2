package day06.excercise1;

// Bank employee name issues a loan to name
public class BankApp {
    public static void main(String[] args) {
        LoanIssuer tom = new LoanIssuer("Thomas", true, true);
        LoanIssuer bob = new LoanIssuer("Robert", false, true);
        LoanIssuer luc = new LoanIssuer("Lucas", true, false);
        LoanIssuer carl = new LoanIssuer("Carl", false, false);
        LoanIssuer[] employees = new LoanIssuer[]{tom, bob, luc, carl};

        LoanConsumer maria = new LoanConsumer("Maria", 17, 5000);
        LoanConsumer ted = new LoanConsumer("Theodor", 31, 25000);
        LoanConsumer agatha = new LoanConsumer("Agatha", 55, 25000);
        LoanConsumer arthur = new LoanConsumer("Arthur", 71, 50000);
        LoanConsumer kevin = new LoanConsumer("Kevin", 21, 15000);
        LoanConsumer chantale = new LoanConsumer("Chantale", 29, 31000);
        LoanConsumer brat = new LoanConsumer("Brat", 31, 31000);

        LoanConsumer[] consumer = new LoanConsumer[]{maria, ted, agatha, arthur, kevin, chantale, brat};

        printIssueEmployee(employees, consumer);
        printIssueConsumer(employees, kevin, agatha, arthur);
    }

    private static void printIssueConsumer(LoanIssuer[] employees, LoanConsumer... consumer) {
        for (LoanConsumer consume : consumer) {
            for (LoanIssuer issuer : employees) {
                if (issuer.toIssue(consume)) {
                    System.out.println(consume.getName() + " is getting a loan from Bank employee " + issuer.getName());
                } else
                    System.out.println(consume.getName() + " is not getting a loan from Bank employee " + issuer.getName());
            }
            System.out.println();
        }
    }

    private static void printIssueEmployee(LoanIssuer[] employees, LoanConsumer[] consumer) {
        for (LoanIssuer issuer : employees) {
            for (LoanConsumer consume : consumer) {
                if (issuer.toIssue(consume)) {
                    System.out.println("Bank employee " + issuer.getName() + " issues a loan to " + consume.getName());
                } else
                    System.out.println("Bank employee " + issuer.getName() + " doesn't issues a loan to " + consume.getName());
            }
            System.out.println();
        }
    }
}
