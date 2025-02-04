
class BankAccount {
    private static String bankName = "XYZ Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Balance: $" + this.balance);
        } else {
            System.out.println("Invalid account instance.");
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001, 500.0);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002, 1000.0);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}

