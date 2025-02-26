import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.util.Set;

public class ValidateEmailJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("user.json"));
            JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
            JsonSchema schema = factory.getSchema(schemaNode);

            Set<ValidationMessage> errors = schema.validate(jsonNode);
            if (errors.isEmpty()) {
                System.out.println("Valid JSON");
            } else {
                errors.forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
