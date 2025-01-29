import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        Map<Character, Integer> freq = new HashMap<>();
        char maxChar = ' ';
        int maxCount = 0;

        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) > maxCount) {
                maxCount = freq.get(ch);
                maxChar = ch;
            }
        }
        System.out.println("Most Frequent Character: " + maxChar);
    }
}
