import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define a class for testing
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Step 2: Implement the JSON serialization method
public class ObjectToJson {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonElements = new HashMap<>();
            
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                jsonElements.put(field.getName(), field.get(obj).toString());
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
    
    // Step 3: Test the JSON serialization
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        String json = toJson(person);
        System.out.println("JSON Representation: " + json);
    }
}
