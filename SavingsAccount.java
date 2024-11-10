import java.time.LocalDate;

public class SavingsAccount extends Account {
    private static double interestRate = 5.0; // Default interest rate
    private double minBalance;
    private double transactionLimit;
    private int maxNoTransactions;
    private double minBalanceFine;
    private boolean isViolating;
    private int currentTransactions;
    private LocalDate lastMinBalanceDate;

    public SavingsAccount(Customer accountHolder, Branch branch, double minBalance, double transactionLimit, int maxNoTransactions) {
        super(accountHolder, branch);
        this.minBalance = minBalance;
        this.transactionLimit = transactionLimit;
        this.maxNoTransactions = maxNoTransactions;
        this.isViolating = false;
        this.currentTransactions = 0;
        minBalanceFine = 1000;
    }

    public double calculateInterest() {
        // Assuming interest is calculated on the current getBalance()
        return getBalance() * (interestRate / 100);
    }

    public boolean withdraw(double amount) {
        boolean success = false; // Track if withdrawal is successful
        if (getBalance() - amount >= minBalance) {
            super.withdraw(amount);
            success = true;
            if (getBalance() < minBalance && lastMinBalanceDate == null) {
                lastMinBalanceDate = LocalDate.now();
            }
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient getBalance() to meet minimum getBalance() requirements.");
        }
        return success;
    }

    public boolean deposit(double amount) {
        boolean success = false; // Track if deposit is successful
        if (amount > 0) {
            super.deposit(amount);
            success = true;
            if (getBalance() >= minBalance) {
                lastMinBalanceDate = null;
            }
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
        return success;
    }

    public double getBalance() {
        return super.getBalance();
    }

    void imposeFine() {
        LocalDate currentDate = LocalDate.now();
        if (lastMinBalanceDate != null) {
                while (lastMinBalanceDate.plusDays(30).isBefore(currentDate) || lastMinBalanceDate.plusDays(30).isEqual(currentDate)) {
                    if (getBalance() < minBalance) {
            super.withdraw(minBalanceFine);
                        System.out.println("Applied minimum balance fine of " + minBalanceFine + " for one cycle.");
                    }
                    lastMinBalanceDate = lastMinBalanceDate.plusDays(30);
                }
        }
    }
}
