import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Implement the interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Dynamic Proxy Handler
class LoggingHandler implements InvocationHandler {
    private final Object target;
    
    public LoggingHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Step 4: Create a Proxy Instance and Test
public class LoggingProxyDemo {
    public static void main(String[] args) {
        Greeting original = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(), 
            new Class<?>[]{Greeting.class}, 
            new LoggingHandler(original)
        );
        
        proxyInstance.sayHello("Alice");
    }
}
