import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HtmlLoader {
    public static void downloadHtml(String inputHTML) throws IOException {
        Document document = Jsoup.connect(inputHTML).userAgent("Chrome/81.0.4044.138").get();
        String outputFileName = "result.html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : document.html().split("\n")) {
                writer.write(value + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseHTML(String inputHTML) throws IOException {
        List<String> result = new ArrayList<>();
        File file = new File("result.html");
        Document document = Jsoup.parse(file, "UTF-8", inputHTML);
        for (Element element : document.getElementsByTag("body")){
            Collections.addAll(result, element.text().toUpperCase().split("[\\s.,!?;:()\\\\\\]\\[\"]+"));
        }
        return  result;
    }
}
