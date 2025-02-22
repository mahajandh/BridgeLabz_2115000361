import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class LicensePlateValidator {
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\d{4}$";
    private static final Pattern pattern = Pattern.compile(LICENSE_PLATE_PATTERN);

    public boolean isValidLicensePlate(String plate) {
        return plate != null && pattern.matcher(plate).matches();
    }

    public static class LicensePlateValidatorTest {
        private final LicensePlateValidator validator = new LicensePlateValidator();

        @Test
        void testValidLicensePlate() {
            assertTrue(validator.isValidLicensePlate("AB1234"));
        }

        @Test
        void testInvalidFormatMissingLetter() {
            assertFalse(validator.isValidLicensePlate("A12345"));
        }

        @Test
        void testInvalidFormatExtraDigit() {
            assertFalse(validator.isValidLicensePlate("AB12345"));
        }

        @Test
        void testInvalidLowerCaseLetters() {
            assertFalse(validator.isValidLicensePlate("ab1234"));
        }

        @Test
        void testInvalidCharacters() {
            assertFalse(validator.isValidLicensePlate("AB12A4"));
        }
    }
}
