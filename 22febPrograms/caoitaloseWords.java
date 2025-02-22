import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractCapitalizedWords {
    private static final String CAPITALIZED_WORD_PATTERN = "\\b[A-Z][a-z]*\\b";
    private static final Pattern pattern = Pattern.compile(CAPITALIZED_WORD_PATTERN);

    public List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static class ExtractCapitalizedWordsTest {
        private final ExtractCapitalizedWords extractor = new ExtractCapitalizedWords();

        @Test
        void testExtractCapitalizedWords() {
            String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
            List<String> expected = List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
            assertEquals(expected, extractor.extractCapitalizedWords(input));
        }
        
        @Test
        void testNoCapitalizedWords() {
            String input = "this sentence has no capitalized words.";
            List<String> expected = List.of();
            assertEquals(expected, extractor.extractCapitalizedWords(input));
        }
    }
}
