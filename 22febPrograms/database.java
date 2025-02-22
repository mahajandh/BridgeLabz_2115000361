import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnection {
    private boolean isConnected;

    public void connect() {
        isConnected = true;
    }

    public void disconnect() {
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public static class DatabaseConnectionTest {
        private DatabaseConnection dbConnection;

        @BeforeEach
        void setUp() {
            dbConnection = new DatabaseConnection();
            dbConnection.connect();
        }

        @AfterEach
        void tearDown() {
            dbConnection.disconnect();
        }

        @Test
        void testConnectionEstablished() {
            assertTrue(dbConnection.isConnected());
        }

        @Test
        void testConnectionClosed() {
            dbConnection.disconnect();
            assertFalse(dbConnection.isConnected());
        }
    }
}
