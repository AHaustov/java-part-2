import java.util.Comparator;

public class CarsComparator implements Comparator<Cars> {
    @Override
    public int compare(Cars c1, Cars c2) {
        if (c1.getMileage() != c2.getMileage())
            return c2.getMileage() - c1.getMileage();
        return c2.getAge() - c1.getAge();
    }

}
