import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char remove = sc.next().charAt(0);

        String modified = str.replace(String.valueOf(remove), "");
        System.out.println("Modified String: " + modified);
    }
}
