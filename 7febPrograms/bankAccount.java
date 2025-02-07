class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display basic account details
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Abstract method for account type (to be implemented by subclasses)
    void displayAccountType() {
        System.out.println("Account Type: General Bank Account");
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);  // Calling BankAccount constructor
        this.interestRate = interestRate;
    }

    // Overriding displayAccountType method
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    // Constructor
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);  // Calling BankAccount constructor
        this.withdrawalLimit = withdrawalLimit;
    }

    // Overriding displayAccountType method
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int depositTerm;  // In months

    // Constructor
    FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);  // Calling BankAccount constructor
        this.depositTerm = depositTerm;
    }

    // Overriding displayAccountType method
    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Main Class to test Bank Account Types
public class BankAccountSystem {
    public static void main(String[] args) {
        // Creating objects for different account types
        BankAccount savings = new SavingsAccount("SA12345", 5000.0, 2.5);
        BankAccount checking = new CheckingAccount("CA67890", 1500.0, 1000.0);
        BankAccount fixedDeposit = new FixedDepositAccount("FDA11223", 10000.0, 12);

        // Displaying details of each account type
        System.out.println("Savings Account Details:");
        savings.displayAccountInfo();
        savings.displayAccountType();
        System.out.println();

        System.out.println("Checking Account Details:");
        checking.displayAccountInfo();
        checking.displayAccountType();
        System.out.println();

        System.out.println("Fixed Deposit Account Details:");
        fixedDeposit.displayAccountInfo();
        fixedDeposit.displayAccountType();
    }
}
