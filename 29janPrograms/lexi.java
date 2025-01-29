import java.util.Scanner;

public class LexicographicalComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int result = s1.compareTo(s2);
        System.out.println(result < 0 ? s1 + " comes before " + s2 : result > 0 ? s2 + " comes before " + s1 : "Both strings are equal");
    }
}
