import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) { this.name = name; this.age = age; }

    public String getName() { return name; }
    public int getAge() { return age; }
}

public class ListToJson {
    public static void main(String[] args) {
        try {
            List<User> userList = new ArrayList<>();
            userList.add(new User("Alice", 28));
            userList.add(new User("Bob", 22));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(userList);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
