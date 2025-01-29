import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        int gcd = computeGCD(num1, num2);
        int lcm = computeLCM(num1, num2, gcd);
        
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
        
        scanner.close();
    }
    
    private static int computeGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return computeGCD(b, a % b);
    }
    
    private static int computeLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
