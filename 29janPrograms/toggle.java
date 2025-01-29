import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        StringBuilder toggled = new StringBuilder();

        for (char ch : str.toCharArray()) {
            toggled.append(Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
        }
        System.out.println("Toggled String: " + toggled);
    }
}
