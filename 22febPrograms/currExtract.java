nimport java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> result = extractCurrencyValues(text);
        System.out.println(String.join(", ", result));  
        // Output: $45.99, 10.50
    }
}
