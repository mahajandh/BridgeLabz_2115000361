import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZonesExample {
    public static void main(String[] args) {
        // Get current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        
        // Get current time in IST
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        
        // Get current time in PST
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Define the format for time display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Display the times
        System.out.println("Current Time in GMT: " + gmtTime.format(formatter));
        System.out.println("Current Time in IST: " + istTime.format(formatter));
        System.out.println("Current Time in PST: " + pstTime.format(formatter));
    }
}
