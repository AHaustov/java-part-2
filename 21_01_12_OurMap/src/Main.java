import java.util.Iterator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        OurHashMap<Integer, Integer> map = new OurHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i * 2, i * 11);
        }
        Iterator<Integer> it = map.keyIterator();
        int i = 0;
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
        Iterator<Integer> vit = map.valueIterator();
        while (vit.hasNext())
            System.out.print(vit.next() + " ");
    }
}
    class Auto {
        private final String make;

        private final String color;

        public Auto(String make, String color) {
            this.make = make;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Auto)) return false;
            Auto auto = (Auto) o;
            return Objects.equals(make, auto.make) &&
                    Objects.equals(color, auto.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(make, color);
        }
}
