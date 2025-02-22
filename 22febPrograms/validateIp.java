import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

public class ValidateIPAddress {
    private static final String IP_PATTERN =
            "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
    
    private static final Pattern pattern = Pattern.compile(IP_PATTERN);

    public boolean isValidIPAddress(String ip) {
        if (ip == null) return false;
        return pattern.matcher(ip).matches();
    }

    public static class ValidateIPAddressTest {
        private final ValidateIPAddress validator = new ValidateIPAddress();

        @Test
        void testValidIPAddresses() {
            assertTrue(validator.isValidIPAddress("192.168.1.1"));
            assertTrue(validator.isValidIPAddress("255.255.255.255"));
            assertTrue(validator.isValidIPAddress("0.0.0.0"));
        }
        
        @Test
        void testInvalidIPAddresses() {
            assertFalse(validator.isValidIPAddress("256.100.50.25"));
            assertFalse(validator.isValidIPAddress("192.168.1."));
            assertFalse(validator.isValidIPAddress("192.168.1.1.1"));
            assertFalse(validator.isValidIPAddress("abc.def.ghi.jkl"));
        }
    }
}
