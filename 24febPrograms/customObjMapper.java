import java.lang.reflect.Field;
import java.util.Map;

// Step 1: Define a generic method to map properties to an object
public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + entry.getKey());
            }
        }
        
        return instance;
    }
    
    // Step 2: Define a sample class for testing
    public static class Person {
        private String name;
        private int age;
        
        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
    
    // Step 3: Test the object mapper
    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of("name", "Alice", "age", 30);
        Person person = toObject(Person.class, properties);
        person.display();
    }
}
