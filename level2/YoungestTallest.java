import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Take input for ages of the 3 friends
        System.out.print("Enter age of Amar: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter age of Akbar: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter age of Anthony: ");
        int anthonyAge = scanner.nextInt();
   System.out.print("Enter height of Amar (in cm): ");
        int amarHeight = scanner.nextInt();
        System.out.print("Enter height of Akbar (in cm): ");
        int akbarHeight = scanner.nextInt();
        System.out.print("Enter height of Anthony (in cm): ");
        int anthonyHeight = scanner.nextInt();

        // Find the youngest friend (smallest age)
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        String youngestFriend = (youngestAge == amarAge) ? "Amar" :
                                 (youngestAge == akbarAge) ? "Akbar" : "Anthony";
        
        // Find the tallest friend (largest height)
        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        String tallestFriend = (tallestHeight == amarHeight) ? "Amar" :
                               (tallestHeight == akbarHeight) ? "Akbar" : "Anthony";

        // Display the results
        System.out.println(youngestFriend + " is the youngest with age " + youngestAge + ".");
        System.out.println(tallestFriend + " is the tallest with height " + tallestHeight + " cm.");

        // Close the scanner
        scanner.close();
    }
}

