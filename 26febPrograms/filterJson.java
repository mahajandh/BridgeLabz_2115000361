import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Iterator;

public class FilterJsonRecords {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\":\"John\",\"age\":30},{\"name\":\"Alice\",\"age\":22},{\"name\":\"Bob\",\"age\":28}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonArray);

            ArrayNode filteredArray = objectMapper.createArrayNode();
            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    filteredArray.add(node);
                }
            }

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
