import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class DateExtractor {
    private static final String DATE_PATTERN = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    public List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        if (text == null) return dates;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static class DateExtractorTest {
        private final DateExtractor extractor = new DateExtractor();

        @Test
        void testExtractDates() {
            String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
            List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
            assertEquals(expected, extractor.extractDates(text));
        }

        @Test
        void testNoDates() {
            String text = "No dates in this sentence.";
            assertTrue(extractor.extractDates(text).isEmpty());
        }
    }
}
