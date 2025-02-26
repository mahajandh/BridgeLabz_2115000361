import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            // Process JSON File
            processJsonFile("ipl_data.json", "ipl_data_censored.json");

            // Process CSV File
            processCsvFile("ipl_data.csv", "ipl_data_censored.csv");

            System.out.println("✅ Data processing completed. Check output files.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Process JSON Data
    private static void processJsonFile(String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = (ArrayNode) objectMapper.readTree(new File(inputFile));

            for (JsonNode node : jsonArray) {
                ((ObjectNode) node).put("team1", maskTeamName(node.get("team1").asText()));
                ((ObjectNode) node).put("team2", maskTeamName(node.get("team2").asText()));
                ((ObjectNode) node).put("winner", maskTeamName(node.get("winner").asText()));
                ((ObjectNode) node).put("player_of_match", "REDACTED");

                // Update score keys
                ObjectNode scoreNode = (ObjectNode) node.get("score");
                ObjectNode updatedScore = objectMapper.createObjectNode();
                
                Iterator<String> keys = scoreNode.fieldNames();
                while (keys.hasNext()) {
                    String key = keys.next();
                    updatedScore.put(maskTeamName(key), scoreNode.get(key).asInt());
                }
                ((ObjectNode) node).set("score", updatedScore);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Process CSV Data
    private static void processCsvFile(String inputFile, String outputFile) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonArray = csvMapper.readerFor(JsonNode.class).with(schema).readTree(new File(inputFile));
            FileWriter writer = new FileWriter(outputFile);
            writer.write("match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n");

            for (JsonNode node : jsonArray) {
                writer.write(
                        node.get("match_id").asText() + "," +
                        maskTeamName(node.get("team1").asText()) + "," +
                        maskTeamName(node.get("team2").asText()) + "," +
                        node.get("score_team1").asText() + "," +
                        node.get("score_team2").asText() + "," +
                        maskTeamName(node.get("winner").asText()) + "," +
                        "REDACTED\n"
                );
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Mask team names (Replace last word with "***")
    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}
