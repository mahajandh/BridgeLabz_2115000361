
import java.util.ArrayList;

// Account class
class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{accountNumber=" + accountNumber + ", balance=" + balance + ", bank=" + bank.getName() + "}";
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

// Bank class
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer, int accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }
}

// Main class to demonstrate association
public class BankSystem {
    public static void main(String[] args) {
        // Create bank
        Bank bank = new Bank("National Bank");

        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Open accounts
        bank.openAccount(customer1, 1001, 500.00);
        bank.openAccount(customer1, 1002, 1500.00);
        bank.openAccount(customer2, 2001, 2000.00);

        // View balances
        customer1.viewBalance();
        customer2.viewBalance();
    }
}

