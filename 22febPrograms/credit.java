import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        String[] testCards = {"4111111111111111", "5111111111111111", "6111111111111111", "4222222222222", "5000111122223333"};

        for (String card : testCards) {
            if (isValidCreditCard(card)) {
                System.out.println("✅ \"" + card + "\" → Valid");
            } else {
                System.out.println("❌ \"" + card + "\" → Invalid");
            }
        }
    }
}
