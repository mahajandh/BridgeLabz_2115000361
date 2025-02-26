import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonExample {
    public static void main(String[] args) {
        String json = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"age\": 30 }";

        if (isValidJson(json)) {
            System.out.println("Valid JSON structure.");
        } else {
            System.out.println("Invalid JSON structure.");
        }
    }

    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(json);
            
            // Ensure required fields exist
            return node.has("name") && node.has("email") && node.has("age");
        } catch (Exception e) {
            return false; // Invalid JSON format
        }
    }
}
