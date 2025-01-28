public class RandomNumbers {

    // Method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        
        for (int i = 0; i < size; i++) {
            // Generate a 4-digit random number
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000; // Random number between 1000 and 9999
        }
        
        return randomNumbers;
    }

    // Method to find the average, minimum, and maximum value of an array
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        // Calculate sum, min, and max
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Calculate average
        double average = sum / numbers.length;

        // Return the average, min, and max in a double array
        return new double[] {average, min, max};
    }

    public static void main(String[] args) {
        // Generate 5 random 4-digit numbers
        int[] randomNumbers = generate4DigitRandomArray(5);

        // Print the generated random numbers
        System.out.print("Generated Random Numbers: ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }

        // Find average, min, and max
        double[] results = findAverageMinMax(randomNumbers);

        // Display the results
        System.out.println("\nAverage: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}

