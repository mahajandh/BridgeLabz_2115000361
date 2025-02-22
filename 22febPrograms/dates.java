import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractDates {
    private static final String DATE_PATTERN = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    public List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static class ExtractDatesTest {
        private final ExtractDates extractor = new ExtractDates();

        @Test
        void testExtractDates() {
            String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
            List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
            assertEquals(expected, extractor.extractDates(input));
        }
        
        @Test
        void testNoDates() {
            String input = "There are no dates in this text.";
            List<String> expected = List.of();
            assertEquals(expected, extractor.extractDates(input));
        }
    }
}
