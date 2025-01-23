import java.util.Scanner;

public class SmallestNumberChecker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int num3 = s.nextInt();
        s.close();

        System.out.println("Is the first number the smallest? " + (num1 < num2 && num1 < num3));
}}