import java.util.*;

class BankingSystem {
    private Map<String, Double> accountBalances = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accountBalances.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void requestWithdrawal(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displayAccounts() {
        System.out.println("Accounts: " + accountBalances);
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("12345", 5000.0);
        bank.addAccount("67890", 3000.0);
        bank.addAccount("54321", 7000.0);
        
        bank.requestWithdrawal("12345");
        bank.requestWithdrawal("67890");
        
        bank.displayAccounts();
        bank.processWithdrawals();
    }
}
