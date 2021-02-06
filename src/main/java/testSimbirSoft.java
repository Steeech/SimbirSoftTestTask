import java.io.IOException;
import java.util.*;

public class testSimbirSoft {

    public static void main (String[] args) throws IOException {
        String input = "https://teksty-pesenok.ru/";
        HtmlLoader.downloadHtml(input);
        List<String> results = HtmlLoader.parseHTML(input);
        TreeMap<String, Integer> dictionary = Statistic.analyzeText(results);
        for (HashMap.Entry result: dictionary.entrySet()) {
            System.out.println(result.getKey()+" - "+ result.getValue());
        }
    }
}
