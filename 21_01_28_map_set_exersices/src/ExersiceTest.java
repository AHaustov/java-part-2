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

    @Test
    public void test_groupByFirstLetter() {
        List<String> listFruits = Arrays.asList("banana", "apple", "dragonfruit", "avocado", "pear",
                "raspberry", "pineapple", "strawberry", "orange", "lime", "mango", "passionfruit",
                "blackcurrant", "lemon", "cherry");

        List<String> a = Arrays.asList("apple", "avocado");
        List<String> b = Arrays.asList("banana", "blackcurrant");
        List<String> c = Arrays.asList("cherry");
        List<String> d = Arrays.asList("dragonfruit");
        List<String> l = Arrays.asList("lime", "lemon");
        List<String> m = Arrays.asList("mango");
        List<String> r = Arrays.asList("raspberry");
        List<String> s = Arrays.asList("strawberry");
        List<String> o = Arrays.asList("orange");
        List<String> p = Arrays.asList("pear", "pineapple", "passionfruit");

        Map<String, List<String>> catalogue = test.groupByFirstLetter(listFruits);
        assertEquals(10, catalogue.size());
        for (String fruit : p) {
            assertTrue(catalogue.get("p").contains(fruit));
        }
        for (String fruit : s) {
            assertTrue(catalogue.get("s").contains(fruit));
        }
        for (String fruit : o) {
            assertTrue(catalogue.get("o").contains(fruit));
        }
        for (String fruit : m) {
            assertTrue(catalogue.get("m").contains(fruit));
        }
        for (String fruit : l) {
            assertTrue(catalogue.get("l").contains(fruit));
        }
        for (String fruit : r) {
            assertTrue(catalogue.get("r").contains(fruit));
        }
        for (String fruit : d) {
            assertTrue(catalogue.get("d").contains(fruit));
        }
        for (String fruit : c) {
            assertTrue(catalogue.get("c").contains(fruit));
        }
        for (String fruit : b) {
            assertTrue(catalogue.get("b").contains(fruit));
        }
        for (String fruit : a) {
            assertTrue(catalogue.get("a").contains(fruit));
        }
    }
}