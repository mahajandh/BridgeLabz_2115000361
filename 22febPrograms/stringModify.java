import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

public class StringModifier {
    public String replaceMultipleSpaces(String text) {
        if (text == null) return "";
        return text.replaceAll("\\s+", " ").trim();
    }

    public static class StringModifierTest {
        private final StringModifier modifier = new StringModifier();

        @Test
        void testReplaceMultipleSpaces() {
            String input = "This  is   an    example    with   multiple    spaces.";
            String expected = "This is an example with multiple spaces.";
            assertEquals(expected, modifier.replaceMultipleSpaces(input));
        }

        @Test
        void testNoExtraSpaces() {
            String input = "This is fine.";
            assertEquals("This is fine.", modifier.replaceMultipleSpaces(input));
        }

        @Test
        void testEmptyString() {
            String input = "";
            assertEquals("", modifier.replaceMultipleSpaces(input));
        }
    }
}
