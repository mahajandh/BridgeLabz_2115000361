public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = s.nextInt();
        s.close();

        System.out.println(n + " is " + (n % 5 == 0 ? "" : "not ") + "divisible by 5.");
    }
}

