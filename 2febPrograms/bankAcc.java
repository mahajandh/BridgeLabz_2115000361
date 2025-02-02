class BankAccount {
    public String accountNumber;  // Public variable
    protected String accountHolder;  // Protected variable
    private double balance;  // Private variable

    // Constructor to initialize bank account details
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get the balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify the balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount.");
        }
    }

    // Method to display bank account details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass SavingsAccount demonstrating the use of access modifiers
class SavingsAccount extends BankAccount {

    // Constructor to initialize savings account details
    SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Method to display savings account details (accessing protected and public members)
    void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);  // Accessing public variable
        System.out.println("Account Holder: " + accountHolder);  // Accessing protected variable
        System.out.println("Balance: $" + getBalance());  // Accessing private member via public method
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        // Creating a BankAccount instance
        BankAccount account = new BankAccount("123456789", "John Doe", 1500.50);
        account.displayAccountDetails();

        // Modifying the balance using setter method
        account.setBalance(2000.75);
        System.out.println("\nAfter Balance Update:");
        account.displayAccountDetails();

        // Creating a SavingsAccount instance
        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Jane Smith", 3000.00);
        savingsAccount.displaySavingsAccountDetails();
    }
}
