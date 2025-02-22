import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class HexColorValidator {
    private static final String HEX_COLOR_PATTERN = "^#[0-9A-Fa-f]{6}$";
    private static final Pattern pattern = Pattern.compile(HEX_COLOR_PATTERN);

    public boolean isValidHexColor(String color) {
        return color != null && pattern.matcher(color).matches();
    }

    public static class HexColorValidatorTest {
        private final HexColorValidator validator = new HexColorValidator();

        @Test
        void testValidUppercaseHexColor() {
            assertTrue(validator.isValidHexColor("#FFA500"));
        }

        @Test
        void testValidLowercaseHexColor() {
            assertTrue(validator.isValidHexColor("#ff4500"));
        }

        @Test
        void testInvalidShortHexColor() {
            assertFalse(validator.isValidHexColor("#123"));
        }

        @Test
        void testInvalidMissingHash() {
            assertFalse(validator.isValidHexColor("FFA500"));
        }

        @Test
        void testInvalidNonHexCharacters() {
            assertFalse(validator.isValidHexColor("#ZZZZZZ"));
        }
    }
}
