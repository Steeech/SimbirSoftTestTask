import java.io.IOException;
import java.util.*;

public class testSimbirSoft {

    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            boolean correct  = HtmlLoader.downloadHtml(input);
            if (correct) {
                List<String> results = HtmlLoader.parseHTML(input);
                TreeMap<String, Integer> dictionary = Statistic.analyzeText(results);
                for (HashMap.Entry result : dictionary.entrySet()) {
                    System.out.println(result.getKey() + " - " + result.getValue());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
        }
    }
}
