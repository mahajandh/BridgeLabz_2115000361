import java.util.ArrayList;

public class SuppressWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Java");
        list.add("Python");

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
