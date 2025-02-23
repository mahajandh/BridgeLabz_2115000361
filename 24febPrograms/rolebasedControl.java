import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Step 2: Apply annotation to restricted methods
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }
}

// Step 3: Simulate user roles and validate access
class AccessControl {
    private String currentUserRole;

    public AccessControl(String role) {
        this.currentUserRole = role;
    }

    public void executeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(currentUserRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test role-based access control
public class RoleBasedAccessControl {
    public static void main(String[] args) {
        SecureService service = new SecureService();
        AccessControl adminAccess = new AccessControl("ADMIN");
        AccessControl userAccess = new AccessControl("USER");

        System.out.println("Admin trying to execute adminTask:");
        adminAccess.executeMethod(service, "adminTask");

        System.out.println("User trying to execute adminTask:");
        userAccess.executeMethod(service, "adminTask");
    }
}
