import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            printJson(rootNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), prefix + field.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (JsonNode arrayNode : node) {
                printJson(arrayNode, prefix);
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }
}
