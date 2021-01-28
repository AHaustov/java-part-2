import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExersiceTest {

    Exersice test = new Exersice();

    @Test
    public void test_allIndividuals() {
        List<Integer> actual = Arrays.asList(1, 2, 1, 2, 3, 4, 5, 2, 1);
        Set<Integer> res = test.allIndividuals(actual);
        assertEquals(5, res.size());
        for (int i = 1; i < 6; i++) {
            assertTrue(res.contains(i));
        }
    }

    @Test
    public void test_carByBrand() {
        List<Auto> carPark = new ArrayList<>();
        carPark.add(new Auto("BMW", "Silver"));
        carPark.add(new Auto("BMW", "Black"));
        carPark.add(new Auto("Opel", "Silver"));
        carPark.add(new Auto("BMW", "Blue"));
        carPark.add(new Auto("Mazda", "Silver"));
        carPark.add(new Auto("Opel", "Red"));
        carPark.add(new Auto("BMW", "Black"));
        carPark.add(new Auto("Mazda", "Red"));
        carPark.add(new Auto("BMW", "Yellow"));
        Map<String, List<Auto>> catalogue = test.groupByBrand(carPark);
        assertEquals(3, catalogue.size());

        assertTrue(catalogue.containsKey("BMW"));
        assertTrue(catalogue.containsKey("Mazda"));
        assertTrue(catalogue.containsKey("Opel"));

        assertEquals(5, catalogue.get("BMW").size());
        assertEquals(2, catalogue.get("Mazda").size());
        assertEquals(2, catalogue.get("Opel").size());
    }


}