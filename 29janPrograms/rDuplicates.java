import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        Set<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) set.add(ch);
        for (char ch : set) System.out.print(ch);
    }
}

