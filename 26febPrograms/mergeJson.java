import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Create first JSON object
            String json1 = "{ \"name\": \"John Doe\", \"age\": 30 }";
            JsonNode node1 = objectMapper.readTree(json1);

            // Create second JSON object
            String json2 = "{ \"email\": \"john.doe@example.com\", \"city\": \"New York\" }";
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge both JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            // Print merged JSON
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
