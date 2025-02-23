import java.lang.reflect.Field;

// Step 1: Define the Configuration class with a private static field
class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
    
    public static String getApiKey() {
        return API_KEY;
    }
}

// Step 2: Use Reflection to modify and access the static field
public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        // Access the private static field "API_KEY"
        Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        
        // Modify the private static field
        apiKeyField.set(null, "NEW_SECURE_KEY");
        
        // Print the modified value
        System.out.println("Modified API_KEY: " + Configuration.getApiKey());
    }
}
