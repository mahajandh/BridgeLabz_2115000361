import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

public class ValidateCreditCard {
    private static final String VISA_PATTERN = "^4[0-9]{15}$";
    private static final String MASTERCARD_PATTERN = "^5[1-5][0-9]{14}$";
    
    private static final Pattern visaPattern = Pattern.compile(VISA_PATTERN);
    private static final Pattern masterCardPattern = Pattern.compile(MASTERCARD_PATTERN);

    public boolean isValidCreditCard(String cardNumber) {
        if (cardNumber == null) return false;
        return visaPattern.matcher(cardNumber).matches() || masterCardPattern.matcher(cardNumber).matches();
    }

    public static class ValidateCreditCardTest {
        private final ValidateCreditCard validator = new ValidateCreditCard();

        @Test
        void testValidVisaCards() {
            assertTrue(validator.isValidCreditCard("4111111111111111"));
            assertTrue(validator.isValidCreditCard("4000123456789012"));
        }
        
        @Test
        void testValidMasterCards() {
            assertTrue(validator.isValidCreditCard("5105105105105100"));
            assertTrue(validator.isValidCreditCard("5500000000000004"));
        }
        
        @Test
        void testInvalidCreditCards() {
            assertFalse(validator.isValidCreditCard("1234567812345678"));
            assertFalse(validator.isValidCreditCard("4111111111111"));
            assertFalse(validator.isValidCreditCard("51051051051051"));
            assertFalse(validator.isValidCreditCard("6011111111111117")); // Not Visa or MasterCard
        }
    }
}
