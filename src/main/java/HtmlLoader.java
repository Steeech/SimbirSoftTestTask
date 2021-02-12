import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.*;

public class HtmlLoader {
    public static boolean downloadHtml(String inputHTML) throws IOException {
        String outputFileName = "result.html";
        try {
            Document document = Jsoup.connect(inputHTML).userAgent("Chrome/81.0.4044.138").get();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                for (String value : document.html().split("\n")) {
                    writer.write(value + "\n");
                }
            }
            catch (IOException e) {
                return false;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Некорректно введен адрес страницы");
            return false;
        }
        return true;
    }

    public static List<String> parseHTML(String inputHTML) throws IOException {
        List<String> result = new ArrayList<>();

        try {
            File file = new File("result.html");
            Document document = Jsoup.parse(file, "UTF-8", inputHTML);
            for (Element element : document.getElementsByTag("body")){
                Collections.addAll(result, element.text().toUpperCase().split("[\\s.,!?;:()\\\\\\]\\[\"]+"));
            }

        }
        catch (FileNotFoundException e){
            result.add("Файл html-страницы отсутствует или не найден");
        }
        return  result;
    }
}
