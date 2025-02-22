import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class CapitalizedWordExtractor {
    private static final String CAPITALIZED_WORD_PATTERN = "\\b[A-Z][a-z]*\\b";
    private static final Pattern pattern = Pattern.compile(CAPITALIZED_WORD_PATTERN);

    public List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        if (text == null) return words;
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static class CapitalizedWordExtractorTest {
        private final CapitalizedWordExtractor extractor = new CapitalizedWordExtractor();

        @Test
        void testExtractCapitalizedWords() {
            String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
            List<String> expected = List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
            assertEquals(expected, extractor.extractCapitalizedWords(text));
        }

        @Test
        void testNoCapitalizedWords() {
            String text = "this is a test sentence.";
            assertTrue(extractor.extractCapitalizedWords(text).isEmpty());
        }
    }
}
