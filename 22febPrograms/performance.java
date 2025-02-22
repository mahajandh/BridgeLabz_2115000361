import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulate long task
        return "Task Completed";
    }

    public static class PerformanceTestCases {
        private final PerformanceTest performanceTest = new PerformanceTest();

        @Test
        @Timeout(value = 2, unit = TimeUnit.SECONDS)
        void testLongRunningTask() throws InterruptedException {
            performanceTest.longRunningTask();
        }
    }
}
