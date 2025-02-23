import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Step 2: Apply annotation to a field in the User class
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Test the annotation validation
public class AnnotationValidator {
    public static void main(String[] args) {
        try {
            User validUser = new User("JohnDoe");
            System.out.println("Valid username: " + validUser);
            
            User invalidUser = new User("VeryLongUsername"); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
