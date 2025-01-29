import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String word = sc.next();
        System.out.print("Enter replacement word: ");
        String replacement = sc.next();

        String modified = sentence.replace(word, replacement);
        System.out.println("Modified Sentence: " + modified);
    }
}

