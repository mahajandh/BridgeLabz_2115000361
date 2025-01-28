  public class FootballTeamHeights {

    // Method to generate random heights for 11 players in the range of 150 to 250 cm
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        
        for (int i = 0; i < size; i++) {
            // Generate a random height between 150 and 250 cm
            heights[i] = (int) (Math.random() * 101) + 150; // Random number between 150 and 250
        }
        
        return heights;
    }

    // Method to find the sum of all heights in the array
    public static int findSumOfHeights(int[] heights) {
        int sum = 0;
        
        for (int height : heights) {
            sum += height;
        }
        
        return sum;
    }

    // Method to find the mean height
    public static double findMeanHeight(int[] heights) {
        int sum = findSumOfHeights(heights);
        return (double) sum / heights.length;
    }

    // Method to find the shortest height
    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        
        return shortest;
    }

    // Method to find the tallest height
    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        
        return tallest;
    }

    public static void main(String[] args) {
        // Generate random heights for 11 players
        int[] heights = generateRandomHeights(11);

        // Print the heights of all players
        System.out.print("Heights of players: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        // Calculate and display the sum, mean, shortest and tallest heights
        int sum = findSumOfHeights(heights);
        double mean = findMeanHeight(heights);
        int shortest = findShortestHeight(heights);
        int tallest = findTallestHeight(heights);

        System.out.println("Sum of all heights: " + sum + " cm");
        System.out.println("Mean height: " + mean + " cm");
        System.out.println("Shortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
    }
}
