package day06.excercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAppTest {
    LoanIssuer tom = new LoanIssuer("Thomas", true, true);
    LoanIssuer bob = new LoanIssuer("Robert", false, true);
    LoanIssuer luc = new LoanIssuer("Lucas", true, false);
    LoanIssuer carl = new LoanIssuer("Carl", false, false);
    LoanIssuer[] employee = new LoanIssuer[]{tom, bob, luc, carl};

    LoanConsumer maria = new LoanConsumer("Maria", 17, 5000);
    LoanConsumer ted = new LoanConsumer("Theodor", 31, 25000);
    LoanConsumer agatha = new LoanConsumer("Agatha", 55, 35000);
    LoanConsumer arthur = new LoanConsumer("Arthur", 71, 50000);
    LoanConsumer kevin = new LoanConsumer("Kevin", 21, 15000);
    LoanConsumer chantale = new LoanConsumer("Chantale", 29, 31000);
    LoanConsumer[] consumer = new LoanConsumer[]{maria, ted, agatha, arthur, kevin, chantale};

    @Test
    void testAge_under18_false() {
        assertFalse(tom.toIssue(maria));
        assertFalse(bob.toIssue(maria));
        assertFalse(luc.toIssue(maria));
        assertFalse(carl.toIssue(maria));
    }

    @Test
    void testIncome_customerUnder20k_false() {
        assertFalse(tom.toIssue(kevin));
        assertFalse(bob.toIssue(kevin));
        assertFalse(luc.toIssue(kevin));
        assertFalse(carl.toIssue(kevin));
    }

    @Test
    void testIsLazy_customerOlder18_ok() {
        assertTrue(tom.toIssue(ted));
        assertTrue(tom.toIssue(agatha));
        assertTrue(tom.toIssue(arthur));
        assertTrue(tom.toIssue(chantale));

        assertTrue(luc.toIssue(ted));
        assertTrue(luc.toIssue(agatha));
        assertTrue(luc.toIssue(arthur));
        assertTrue(luc.toIssue(chantale));
    }

    @Test
    void testIsKindNotLazy_customerUnder70_ok() {
        assertFalse(bob.toIssue(maria));
        assertTrue(bob.toIssue(ted));
        assertTrue(bob.toIssue(agatha));
        assertFalse(bob.toIssue(arthur));
        assertFalse(bob.toIssue(kevin));
        assertTrue(bob.toIssue(chantale));
    }

    @Test
    void testNotLazyNotKind_customerOver70AndOver20k_false() {
        assertFalse(carl.toIssue(arthur));
    }

    @Test
    void testKindCustomerUnderAndOver50_ok(){


    }

}