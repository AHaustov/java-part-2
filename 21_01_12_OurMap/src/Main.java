import java.util.Iterator;

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
            System.out.print(it.next()+" ");
        System.out.println();
        Iterator<Integer> vit = map.valueIterator();
        while (vit.hasNext())
            System.out.print(vit.next()+" ");
    }


}
