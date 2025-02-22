import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        String[] testUsernames = {"user_123", "123user", "us", "valid_name", "VeryLongUsername123"};

        for (String username : testUsernames) {
            if (isValidUsername(username)) {
                System.out.println("✅ \"" + username + "\" → Valid");
            } else {
                System.out.println("❌ \"" + username + "\" → Invalid");
            }
        }
    }
}
