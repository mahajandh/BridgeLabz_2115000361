import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractCurrencyValues {
    private static final String CURRENCY_PATTERN = "\\$?\\d+(\\.\\d{2})?";
    private static final Pattern pattern = Pattern.compile(CURRENCY_PATTERN);

    public List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static class ExtractCurrencyValuesTest {
        private final ExtractCurrencyValues extractor = new ExtractCurrencyValues();

        @Test
        void testExtractCurrencyValues() {
            String input = "The price is $45.99, and the discount is 10.50.";
            List<String> expected = List.of("$45.99", "10.50");
            assertEquals(expected, extractor.extractCurrencyValues(input));
        }
        
        @Test
        void testNoCurrencyValues() {
            String input = "There are no prices mentioned here.";
            List<String> expected = List.of();
            assertEquals(expected, extractor.extractCurrencyValues(input));
        }
    }
}
