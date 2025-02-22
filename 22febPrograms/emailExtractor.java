import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class EmailExtractor {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        if (text == null) return emails;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static class EmailExtractorTest {
        private final EmailExtractor extractor = new EmailExtractor();

        @Test
        void testExtractMultipleEmails() {
            String text = "Contact us at support@example.com and info@company.org";
            List<String> expected = List.of("support@example.com", "info@company.org");
            assertEquals(expected, extractor.extractEmails(text));
        }

        @Test
        void testExtractSingleEmail() {
            String text = "Reach out at hello@domain.com";
            List<String> expected = List.of("hello@domain.com");
            assertEquals(expected, extractor.extractEmails(text));
        }

        @Test
        void testNoEmails() {
            String text = "No emails here!";
            assertTrue(extractor.extractEmails(text).isEmpty());
        }
    }
}
