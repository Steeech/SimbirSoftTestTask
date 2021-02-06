import java.util.List;
import java.util.TreeMap;

public class Statistic {

    public static TreeMap<String, Integer>  analyzeText(List<String> words){
        TreeMap<String, Integer> dictionary = new TreeMap<>();
        for (String word: words){
            Integer value = dictionary.get(word);
            if (value!=null){
                dictionary.put(word, value+1);
            }
            else{
                dictionary.put(word, 1);
            }
        }
        return dictionary;
    }

}
