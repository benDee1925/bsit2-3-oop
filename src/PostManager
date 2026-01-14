class BankAccount {
    private static String bankName = "Liceo Bank";
    private static int totalAccounts = 0;
    private static double interestRate = 0.03; // 3%


    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
        System.out.println("Account Created: " + accountNumber + " for " + accountHolderName + " with initial balance: $" + balance);
    }


    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolderName + " deposited $" + amount + ". New balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolderName + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance for " + accountHolderName);
        }
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }

    public static void displayTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
