import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractEmails {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static class ExtractEmailsTest {
        private final ExtractEmails extractor = new ExtractEmails();

        @Test
        void testExtractEmails() {
            String input = "Contact us at support@example.com and info@company.org";
            List<String> expected = List.of("support@example.com", "info@company.org");
            assertEquals(expected, extractor.extractEmails(input));
        }
        
        @Test
        void testNoEmails() {
            String input = "There are no email addresses here.";
            List<String> expected = List.of();
            assertEquals(expected, extractor.extractEmails(input));
        }
    }
}
