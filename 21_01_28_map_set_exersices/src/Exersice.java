import java.util.*;

public class Exersice {


    public Set<Integer> allIndividuals(List<Integer> list) {
        return new TreeSet<>(list);
    }

    public Map<String, List<Auto>> groupByBrand(List<Auto> autos) {
        Set<String> temp = new HashSet<>();
        Map<String, List<Auto>> res = new HashMap();
        for (Auto auto : autos) {
            temp.add(auto.getBrand());
        }
        for (String brand : temp) {
            res.put(brand, new ArrayList<>());
        }
        for (Auto auto : autos) {
            //if(!res.get(auto.getBrand()).contains(auto)) if List ist not individualized
            res.get(auto.getBrand()).add(auto);
        }
        return res;
    }

    public Map<String, List<String>> groupByFirstLetter(List<String> words) {
        Set<String> temp = new HashSet<>();
        Map<String, List<String>> res = new HashMap();
        for (String word : words) {
            temp.add(word.substring(0, 1));
        }
        for (String letter : temp) {
            res.put(letter, new ArrayList<>());
        }
        for (String word : words) {
            //if(!res.get(word.substring(0,1)).contains(word)) if List ist not individualized
            res.get(word.substring(0, 1)).add(word);
        }
        return res;
    }
}
