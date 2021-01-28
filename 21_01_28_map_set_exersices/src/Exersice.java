import java.util.*;

public class Exersice {


    public Set<Integer> allIndividuals(List<Integer> list) {
        return new TreeSet<>(list);
    }

    public Map<String, List<Auto>> groupByBrand(List<Auto> autos) {

        Map<String, List<Auto>> res = new TreeMap<>();
        for (Auto auto : autos) {


            if (res.get(auto.getBrand()) == null) {
                res.put(auto.getBrand(), new ArrayList<>());
                res.get(auto.getBrand()).add(auto);
            } else
                res.get(auto.getBrand()).add(auto);
        }
        return res;
    }

    public Map<String, List<String>> groupByFirstLetter(List<String> words) {

        Map<String, List<String>> res = new TreeMap<>();
        for (String word : words) {


            if (res.get(word.substring(0, 1)) == null) {
                res.put(word.substring(0, 1), new ArrayList<>());
                res.get(word.substring(0, 1)).add(word);
            } else
                res.get(word.substring(0, 1)).add(word);
        }
        return res;
    }
}
