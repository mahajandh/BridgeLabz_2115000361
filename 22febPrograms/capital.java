import java.util.*;
import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractCapitalizedWords(text);
        System.out.println(String.join(", ", words));  
        // Output: Eiffel, Tower, Paris, Statue, Liberty, New, York
    }
}
