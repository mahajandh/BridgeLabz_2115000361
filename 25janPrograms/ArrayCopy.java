
import java.util.Scanner;

public class ArrayCopy2DTo1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input for rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();
        
        // Create the 2D array (matrix) and take input for each element
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element for [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Create the 1D array to store the elements from the 2D array
        int[] array = new int[rows * cols];
        
        // Copy elements from the 2D array to the 1D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }
        
        // Display the elements of the 1D array
        System.out.println("The elements copied to the 1D array are:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        sc.close();
    }
}

