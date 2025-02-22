import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class LinkExtractor {
    private static final String LINK_PATTERN = "https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/[a-zA-Z0-9._%+-]*)*";
    private static final Pattern pattern = Pattern.compile(LINK_PATTERN);

    public List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null) return links;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static class LinkExtractorTest {
        private final LinkExtractor extractor = new LinkExtractor();

        @Test
        void testExtractLinks() {
            String text = "Visit https://www.google.com and http://example.org for more info.";
            List<String> expected = List.of("https://www.google.com", "http://example.org");
            assertEquals(expected, extractor.extractLinks(text));
        }

        @Test
        void testNoLinks() {
            String text = "No links in this sentence.";
            assertTrue(extractor.extractLinks(text).isEmpty());
        }
    }
}
