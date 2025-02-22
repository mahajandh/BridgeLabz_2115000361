import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public static class BankAccountTest {
        @Test
        void testDeposit() {
            BankAccount account = new BankAccount(100);
            account.deposit(50);
            assertEquals(150, account.getBalance());
        }

        @Test
        void testWithdrawSuccess() {
            BankAccount account = new BankAccount(100);
            assertTrue(account.withdraw(50));
            assertEquals(50, account.getBalance());
        }

        @Test
        void testWithdrawFailure() {
            BankAccount account = new BankAccount(100);
            assertFalse(account.withdraw(150));
            assertEquals(100, account.getBalance());
        }
    }
}
