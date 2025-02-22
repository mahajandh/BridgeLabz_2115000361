import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }

    public static class DateFormatterTest {
        private final DateFormatter formatter = new DateFormatter();

        @Test
        void testValidDateFormat() throws ParseException {
            assertEquals("31-12-2023", formatter.formatDate("2023-12-31"));
        }

        @Test
        void testAnotherValidDate() throws ParseException {
            assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
        }

        @Test
        void testInvalidDateFormat() {
            assertThrows(ParseException.class, () -> formatter.formatDate("31/12/2023"));
        }
    }
}
