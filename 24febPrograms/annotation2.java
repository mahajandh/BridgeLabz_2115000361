import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Step 2: Apply annotation to methods
class Service {
    @ImportantMethod
    public void criticalOperation() {
        System.out.println("Executing critical operation");
    }

    @ImportantMethod(level = "MEDIUM")
    public void secondaryOperation() {
        System.out.println("Executing secondary operation");
    }

    public void normalOperation() {
        System.out.println("Executing normal operation");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}
