import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get the number of students from user input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        
        // Calculate the maximum number of handshakes using the combination formula
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        // Display the result
        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is " + handshakes);
        
        input.close();
    }
}