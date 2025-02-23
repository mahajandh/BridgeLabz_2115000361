import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 2: Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 3: Apply annotation multiple times to a method
class IssueTracker {
    @BugReport(description = "Fix memory leak issue")
    @BugReport(description = "Resolve concurrency problem")
    public void resolveBugs() {
        System.out.println("Bugs resolved!");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection API
public class BugReportProcessor {
    public static void main(String[] args) throws Exception {
        Method method = IssueTracker.class.getMethod("resolveBugs");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Report: " + bugReport.description());
            }
        }
    }
}
