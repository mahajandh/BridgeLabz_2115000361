import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Step 2: Apply annotation to a User class
class User {
    @JsonField(name = "user_name")
    private String username;
    
    @JsonField(name = "user_age")
    private int age;
    
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// Step 3: Implement JSON serialization using reflection
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonElements = new HashMap<>();
            
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonElements.put(annotation.name(), field.get(obj).toString());
                }
            }
            
            StringBuilder json = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
                json.append("\"" + entry.getKey() + "\": \"" + entry.getValue() + "\", ");
            }
            if (json.length() > 1) {
                json.setLength(json.length() - 2); // Remove trailing comma
            }
            json.append("}");
            
            return json.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error serializing object to JSON", e);
        }
    }
}

// Step 4: Test JSON serialization
public class JsonFieldProcessor {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 25);
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}