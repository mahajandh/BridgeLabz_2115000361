import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (Jackson needs them for serialization)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Car> carList = new ArrayList<>();
            carList.add(new Car("Toyota", "Camry", 2023));
            carList.add(new Car("Honda", "Civic", 2022));
            carList.add(new Car("Ford", "Mustang", 2021));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(carList);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
