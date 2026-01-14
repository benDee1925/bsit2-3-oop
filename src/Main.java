public class Main {
    public static void main(String[] args) {
        BankAccount.displayBankInfo();
        System.out.println();

        BankAccount account1 = new BankAccount("John Doe", 1000.0);
        BankAccount account2 = new BankAccount("Jane Smith", 2500.0);
        BankAccount account3 = new BankAccount("Bob Johnson", 500.0);

        System.out.println("\n==== Account Operations ====");
        account1.deposit(500.0);
        account2.withdraw(300.0);

        System.out.println("\n==== Interest Calculation ====");
        System.out.println(account1.getAccountHolderName() + "'s interest: $" + account1.calculateInterest());
        System.out.println(account2.getAccountHolderName() + "'s interest: $" + account2.calculateInterest());
        System.out.println(account3.getAccountHolderName() + "'s interest: $" + account3.calculateInterest());

        System.out.println();
        BankAccount.displayTotalAccounts();
    }
}
