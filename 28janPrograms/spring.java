public class SpringSeason {

    // Method to check if the date is in Spring season
    static boolean isSpringSeason(int month, int day) {
        // Spring season starts from March 20 (month 3, day 20) to June 20 (month 6, day 20)
        
        if ((month > 3 && month < 6) || 
            (month == 3 && day >= 20) || 
            (month == 6 && day <= 20)) {
            return true; // Spring season
        }
        return false; // Not in Spring season
    }

    public static void main(String[] args) {
        // Get month and day from the command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if it's Spring season and print the appropriate message
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
