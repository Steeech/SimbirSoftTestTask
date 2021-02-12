import java.util.List;
import java.util.TreeMap;

public class Statistic {

    public static TreeMap<String, Integer>  analyzeText(List<String> words){
        TreeMap<String, Integer> dictionary = new TreeMap<>();
        for (String word: words){
            dictionary.merge(word, 1, Integer::sum);
        }
        return dictionary;
    }

}
