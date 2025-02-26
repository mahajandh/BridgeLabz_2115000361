import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("users.json"));

            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    System.out.println(node);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
