import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for current accounts
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance + overdraftLimit >= 5000;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        BankAccount savings = new SavingsAccount("S101", "Alice", 10000, 5);
        BankAccount current = new CurrentAccount("C202", "Bob", 5000, 2000);
        
        accounts.add(savings);
        accounts.add(current);
        
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + " | Holder: " + account.getHolderName() + " | Balance: " + account.getBalance() + " | Interest: " + account.calculateInterest());
            
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(10000);
                System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            }
        }
    }
}

